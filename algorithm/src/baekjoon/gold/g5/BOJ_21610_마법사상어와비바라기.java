package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21610_마법사상어와비바라기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] clouds = new int[n + 1][n + 1];
		clouds[n][1] = 1;
		clouds[n][2] = 1;
		clouds[n - 1][1] = 1;
		clouds[n - 1][2] = 1;

		int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
		int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

		for (int i = 1; i <= m * 2; i += 2) {
			st = new StringTokenizer(br.readLine().trim());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			// init done

			// 구름 이동
			List<int[]> moving = new ArrayList<>();
			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					if (clouds[x][y] == i) {
						int nx = x;
						int ny = y;

						for (int j = 0; j < s; j++) {
							nx += dx[d];
							ny += dy[d];

							if (nx == 0)
								nx = n;
							else if (nx == n + 1)
								nx = 1;

							if (ny == 0)
								ny = n;
							else if (ny == n + 1)
								ny = 1;
						}

						map[nx][ny]++;
						moving.add(new int[] { nx, ny });
					}
				}
			}

			for (int[] cur : moving) {
				clouds[cur[0]][cur[1]] = i + 1;
			}

			// 구름 있는 칸 물 증가
			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					if (clouds[x][y] == i + 1) {
						// 인접 칸만큼 물 복사
						int cnt = 0;
						for (int d2 = 2; d2 <= 8; d2 += 2) {
							int nx = x + dx[d2];
							int ny = y + dy[d2];

							if (nx < 1 || ny < 1 || nx > n || ny > n)
								continue;

							if (map[nx][ny] == 0)
								continue;

							cnt++;
						}

						map[x][y] += cnt;
					}
				}
			}

			// 구름 생김
			for (int x = 1; x <= n; x++) {
				C: for (int y = 1; y <= n; y++) {
					if (map[x][y] < 2)
						continue;

					if (clouds[x][y] == i + 1)
						continue C;

					map[x][y] -= 2;
					clouds[x][y] = i + 2;
				}
			}

		}

		int hap = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				hap += map[i][j];
			}
		}
		System.out.println(hap);
	}

}
