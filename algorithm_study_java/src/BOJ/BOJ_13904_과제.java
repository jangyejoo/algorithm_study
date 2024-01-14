package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13904_과제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<int[]> input = new LinkedList<>();

		int maxDay = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			input.add(new int[] { d, w });

			maxDay = Math.max(maxDay, d);
		}

//		init done

//		d 기준으로 정렬
		input.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int ans = 0;
		int[][] dp = new int[n + 1][maxDay + 1];
		for (int i = 1; i <= n; i++) {
			int d = input.get(i - 1)[0];
			int w = input.get(i - 1)[1];
			for (int j = 1; j <= d; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1] + w, dp[i - 1][j]);

				ans = Math.max(ans, dp[i][j]);
			}
		}

		System.out.println(ans);

	}

}
