package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579_앱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] ms = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			ms[i] = Integer.parseInt(st.nextToken());
		}

		int hap = 0;
		int[] cs = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			cs[i] = Integer.parseInt(st.nextToken());
			hap += cs[i];
		}

		// init done

		int ans = Integer.MAX_VALUE;
		int[][] dp = new int[n + 1][hap + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= hap; j++) {
				if (j - cs[i] < 0)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cs[i]] + ms[i]);
				if (dp[i][j] >= m) {
					ans = Math.min(ans, j);
				}
			}
		}
		System.out.println(ans);

	}

}
