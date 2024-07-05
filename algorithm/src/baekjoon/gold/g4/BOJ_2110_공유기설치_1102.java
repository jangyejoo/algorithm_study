package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치_1102 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] houses = new int[n];
		for (int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		// init done

		Arrays.sort(houses);

		int min = 1;
		int max = houses[n - 1] - houses[0];

		if (c == 2) {
			System.out.println(max);
			return;
		}

		while (min < max) {
			int mid = (min + max) / 2;
			int start = 0;
			int cnt = 1;
			for (int i = start + 1; i < n; i++) {
				if (houses[start] + mid <= houses[i]) {
					start = i;
					cnt++;
				}
			}
			if (cnt >= c) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		System.out.println(min - 1);
	}

}
