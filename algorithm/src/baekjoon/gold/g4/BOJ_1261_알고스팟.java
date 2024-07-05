package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			String row = br.readLine();
			for (int j = 0; j < n; j++) {
				if (row.charAt(j) == '1')
					map[i][j] = 1;
			}
		}

		// init done

		Queue<int[]> q = new LinkedList<>();
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}

		q.offer(new int[] { 0, 0 });
		dp[0][0] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curDp = dp[cur[0]][cur[1]];

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;

				if (dp[nx][ny] == -1) {
					// 한번도 안 다녀간 곳
					if (map[nx][ny] == 1) {
						// 벽이면
						dp[nx][ny] = curDp + 1;
					} else {
						// 벽이 아니면
						dp[nx][ny] = curDp;
					}
					q.offer(new int[] { nx, ny });
				} else {
					// 이미 방문한 곳
					if (map[nx][ny] == 1) {
						// 벽이면
						if (dp[nx][ny] > curDp + 1) {
							dp[nx][ny] = curDp + 1;
							q.offer(new int[] { nx, ny });
						}
					} else {
						// 벽이 아니면
						if (dp[nx][ny] > curDp) {
							dp[nx][ny] = curDp;
							q.offer(new int[] { nx, ny });
						}
					}
				}

			}
		}

		System.out.println(dp[m - 1][n - 1]);

	}

}
