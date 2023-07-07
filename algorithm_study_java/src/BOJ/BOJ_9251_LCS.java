package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {

	public static void main(String[] args) throws IOException {
		// ver 1. 20,140 kb, 216 ms
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input1 = br.readLine();
		String input2 = br.readLine();

		// init done

		int size1 = input1.length();
		int size2 = input2.length();
		int ans = 0;

		if (size1 >= size2) {
			int[][] dp = new int[size2 + 1][size2 + 1];
			int[][] start = new int[size2 + 1][size2 + 1];
			for (int i = 1; i <= size2; i++) {
				boolean isPossible = false;
				C: for (int j = i; j <= size2; j++) {
					for (int j2 = start[i - 1][j - 1] + 1; j2 <= size1; j2++) {
						if (input2.charAt(j - 1) == input1.charAt(j2 - 1)) {
							dp[i][j] = j2;
							isPossible = true;
							if (start[i][j - 1] == 0)
								start[i][j] = dp[i][j];
							else
								start[i][j] = Math.min(start[i][j - 1], dp[i][j]);
							continue C;
						}
					}
					dp[i][j] = -1;
					if (j - 1 < i)
						start[i][j] = size1;
					else
						start[i][j] = start[i][j - 1];
				}
				if (isPossible)
					ans++;
				else
					break;
			}
		} else {
			int[][] dp = new int[size1 + 1][size1 + 1];
			int[][] start = new int[size1 + 1][size1 + 1];
			for (int i = 1; i <= size1; i++) {
				boolean isPossible = false;
				C: for (int j = i; j <= size1; j++) {
					for (int j2 = start[i - 1][j - 1] + 1; j2 <= size2; j2++) {
						if (input1.charAt(j - 1) == input2.charAt(j2 - 1)) {
							dp[i][j] = j2;
							isPossible = true;
							if (start[i][j - 1] == 0)
								start[i][j] = dp[i][j];
							else
								start[i][j] = Math.min(start[i][j - 1], dp[i][j]);
							continue C;
						}
					}
					dp[i][j] = -1;
					if (j - 1 < i)
						start[i][j] = size2;
					else
						start[i][j] = start[i][j - 1];
				}
				if (isPossible)
					ans++;
				else
					break;
			}
		}
		System.out.println(ans);

/////////////////////////////////////////////////////

		// ver 2. 16,456 kb, 120 ms
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input1 = br.readLine();
//		String input2 = br.readLine();
//
//		int size1 = input1.length() + 1;
//		int size2 = input2.length() + 1;
//
//		int[][] dp = new int[size1][size2];
//
//		for (int i = 1; i < size1; i++) {
//			for (int j = 1; j < size2; j++) {
//				if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
//					dp[i][j] = dp[i - 1][j - 1] + 1;
//				} else {
//					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//				}
//			}
//		}
//
//		System.out.println(dp[size1 - 1][size2 - 1]);
	}

}
