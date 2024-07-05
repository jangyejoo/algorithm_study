package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1351_무한수열 {

	static long ans;
	static int MAX = 10000000;
	static long[] dp = new long[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		long n = Long.parseLong(st.nextToken());
		long p = Long.parseLong(st.nextToken());
		long q = Long.parseLong(st.nextToken());

		// init done

		if (n == 0) {
			System.out.println(1);
			return;
		}

		dp[0] = 1;
		System.out.println(calc(n, p, q));

	}

	private static long calc(long n, long p, long q) {
		long a = Math.floorDiv(n, p);
		long b = Math.floorDiv(n, q);

		long dpA;
		long dpB;

		if (a < MAX && dp[(int) a] != 0) {
			dpA = dp[(int) a];
		} else {
			long temp = calc(a, p, q);
			if (a < MAX)
				dp[(int) a] = temp;
			dpA = temp;
		}

		if (b < MAX && dp[(int) b] != 0) {
			dpB = dp[(int) b];
		} else {
			long temp = calc(b, p, q);
			if (b < MAX)
				dp[(int) b] = temp;
			dpB = temp;
		}

		return dpA + dpB;

	}

}
