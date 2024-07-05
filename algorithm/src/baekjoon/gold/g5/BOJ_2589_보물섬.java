package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j);
			}
		}

		// init done

		int[][] dist = new int[n][m];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 'L')
					continue;

				int max = 0;
				for (int k = 0; k < n; k++) {
					for (int k2 = 0; k2 < m; k2++) {
						dist[k][k2] = -1;
					}
				}

				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] { i, j });
				dist[i][j] = 0;

				while (!q.isEmpty()) {
					int[] cur = q.poll();

					for (int d = 0; d < 4; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];

						if (nx < 0 || ny < 0 || nx >= n || ny >= m)
							continue;

						if (map[nx][ny] != 'L')
							continue;

						if (dist[nx][ny] >= 0)
							continue;

						dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

						if (dist[nx][ny] > max)
							max = dist[nx][ny];

						q.offer(new int[] { nx, ny });
					}
				}

				ans = Math.max(ans, max);

			}
		}

		System.out.println(ans);

	}

}
