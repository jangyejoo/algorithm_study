package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2109_순회강연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int maxDay = 0;
		int n = Integer.parseInt(br.readLine());
		List<int[]> input = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			input.add(new int[] { p, d });

			maxDay = Math.max(maxDay, d);
		}

//		init done

//		d를 기준으로 정렬
		input.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		int[] dp = new int[maxDay + 1];
		int[] temp = new int[maxDay + 1];

		for (int i = 1; i <= n; i++) {
//			i번째 대학까지 고려
			int pay = input.get(i - 1)[0];
			int day = input.get(i - 1)[1];

			for (int j = 1; j <= maxDay; j++) {
				temp[j] = dp[j];
			}

			for (int j = 1; j <= day; j++) {
				dp[j] = Math.max(temp[j - 1] + pay, temp[j]);
			}

			for (int j = day + 1; j <= maxDay; j++) {
				dp[j] = dp[day];
			}
		}

		System.out.println(dp[maxDay]);

	}

}
