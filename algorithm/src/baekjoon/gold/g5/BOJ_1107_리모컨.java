package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		if (m > 0) {
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < m; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		// init done

		int min = Math.abs(n - 100);
		for (int gap = 0; gap < min; gap++) {
			int[] next = { n + gap, n - gap };
			for (int number : next) {
				if (number >= 0 && isPossible(number, broken))
					min = Math.min(min, Integer.toString(number).length() + gap);
			}

		}

		System.out.println(min);

	}

	private static boolean isPossible(int number, boolean[] broken) {
		if (number == 0)
			return !broken[0];
		while (number > 0) {
			if (broken[number % 10])
				return false;
			number /= 10;
		}
		return true;
	}

}
