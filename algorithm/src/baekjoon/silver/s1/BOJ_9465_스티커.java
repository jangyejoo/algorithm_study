package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			int[][] input = new int[2][n];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// init done

			int[][] dp = new int[n + 2][3];
			for (int i = 2; i <= n + 1; i++) {
				dp[i][0] = Math.max(dp[i - 2][2] + input[0][i - 2], dp[i - 1][1] + input[0][i - 2]);
				dp[i][1] = Math.max(dp[i - 2][2] + input[1][i - 2], dp[i - 1][0] + input[1][i - 2]);
				dp[i][2] = Math.max(dp[i][0], dp[i][1]);
			}
			sb.append(dp[n + 1][2]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
