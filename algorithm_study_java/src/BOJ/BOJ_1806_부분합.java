package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		long[] hap = new long[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			hap[i] += hap[i - 1] + Integer.parseInt(st.nextToken());
		}

//		init done

		int ans = n + 1;
		int start = 1;
		int end = 1;
		while (start <= n) {
			while (end <= n && (hap[end] - hap[start - 1] < s))
				end++;
			if (end > n)
				break;
			ans = Math.min(ans, end - start + 1);
			start++;
		}

		if (ans == n + 1)
			ans = 0;

		System.out.println(ans);
	}

}
