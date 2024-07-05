package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1563_개근상 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][][] dp = new int[n + 1][3][2]; // 시간, 연속, 지각 횟수
		dp[1][0][0] = 1;
		dp[1][1][0] = 1;
		dp[1][0][1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0]) % 1000000;
			dp[i][0][1] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0] + dp[i - 1][0][1] + dp[i - 1][1][1]
					+ dp[i - 1][2][1]) % 1000000;
			dp[i][1][0] = (dp[i - 1][0][0]) % 1000000;
			dp[i][1][1] = (dp[i - 1][0][1]) % 1000000;
			dp[i][2][0] = (dp[i - 1][1][0]) % 1000000;
			dp[i][2][1] = (dp[i - 1][1][1]) % 1000000;
		}

		System.out
				.println((dp[n][0][0] + dp[n][0][1] + dp[n][1][0] + dp[n][1][1] + dp[n][2][0] + dp[n][2][1]) % 1000000);

	}

}
