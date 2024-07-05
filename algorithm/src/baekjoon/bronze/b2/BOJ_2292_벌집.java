package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292_벌집 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(1);
			return;
		}

		int tmp = 1;
		int cnt = 1;
		while (n > tmp) {
			tmp += 6 * cnt;
			cnt++;
		}
		System.out.println(cnt);
	}

}
