package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {

	static int n, m;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;

	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}

		findWay(dp, 0, 0);

		System.out.println(dp[0][0]);

	}

	private static boolean findWay(int[][] dp, int x, int y) {
		if (dp[x][y] == -1)
			dp[x][y] = 1;

		if (x == m - 1 && y == n - 1) {
			return true;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= m || ny >= n)
				continue;

			if (map[nx][ny] >= map[x][y])
				continue;

			if (dp[nx][ny] != -1)
				continue;

			if (!findWay(dp, nx, ny)) {
				dp[x][y]--;
			}

		}

		if (dp[x][y] > 0) {
			int hap = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;

				if (map[nx][ny] >= map[x][y])
					continue;

				if (dp[nx][ny] == -1)
					continue;

				hap += dp[nx][ny];
			}
			dp[x][y] = hap;
			return true;
		} else {
			return false;
		}

	}

}
