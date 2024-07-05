package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					map[i][j] = -1;
			}
		}

		// init done

		// 섬 나누기
		Queue<int[]> q = new LinkedList<>();
		int section = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == -1) {
					map[i][j] = section;
					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();

						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];

							if (nx < 0 || ny < 0 || nx >= n || ny >= n)
								continue;

							if (map[nx][ny] == 0)
								continue;

							if (map[nx][ny] == section)
								continue;

							map[nx][ny] = section;
							q.offer(new int[] { nx, ny });
						}
					}
					section++;
				}
			}
		}

		int ans = Integer.MAX_VALUE;

		int[][] dist = new int[n][n];
		for (int s = 1; s < section; s++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 시작 섬
					if (map[i][j] == s) {
						q.offer(new int[] { i, j });

						while (!q.isEmpty()) {
							int[] cur = q.poll();

							for (int d = 0; d < 4; d++) {
								int nx = cur[0] + dx[d];
								int ny = cur[1] + dy[d];

								if (nx < 0 || ny < 0 || nx >= n || ny >= n)
									continue;

								if (dist[nx][ny] > 0) {
									// 이미 왔다 간 곳
									if (dist[nx][ny] > dist[cur[0]][cur[1]] + 1) {
										dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
										q.offer(new int[] { nx, ny });
									}
									continue;
								}

								if (map[nx][ny] == s)
									continue;

								if (map[nx][ny] > 0) {
									// 섬일 때
									ans = Math.min(ans, dist[cur[0]][cur[1]]);
								} else {
									// 바다일 때
									dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
									q.offer(new int[] { nx, ny });
								}

							}
						}
					}
				}
			}
		}

		System.out.println(ans);

	}

}
