package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();

		// init done

		int[] arr = new int[m];
		for (int i = 1; i < m; i++) {
			if (s.charAt(i) != s.charAt(i - 1))
				arr[i] = arr[i - 1] + 1;
		}

		int ans = 0;
		int term = 2 * n;
		int idx = term;
		while (idx < m) {
			if (s.charAt(idx) == 'I' && (arr[idx] - arr[idx - term]) == term) {
				ans++;
				idx += 2;
			} else {
				idx++;
			}
		}

		System.out.println(ans);
	}

}
