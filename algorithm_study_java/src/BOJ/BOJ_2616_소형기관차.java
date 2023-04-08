package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2616_소형기관차 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int hap[] = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			hap[i] = hap[i - 1] + Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());

//		init done

		int dp[][] = new int[4][n + 1];
		for (int i = 1; i <= 3; i++) {
			for (int j = m; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - m] + hap[j] - hap[j - m]);
			}
		}

		System.out.println(dp[3][n]);

	}

}
