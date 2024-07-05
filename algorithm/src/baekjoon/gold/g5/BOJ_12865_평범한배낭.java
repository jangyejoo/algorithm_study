package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] input = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

//		init done

//		i번째 물건까지 고려했을 때 k무게의 최대 가치
		int[][] dp = new int[n + 1][100001];
		for (int i = 1; i <= n; i++) {
			int start = input[i][0];
			for (int j = 1; j < start; j++) {
				dp[i][j] = dp[i - 1][j];
			}
			for (int j = start; j <= k; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - start] + input[i][1]);
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= k; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
	}
}
