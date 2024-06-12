package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5569_출근경로 {

	static int mod = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

//		init done

//		x, y, 방향, 꺾는 여부
		int[][][][] dp = new int[w + 1][h + 1][2][2];

		for (int i = 1; i <= w; i++) {
			dp[i][1][0][0] = 1;
		}

		for (int i = 1; i <= h; i++) {
			dp[1][i][1][0] = 1;
		}

		for (int i = 2; i <= w; i++) {
			for (int j = 2; j <= h; j++) {
//				오른쪽으로 꺾지 않은 경우
				dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % mod;

//				오른쪽으로 꺾는 경우
				dp[i][j][0][1] = dp[i - 1][j][1][0] % mod;

//				위쪽으로 꺾지 않은 경우
				dp[i][j][1][0] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % mod;

//				위쪽으로 꺾은 경우
				dp[i][j][1][1] = dp[i][j - 1][0][0] % mod;
			}
		}

		int ans = dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1];
		System.out.println(ans % mod);

	}

}