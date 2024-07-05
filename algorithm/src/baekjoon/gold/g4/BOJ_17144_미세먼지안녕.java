package baekjoon.gold.g4;

import java.io.*;
import java.util.*;

public class BOJ_17144_미세먼지안녕 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R + 1][C + 1];
		int[][] empty = new int[R + 1][C + 1];

		Queue<int[]> q = new LinkedList<>();
		int airCleanerUp = -1;
		int airCleanerDown = -1;
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != -1 && map[i][j] != 0) {
					int[] pos = { i, j };
					q.offer(pos);
				}
				if (map[i][j] == -1) {
					if (airCleanerUp != -1) {
						airCleanerDown = i;
					} else {
						airCleanerUp = i;
					}
				}

			}
		}

		int dx[] = { 1, 0, 0, -1 };
		int dy[] = { 0, 1, -1, 0 };

		while (T-- > 0) {
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 1 || ny < 1 || nx > R || ny > C)
						continue;
					if ((nx == airCleanerUp || nx == airCleanerDown) && ny == 1)
						continue;
					cnt++;
					empty[nx][ny] += map[x][y] / 5;
				}
				empty[x][y] -= map[x][y] / 5 * cnt;
			}

			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (empty[i][j] != 0) {
						map[i][j] += empty[i][j];
						empty[i][j] -= empty[i][j];
					}
				}
			}

			int x = airCleanerUp - 1;
			int y = 1;
			while (map[x][y] != -1) {
				if (x == 1 && y < C) {
					map[x][y] = map[x][y + 1];
					y++;
				} else if (y == 1 && x > 1) {
					map[x][y] = map[x - 1][y];
					x--;
				} else if (x == airCleanerUp && y > 1) {
					map[x][y] = map[x][y - 1] != -1 ? map[x][y - 1] : 0;
					y--;
				} else if (y == C && x < R) {
					map[x][y] = map[x + 1][y];
					x++;
				}

			}

			x = airCleanerDown + 1;
			y = 1;
			while (map[x][y] != -1) {
				if (x == R && y < C) {
					map[x][y] = map[x][y + 1];
					y++;
				} else if (y == 1 && x < R) {
					map[x][y] = map[x + 1][y];
					x++;
				} else if (x == airCleanerDown && y > 1) {
					map[x][y] = map[x][y - 1] != -1 ? map[x][y - 1] : 0;
					y--;
				} else if (y == C && x > 1) {
					map[x][y] = map[x - 1][y];
					x--;
				}

			}

			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] != -1 && map[i][j] != 0) {
						int[] pos = { i, j };
						q.offer(pos);
					}
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != -1)
					result += map[i][j];
			}
		}

		System.out.println(result);

	}

}
