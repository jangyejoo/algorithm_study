package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1292_쉽게푸는문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		List<Integer> nums = new ArrayList<>();
		int idx = 1;
		int num = 1;
		B : while (true) {
			for (int j = 1; j <= num; j++) {
				nums.add(num);
				if (++idx > end) break B;
			}
			num++;
		}

		int ans = 0;
		for (int i = start-1; i < end; i++) {
			ans += nums.get(i);
		}

		System.out.println(ans);

	}

}
