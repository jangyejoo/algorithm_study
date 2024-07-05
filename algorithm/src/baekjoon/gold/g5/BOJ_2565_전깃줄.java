package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2565_전깃줄 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();

		// 1-index를 위한 삽입
		list.add(new int[] { 0, 0 });

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.add(new int[] { a, b });
		}

		// A 전봇대 기준으로 정렬
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int[] dp = new int[n + 1];
		int max = 0;

		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (list.get(j)[1] < list.get(i)[1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			max = Math.max(max, dp[i]);
			System.out.println(Arrays.toString(dp));
		}

		System.out.println(n - max);

	}

}
