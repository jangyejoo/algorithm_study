package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1890_점프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] input = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		long[][] dp = new long[n][n];
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0 || (i == n - 1 && j == n - 1))
					continue;
				int jump = input[i][j];
				if (i + jump < n) {
					dp[i + jump][j] = dp[i + jump][j] == 0 ? dp[i][j] : dp[i + jump][j] + dp[i][j];
				}
				if (j + jump < n) {
					dp[i][j + jump] = dp[i][j + jump] == 0 ? dp[i][j] : dp[i][j + jump] + dp[i][j];
				}
			}
		}
		System.out.println(dp[n - 1][n - 1]);
	}
}
