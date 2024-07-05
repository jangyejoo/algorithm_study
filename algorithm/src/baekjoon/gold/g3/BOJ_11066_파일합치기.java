package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11066_파일합치기 {

	static int n;
	static int[] input;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			n = Integer.parseInt(br.readLine());
			input = new int[n + 1];

			st = new StringTokenizer(br.readLine().trim());
			for (int i = 1; i <= n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			// init done

			dp = new int[n + 1][n + 1];
			dp[1][n] = Integer.MAX_VALUE;
			for (int i = 1; i < n; i++) {
				dp[1][n] = Math.min(dp[1][n], calc(1, i) + calc(i + 1, n));
			}

			sb.append(dp[1][n]).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int calc(int start, int end) {
		if (start == end) {
			return dp[start][end] = input[start];
		}

		if (dp[start][end] != 0)
			return dp[start][end];

		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += input[i];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			ans = Math.min(ans, calc(start, i) + calc(i + 1, end) + sum);
		}

		return dp[start][end] = ans;
	}

}
