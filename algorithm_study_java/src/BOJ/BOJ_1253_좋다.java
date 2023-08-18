package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		if (n <= 2) {
			System.out.println(0);
			return;
		}

		long[] input = new long[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}

		// init done

		Arrays.sort(input);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = n - 1;

			while (true) {
				// start, end 조정
				if (start == i)
					start++;
				if (end == i)
					end--;
				if (start >= end) {
					break;
				}

				long hap = input[start] + input[end];

				if (hap == input[i]) {
					ans++;
					break;
				} else if (hap > input[i]) {
					end--;
				} else {
					start++;
				}
			}

		}

		System.out.println(ans);

	}

}
