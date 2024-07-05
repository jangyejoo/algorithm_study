package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine().trim());

		int[] input = new int[n + 1];
		int input_max = 1;
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			input_max = Math.max(input_max, input[i]);
		}

		// init done

		int[] num = new int[input_max + 1];
		Arrays.fill(num, -1);

		int[] dp1 = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int num1 = input[i];
			num[num1] = 1;

			// 증가
			for (int j = num1 - 1; j > 0; j--) {
				if (num[j] == -1) {
					continue;
				}
				num[num1] = Math.max(num[num1], num[j] + 1);
			}

			dp1[i] = num[num1];
		}

		System.out.println(Arrays.toString(num));
		Arrays.fill(num, -1);

		int[] dp2 = new int[n + 1];
		for (int i = n; i >= 1; i--) {
			int num1 = input[i];
			num[num1] = 1;

			// 증가
			for (int j = num1 - 1; j > 0; j--) {
				if (num[j] == -1) {
					continue;
				}
				num[num1] = Math.max(num[num1], num[j] + 1);
			}

			dp2[i] = num[num1];

		}

		int ans = 1;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dp1[i] + dp2[i] - 1);
		}
		System.out.println(ans);
	}

}
