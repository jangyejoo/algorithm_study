package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11058_크리보드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 1. 화면에 A를 출력
		// 2. 전체 선택
		// 3. 버퍼에 복사
		// 4. 붙여넣기

		long[][] dp = new long[101][3];
		dp[1][0] = 1;
		dp[2][0] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]) + 1;
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][2]);
			dp[i][2] = Math.max(Math.max(dp[i - 1][1] * 2, dp[i - 2][1] * 3), dp[i - 3][1] * 4);
		}


//		print(dp, n);
		System.out.println(Math.max(dp[n][0], dp[n][2]));

	}

	private static void print(long[][] dp, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(dp[j][i] + " ");
			}
			System.out.println();
		}
	}

}
