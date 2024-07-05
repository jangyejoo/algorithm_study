package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

//		init done

		int[] dp = new int[n + 1];

		if (n == 1) {
			System.out.println(input[1]);
			return;
		}

		if (n == 2) {
			System.out.println(input[1] + input[2]);
			return;
		}

		dp[1] = input[1];
		dp[2] = input[1] + input[2];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + input[i]), dp[i - 3] + input[i - 1] + input[i]);
		}

		System.out.println(dp[n]);

	}

}