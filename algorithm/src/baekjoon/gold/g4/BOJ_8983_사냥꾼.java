package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983_사냥꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] positions = new int[m];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			positions[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(positions);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (y > l)
				continue;

			int start = x + y - l;
			int end = x - y + l;

			int left = 0;
			int right = m - 1;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (positions[mid] >= start && positions[mid] <= end) {
					ans++;
					break;
				} else if (positions[mid] < start) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		System.out.println(ans);

	}

}
