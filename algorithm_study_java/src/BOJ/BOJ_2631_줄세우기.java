package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2631_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		// init done

		int max = -1;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(n - max);

	}

}
