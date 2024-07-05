package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		int ans = 1;

		for (int height = 1; height <= 99; height++) {
			int cnt = 0;
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] || map[i][j] <= height)
						continue;

					cnt++;

					visited[i][j] = true;
					q.offer(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] cur = q.poll();

						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];

							if (nx < 0 || ny < 0 || nx >= n || ny >= n)
								continue;

							if (visited[nx][ny])
								continue;

							if (map[nx][ny] <= height)
								continue;

							visited[nx][ny] = true;
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}

			ans = Math.max(ans, cnt);

		}

		System.out.println(ans);

	}

}