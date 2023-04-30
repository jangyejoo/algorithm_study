package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

//		init done

		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
//			동전 가치가 목표 가치보다 작을 때 dp 테이블 +1
			if (coins[i - 1] <= k)
				dp[i][coins[i - 1]]++;
			for (int j = 1; j <= k; j++) {
				if (j < coins[i - 1]) {
					dp[i][j] += dp[i - 1][j];
				} else {
					dp[i][j] += dp[i - 1][j] + dp[i][j - coins[i - 1]];
				}
			}
		}

		System.out.println(dp[n][k]);
	}

}
