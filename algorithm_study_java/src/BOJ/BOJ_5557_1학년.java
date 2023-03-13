package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557_1학년 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

//		init done

//		중간 수가 음수가 되면 안돼
		long[][] dp = new long[n + 1][21];
		dp[1][input[1]]++;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] == 0)
					continue;
				if (j + input[i] <= 20)
					dp[i][j + input[i]] += dp[i - 1][j];
				if (j - input[i] >= 0)
					dp[i][j - input[i]] += dp[i - 1][j];
			}
		}
		System.out.println(dp[n-1][input[n]]);
	}
}
