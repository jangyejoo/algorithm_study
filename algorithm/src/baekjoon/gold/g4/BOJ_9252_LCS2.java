package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252_LCS2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();

		int sizeA = a.length();
		int sizeB = b.length();

		int[][][] dp = new int[sizeA + 1][sizeB + 1][3];
		for (int i = 1; i <= sizeA; i++) {
			for (int j = 1; j <= sizeB; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					// 같으면
					dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
					dp[i][j][1] = i - 1;
					dp[i][j][2] = j - 1;
				} else {
					// 다르면
					if (dp[i - 1][j][0] < dp[i][j - 1][0]) {
						dp[i][j][0] = dp[i][j - 1][0];
						dp[i][j][1] = i;
						dp[i][j][2] = j - 1;
					} else {
						dp[i][j][0] = dp[i - 1][j][0];
						dp[i][j][1] = i - 1;
						dp[i][j][2] = j;
					}
				}
			}
		}

		StringBuilder ans = new StringBuilder();
		int x = sizeA;
		int y = sizeB;
		while (true) {
			int nx = dp[x][y][1];
			int ny = dp[x][y][2];

			if (x <= 0 || y <= 0)
				break;

			if (dp[nx][ny][0] < dp[x][y][0]) {
				ans.append(a.charAt(x - 1));
			}

			x = nx;
			y = ny;
		}

		System.out.println(dp[sizeA][sizeB][0]);
		System.out.println(ans.reverse());
	}

}
