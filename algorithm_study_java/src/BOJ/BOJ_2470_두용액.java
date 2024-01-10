package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		// 내림차순 정렬
		Arrays.sort(input);

		int a = -1;
		int b = -1;
		int min = Integer.MAX_VALUE;

		int start = 0;
		int end = n - 1;

		if (input[start] < 0 && input[end] < 0) {
			// 둘 다 음수
			System.out.println(input[end - 1] + " " + input[end]);
			return;
		}

		if (input[start] > 0 && input[end] > 0) {
			// 둘 다 양수
			System.out.println(input[start] + " " + input[start + 1]);
			return;
		}

		while (start < end) {
			int hap = input[start] + input[end];

			if (min > Math.abs(hap)) {
				min = Math.abs(hap);
				a = input[start];
				b = input[end];
			}

			if (hap == 0) {
				System.out.println(input[start] + " " + input[end]);
				return;
			} else if (hap > 0) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(a + " " + b);
	}

}
