package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5582_공통부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

//		init done

		int lengthA = a.length();
		int lengthB = b.length();

		int ans = 0;
		int[][] dp = new int[lengthA + 1][lengthB + 1];
		for (int i = 1; i <= lengthA; i++) {
			for (int j = 1; j <= lengthB; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}

		System.out.println(ans);
	}

}
