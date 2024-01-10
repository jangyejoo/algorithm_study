package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] input = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			input[i][0] = Integer.parseInt(st.nextToken()); // R
			input[i][1] = Integer.parseInt(st.nextToken()); // G
			input[i][2] = Integer.parseInt(st.nextToken()); // B
		}

		// init done

		int[][][] dp = new int[n + 1][3][3]; // 집 넘버, 지금 색깔, 처음 색깔
		for (int houseNumber = 1; houseNumber <= n; houseNumber++) {
			for (int curColor = 0; curColor < 3; curColor++) {
				for (int firstColor = 0; firstColor < 3; firstColor++) {
					dp[houseNumber][curColor][firstColor] = Integer.MAX_VALUE;
				}
			}
		}

		dp[2][0][1] = input[1][1] + input[2][0]; // g + r
		dp[2][0][2] = input[1][2] + input[2][0]; // b + r

		dp[2][1][0] = input[1][0] + input[2][1]; // r + g
		dp[2][1][2] = input[1][2] + input[2][1]; // b + g

		dp[2][2][0] = input[1][0] + input[2][2]; // r + b
		dp[2][2][1] = input[1][1] + input[2][2]; // g + b

		for (int i = 3; i < n; i++) {
			for (int cur = 0; cur < 3; cur++) {
				for (int pre = 0; pre < 3; pre++) {
					if (cur == pre)
						continue;
					for (int first = 0; first < 3; first++) {
						if (dp[i - 1][pre][first] == Integer.MAX_VALUE)
							continue;

						dp[i][cur][first] = Math.min(dp[i][cur][first], dp[i - 1][pre][first] + input[i][cur]);
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int cur = 0; cur < 3; cur++) {
			for (int pre = 0; pre < 3; pre++) {
				if (cur == pre)
					continue;
				for (int first = 0; first < 3; first++) {
					if (cur == first)
						continue;
					if (dp[n - 1][pre][first] == Integer.MAX_VALUE)
						continue;
					ans = Math.min(ans, dp[n - 1][pre][first] + input[n][cur]);
				}
			}
		}

		System.out.println(ans);

	}

}
