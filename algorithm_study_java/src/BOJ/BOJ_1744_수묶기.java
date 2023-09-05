package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1744_수묶기 {

	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		// init done

		if (n == 1) {
			System.out.println(list.get(0));
			return;
		}

		Collections.sort(list);

		dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					dp[i][j] = list.get(i - 1);
				else
					dp[i][j] = Integer.MIN_VALUE;
			}
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			ans = Math.max(ans, comb(list, 1, i) + comb(list, i + 1, n));
		}

		System.out.println(ans);

	}

	private static int comb(List<Integer> list, int start, int end) {
		if (start + 1 == end) {
			int num = Math.max(list.get(start - 1) + list.get(end - 1), list.get(start - 1) * list.get(end - 1));
			return dp[start][end] = num;
		}

		if (dp[start][end] != Integer.MIN_VALUE) {
			return dp[start][end];
		}

		int num = Integer.MIN_VALUE;
		for (int i = start; i < end; i++) {
			int A = comb(list, start, i);
			int B = comb(list, i + 1, end);
			if (A != Integer.MIN_VALUE && B != Integer.MIN_VALUE)
				num = Math.max(num, A + B);
		}
		return dp[start][end] = num;

	}

}
