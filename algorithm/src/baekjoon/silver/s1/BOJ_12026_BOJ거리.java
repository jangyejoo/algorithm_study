package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12026_BOJ거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

//		init done

//		i를 거쳐서 j로 갔을 때 필요한 에너지 양의 최솟값
		int[][] dp = new int[n + 1][n + 1];
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			char cur = input[i - 1];
			char nxt = '*';
			switch (cur) {
			case 'B':
				nxt = 'O';
				break;
			case 'O':
				nxt = 'J';
				break;
			case 'J':
				nxt = 'B';
				break;
			}
			int min = Integer.MAX_VALUE;
			for (int j2 = 1; j2 < i; j2++) {
				min = Math.min(min, dp[j2][i]);
			}
			if (i == 1) {
				min = 0;
			}

			for (int j = i; j <= n; j++) {
				if (nxt != input[j - 1]) {
					dp[i][j] = Integer.MAX_VALUE; // i에서 j로 갈 수 없음
					continue;
				}
				if (min == Integer.MAX_VALUE) {
					dp[i][j] = Integer.MAX_VALUE; // i로 갈 수 있는 경로가 아예 없음
				} else {
					dp[i][j] = min + (j - i) * (j - i);
					if (j == n)
						ans = Math.min(ans, dp[i][j]);
				}

			}
		}
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

}
