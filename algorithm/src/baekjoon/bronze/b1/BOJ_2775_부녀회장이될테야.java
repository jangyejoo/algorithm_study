package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2775_부녀회장이될테야 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[][] dp = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			sb.append(dp[k][n]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
