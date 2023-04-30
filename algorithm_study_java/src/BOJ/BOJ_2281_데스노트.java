package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2281_데스노트 {

	static int dp[][] = new int[1002][1002];
	static int names[], n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		names = new int[n];
		for (int i = 0; i < n; i++) {
			names[i] = Integer.parseInt(br.readLine());
		}

//		init done

//		dp[i][j] = i번째 이름을 적을 차례이고, i-1번째까지 j만큼 공간을 사용했을 때의 최솟값
		for (int i = 0, size = dp.length; i < size; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(solve(1, names[0] + 1));
	}

	private static int solve(int i, int j) {
		if (i == n)
			return 0;

		int result = dp[i][j];
		if (result != -1) {
			return result;
		}

		// 다음 줄에 쓰는 경우
		result = (m - j + 1) * (m - j + 1) + solve(i + 1, names[i] + 1);

		// 현재 줄에 이어쓰는 경우
		if (j + names[i] <= m) {
			result = Math.min(result, solve(i + 1, j + names[i] + 1));
		}

		dp[i][j] = result;
		return result;
	}

}
