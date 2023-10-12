package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836_공주님을구해라 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[] gram = new int[2];
		int[][] map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					gram[0] = i;
					gram[1] = j;
				}
			}
		}

		// init done

		Queue<int[]> q = new LinkedList<>();
		int[][] dist = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dist[i][j] = -1;
			}
		}

		dist[1][1] = 0;
		q.offer(new int[] { 1, 1 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 1 || ny < 1 || nx > n || ny > m)
					continue;

				if (map[nx][ny] == 1)
					continue;

				if (dist[nx][ny] >= 0)
					continue;

				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
				q.offer(new int[] { nx, ny });
			}
		}

		int gramRoute = t + 1;
		if (dist[gram[0]][gram[1]] != -1)
			gramRoute = dist[gram[0]][gram[1]] + Math.abs(n - gram[0]) + Math.abs(m - gram[1]);

		if (dist[n][m] == -1)
			dist[n][m] = t + 1;

		int min = Math.min(gramRoute, dist[n][m]);
		System.out.println(min <= t ? min : "Fail");

	}

}
