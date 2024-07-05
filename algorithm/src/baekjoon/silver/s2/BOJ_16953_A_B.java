package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_A_B {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		// 1. *2
		// 2. 1을 가장 뒤에 추가함 = *10 + 1

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		calc(a, b, 1);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	private static void calc(long a, long b, int cnt) {
		if (a == b) {
			min = Math.min(min, cnt);
			return;
		}

		if (a > b)
			return;

		if (cnt > min)
			return;

		calc(a * 2, b, cnt + 1);
		calc(a * 10 + 1, b, cnt + 1);
	}
}
