package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long s = Long.parseLong(br.readLine());
		int num = 1;
		int cnt = 0;
		while (s > 0) {
			if (s - num < 0) {
				num--;
				s += num;
				num += 2;
				cnt--;
			} else {
				s -= num;
				num++;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
