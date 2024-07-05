package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1038_감소하는수 {

	static PriorityQueue<Long> pq = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n >= 1023) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			func(i + "");
		}

		int idx = 0;

		while (!pq.isEmpty()) {
			long num = pq.poll();
			if (idx++ == n) {
				System.out.println(num);
				break;
			}
		}
	}

	private static void func(String num) {
		if (!decreasingNum(num))
			return;

		pq.add(Long.parseLong(num));
		for (int i = 1; i <= 9; i++) {
			func(i + num);
		}

	}

	private static boolean decreasingNum(String num) {
		for (int i = 0, size = num.length() - 1; i < size; i++) {
			if (num.charAt(i) <= num.charAt(i + 1))
				return false;
		}
		return true;
	}
}
