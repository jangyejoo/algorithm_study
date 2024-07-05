package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110_solvedac {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
			sum += input[i];
		}

		// init done

		Arrays.sort(input);

		int exceptCnt = (int) Math.round(n * 0.15);
		int exceptSum = 0;
		for (int i = 0; i < exceptCnt; i++) {
			exceptSum += input[i];
		}
		for (int i = n - 1; i > n - 1 - exceptCnt; i--) {
			exceptSum += input[i];
		}

		System.out.println((int) Math.round((sum - exceptSum) / (double) (n - exceptCnt * 2)));

	}

}
