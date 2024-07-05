package baekjoon.bronze.b2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		comb(cards, 0, 0, 0, n, m);

		System.out.println(ans);

	}

	private static void comb(int[] cards, int cnt, int start, int sum, int n, int m) {
		if (sum > m) {
			return;
		}

		if (cnt == 3) {
			ans = ans < sum ? sum : ans;
			return;
		}
		for (int i = start; i < n; i++) {
			comb(cards, cnt + 1, i + 1, sum + cards[i], n, m);
		}
	}

}
