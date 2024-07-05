package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][][] map = new int[n + 1][n + 1][4];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j][3] = -1;
			}
		}

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			q.offer(new int[] { r, c, m, s, d });
		}

		// init done

		int ans = 0;
		for (int i = 0; i < k; i++) {
			ans = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();

				int nx = cur[0];
				int ny = cur[1];
				int d = cur[4];

				for (int j = 1; j <= cur[3]; j++) {
					nx += dx[d];
					ny += dy[d];

					if (nx == 0)
						nx = n;
					if (ny == 0)
						ny = n;
					if (nx == n + 1)
						nx = 1;
					if (ny == n + 1)
						ny = 1;
				}

				map[nx][ny][0]++; // 개수
				map[nx][ny][1] += cur[2]; // 질량
				map[nx][ny][2] += cur[3]; // 속력

				if (map[nx][ny][3] == -1)
					map[nx][ny][3] = cur[4];
				else if (map[nx][ny][3] >= 0) {
					if (map[nx][ny][3] % 2 == cur[4] % 2)
						map[nx][ny][3] = cur[4];
					else
						map[nx][ny][3] = -2;
				}
			}

			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					if (map[x][y][0] == 0)
						continue;

					if (map[x][y][0] == 1) {
						ans += map[x][y][1];
						q.offer(new int[] { x, y, map[x][y][1], map[x][y][2], map[x][y][3] });

						// init
						map[x][y][0] = 0;
						map[x][y][1] = 0;
						map[x][y][2] = 0;
						map[x][y][3] = -1;
						continue;
					}

					// 4개의 파이어볼로 나누어짐
					int m = map[x][y][1] / 5;
					if (m == 0) {
						// init
						map[x][y][0] = 0;
						map[x][y][1] = 0;
						map[x][y][2] = 0;
						map[x][y][3] = -1;
						continue;
					}
					ans += m * 4;
					int s = map[x][y][2] / map[x][y][0];
					if (map[x][y][3] == -2) {
						// 1,3,5,7
						for (int j = 1; j < 8; j += 2) {
							q.offer(new int[] { x, y, m, s, j });
						}
					} else {
						// 0,2,4,6
						for (int j = 0; j < 8; j += 2) {
							q.offer(new int[] { x, y, m, s, j });
						}
					}

					// init
					map[x][y][0] = 0;
					map[x][y][1] = 0;
					map[x][y][2] = 0;
					map[x][y][3] = -1;
				}
			}
		}
		System.out.println(ans);
	}

}
