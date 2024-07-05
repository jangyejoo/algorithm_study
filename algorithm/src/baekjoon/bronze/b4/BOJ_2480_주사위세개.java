package baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2480_주사위세개 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// init done

		if (a == b && b == c) {
			System.out.println(10000 + a * 1000);
			return;
		}

		if (a != b && b != c && a != c) {
			int max = Math.max(a, b);
			max = Math.max(max, c);
			System.out.println(max * 100);
			return;
		}

		if (a == b) {
			System.out.println(1000 + a * 100);
			return;
		}

		if (b == c) {
			System.out.println(1000 + b * 100);
			return;
		}

		if (a == c) {
			System.out.println(1000 + a * 100);
			return;
		}
	}

}
