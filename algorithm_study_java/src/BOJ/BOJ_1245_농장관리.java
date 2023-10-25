package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1245_농장관리 {

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		int ans = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] || map[i][j] == 0)
					continue;

				visited[i][j] = true;
				q.offer(new int[] { i, j });

				boolean isPossible = true;

				while (!q.isEmpty()) {
					int[] cur = q.poll();

					for (int d = 0; d < 8; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];

						if (nx < 0 || ny < 0 || nx >= n || ny >= m)
							continue;

						if (map[nx][ny] > map[cur[0]][cur[1]]) {
							// 옆에가 더 높으면 산봉우리 안됨
							isPossible = false;
							continue;
						}

						if (visited[nx][ny])
							continue;

						if (map[nx][ny] == map[cur[0]][cur[1]]) {
							visited[nx][ny] = true;
							q.offer(new int[] { nx, ny });
						}

					}
				}

				if (isPossible)
					ans++;

			}

		}

		System.out.println(ans);

	}

}
