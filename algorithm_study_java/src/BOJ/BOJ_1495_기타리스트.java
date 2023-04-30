package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1495_기타리스트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] v = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

//		init done

//		i번째 음악을 볼륨 x로 연주할 수 있는가?
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][s] = true;
		for (int i = 1; i <= n; i++) {
			boolean possible = false;
			for (int j = 0; j <= m; j++) {
				if (dp[i - 1][j]) {
					if (j + v[i] <= m) {
						dp[i][j + v[i]] = true;
						possible = true;
					}
					if (j - v[i] >= 0) {
						dp[i][j - v[i]] = true;
						possible = true;
					}
				}
			}
			if (!possible) {
				System.out.println(-1);
				return;
			}
		}
		for (int i = m; i >= 0; i--) {
			if (dp[n][i]) {
				System.out.println(i);
				return;
			}
		}
	}

}
