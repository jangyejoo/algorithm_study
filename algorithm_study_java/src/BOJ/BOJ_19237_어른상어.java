package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19237_어른상어 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int surviveShark;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][][] map = new int[n + 1][n + 1][2];
		int[][] sharkInfo = new int[m + 1][3];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if (map[i][j][0] != 0) {
					map[i][j][1] = k;

					sharkInfo[map[i][j][0]][0] = i;
					sharkInfo[map[i][j][0]][1] = j;
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= m; i++) {
			sharkInfo[i][2] = Integer.parseInt(st.nextToken());
		}

		int[][][] priority = new int[m + 1][5][4];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				priority[i][j][0] = Integer.parseInt(st.nextToken());
				priority[i][j][1] = Integer.parseInt(st.nextToken());
				priority[i][j][2] = Integer.parseInt(st.nextToken());
				priority[i][j][3] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		surviveShark = m;
		int ans = 0;

		while (ans <= 1000) {
			mvShark(map, sharkInfo, priority, n, m);

			updateSmell(map, sharkInfo, n, m, k);

			ans++;
			if (surviveShark == 1)
				break;
		}

		if (ans > 1000)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void updateSmell(int[][][] map, int[][] sharkInfo, int n, int m, int k) {

		// 냄새 없애기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j][1] > 0) {
					if (--map[i][j][1] == 0) {
						map[i][j][0] = 0;
					}
				}
			}
		}

		for (int i = 1; i <= m; i++) {
			int[] shark = sharkInfo[i];
			if (shark[0] == 0)
				continue;
			if (map[shark[0]][shark[1]][0] == 0) { // 이동하려는 곳에 다른 상어가 없으면
				map[shark[0]][shark[1]][0] = i;
				map[shark[0]][shark[1]][1] = k;
			} else if (map[shark[0]][shark[1]][0] == i) { // 내 공간
				map[shark[0]][shark[1]][0] = i;
				map[shark[0]][shark[1]][1] = k;
			} else { // 이동하려는 곳에 다른 상어가 있으면
				shark[0] = 0;
				shark[1] = 0;
				shark[2] = 0;
				surviveShark--; // 지금 상어는 없애버리기
			}
		}
	}

	private static void mvShark(int[][][] map, int[][] sharkInfo, int[][][] priority, int n, int m) {
		for (int i = 1; i <= m; i++) {
			if (sharkInfo[i][0] == 0)
				continue;
			int[] empty = new int[3];
			int[] my = new int[3];
			for (int j = 0; j < 4; j++) {
				int d = priority[i][sharkInfo[i][2]][j];

				int nx = sharkInfo[i][0] + dx[d - 1];
				int ny = sharkInfo[i][1] + dy[d - 1];

				if (nx < 1 || ny < 1 || nx > n || ny > n)
					continue;

				if (map[nx][ny][0] == 0) { // 상어의 냄새가 없을 때
					empty[0] = nx;
					empty[1] = ny;
					empty[2] = d;
					break;
				} else if (my[0] == 0 && map[nx][ny][0] == i) { // 내 냄새일 때
					my[0] = nx;
					my[1] = ny;
					my[2] = d;
				}
			}

			if (empty[0] != 0) { // 빈 공간으로 이동
				sharkInfo[i][0] = empty[0];
				sharkInfo[i][1] = empty[1];
				sharkInfo[i][2] = empty[2];
			} else if (my[0] != 0) { // 자기 공간으로 이동
				sharkInfo[i][0] = my[0];
				sharkInfo[i][1] = my[1];
				sharkInfo[i][2] = my[2];
			} else { // 이동할 곳이 없음

			}

		}
	}
}
