package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

//		init done

		int[][] dp = new int[n + 1][k + 1];
		
//		dp 테이블 초기화
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (coins[i - 1] <= k)
				dp[i][coins[i - 1]] = 1;
			for (int j = 1; j <= k; j++) {
				if (coins[i - 1] < j)
					dp[i][j] = Math.min(dp[i - 1][j],
							dp[i][j - coins[i - 1]] != Integer.MAX_VALUE ? dp[i][j - coins[i - 1]] + 1
									: Integer.MAX_VALUE);
				else if (coins[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
			}
		}

		if (dp[n][k] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[n][k]);
	}

}
