package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10422_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int input[] = new int[t];
		int max = 0;
		for (int i = 0; i < t; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[i]);
		}

		final int MOD = 1000000007;

//		init done

		if (max < 2) {
			System.out.println(0);
			return;
		}

		long dp[] = new long[max + 1];
		dp[0] = 1;
		dp[2] = 1;
		for (int i = 4; i <= max; i += 2) {
			for (int j = 2; j <= i; j += 2) {
				dp[i] = (dp[i] + dp[j - 2] * dp[i - j]) % MOD;
			}
		}

		for (int i = 0; i < t; i++) {
			sb.append(dp[input[i]]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
