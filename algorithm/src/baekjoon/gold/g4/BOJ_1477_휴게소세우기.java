package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1477_휴게소세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		List<Integer> restareas = new ArrayList<>();
		restareas.add(0);
		restareas.add(l);

		if (n > 0) {
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				restareas.add(Integer.parseInt(st.nextToken()));
			}
		}

		// init done

		Collections.sort(restareas);

		int ans = l;
		int left = 1;
		int right = l - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

			int sum = 0;
			for (int i = 1; i < n + 2; i++) {
				sum += (restareas.get(i) - restareas.get(i - 1) - 1) / mid;
			}

			if (sum > m) {
				left = mid + 1;
			} else {
				ans = Math.min(ans, mid);
				right = mid - 1;
			}
		}
		System.out.println(ans);

	}

}
