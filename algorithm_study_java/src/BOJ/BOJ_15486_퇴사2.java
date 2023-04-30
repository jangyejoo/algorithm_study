package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] input = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

//		init done

		int[] dp = new int[n + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int t = input[i][0];
			int p = input[i][1];
			if (i + t - 1 >= 1 && i + t - 1 <= n) {
				dp[i + t - 1] = Math.max(dp[i + t - 1], max + p);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

}
