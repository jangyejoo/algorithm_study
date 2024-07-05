package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {

	static int ans = 1;
	static int[][] dp, map;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				calc(n, i, j, 1);
				print(dp, n);
			}
		}

		System.out.println(ans);

	}

	private static int calc(int n, int x, int y, int depth) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;

			if (map[nx][ny] <= map[x][y])
				continue;

			// 처음 지나가는 곳!
			if (dp[nx][ny] == 0) {
				int record = calc(n, nx, ny, depth + 1);
				if (record != 0) {
					dp[x][y] = Math.max(dp[x][y], record + 1);
					ans = Math.max(ans, dp[x][y]);
				}
			} else {
				// 이미 지나간 곳!
				dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
				ans = Math.max(ans, dp[x][y]);
			}
		}

		if (dp[x][y] == 0)
			dp[x][y] = 1;

		return dp[x][y];

	}

	private static void print(int[][] dist, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");

	}

}
