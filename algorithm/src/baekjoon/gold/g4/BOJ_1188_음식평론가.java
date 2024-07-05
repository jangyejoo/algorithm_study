package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1188_음식평론가 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// init done

		// 최소공배수 구하기
		int total = lcm(n, m);

		// 소시지 자르기
		int cut = 0;
		int one = total / m;
		int size = total / n;
		for (int i = 1; i <= total; i++) {
			if (i % one == 0) {
				if (i % size != 0) {
					cut++;
				}
			}
		}

		System.out.println(cut);

	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
