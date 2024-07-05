package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] input = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		int max = 0;
		int start = 0;
		int end = 0;
		int[] cnt = new int[100001];
		while (start < n) {
			while (end < n) {
				if (cnt[input[end]] + 1 > k) {
					break;
				} else {
					cnt[input[end]]++;
					end++;
				}
			}
			max = Math.max(max, end - start);
			cnt[input[start]]--;
			start++;
		}
		System.out.println(max);
	}

}
