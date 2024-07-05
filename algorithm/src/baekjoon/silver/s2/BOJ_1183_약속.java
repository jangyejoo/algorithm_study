package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1183_약속 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		if (n % 2 != 0) {
			System.out.println(1);
			return;
		}

		int[] neg = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			neg[i] = B - A;
		}

		// init done
		Arrays.sort(neg);

		System.out.println(Math.abs(neg[n / 2 - 1] - neg[n / 2]) + 1);

	}

}
