package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2602_돌다리건너기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String magic = br.readLine();
		String[] bridge = new String[2];
		bridge[0] = br.readLine();
		bridge[1] = br.readLine();

//		init done

		int magicSize = magic.length();
		int bridgeSize = bridge[0].length();

		int[][][] dp = new int[2][magicSize + 1][bridgeSize + 1];
		for (int i = 0; i <= bridgeSize; i++) {
			dp[0][0][i] = 1;
			dp[1][0][i] = 1;
		}

		for (int i = 1; i <= magicSize; i++) {
			for (int j = 1; j <= bridgeSize; j++) {
				dp[i % 2][i][j] = dp[i % 2][i][j - 1];
				dp[(i + 1) % 2][i][j] = dp[(i + 1) % 2][i][j - 1];

				if (magic.charAt(i - 1) == bridge[i % 2].charAt(j - 1))
					dp[i % 2][i][j] += dp[(i + 1) % 2][i - 1][j - 1];

				if (magic.charAt(i - 1) == bridge[(i + 1) % 2].charAt(j - 1))
					dp[(i + 1) % 2][i][j] += dp[i % 2][i - 1][j - 1];
			}
		}

		System.out.println(dp[0][magicSize][bridgeSize] + dp[1][magicSize][bridgeSize]);

	}
}