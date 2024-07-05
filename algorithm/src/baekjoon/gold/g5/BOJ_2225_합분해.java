package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_합분해 {

	static long ans = 0;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new long[n + 1][k + 1];

		// init done

		func(n, k);

		System.out.println(dp[n][k]);

	}

	private static long func(int n, int k) {
		if (k == 1) {
			return dp[n][1] = 1;
		}

		long ans = 0;
		for (int i = 0; i <= n; i++) {
			if (dp[n - i][k - 1] == 0) {
				dp[n - i][k - 1] = func(n - i, k - 1);
			}
			ans = (ans + dp[n - i][k - 1]) % 1000000000;
		}

		return dp[n][k] = ans;
	}
}
