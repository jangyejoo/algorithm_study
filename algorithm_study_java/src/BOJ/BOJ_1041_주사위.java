package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1041_주사위 {

	static int[] min = new int[3];
	static int[] dice = new int[6];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		if (n == 1) {
			// 주사위가 한 개일 때
			Arrays.sort(dice);
			int hap = 0;
			for (int i = 0; i < 5; i++) {
				hap += dice[i];
			}
			System.out.println(hap);
			return;
		}

		for (int i = 0; i < 3; i++) {
			min[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= 3; i++) {
			play(0, 0, i, 0);
		}

		// 주사위가 2개 이상일 때
		long hap = 0;
		long X = n - 2;

		// 3면이 보이는 주사위는 4개
		hap += min[2] * 4;

		// 2면이 보이는 주사위는 (n - 2) * 8 + 4개
		hap += min[1] * (X * 8 + 4);

		// 1면이 보이는 주사위는 (n - 2)^2 * 5 + (n - 2) * 4
		hap += min[0] * (X * X * 5 + X * 4);

		System.out.println(hap);

	}

	private static void play(int cnt, int start, int size, int selected) {
		if (cnt == size) {
			if ((selected & 33) == 33) {
				// A - F
				return;
			}

			if ((selected & 18) == 18) {
				// B - E
				return;
			}

			if ((selected & 12) == 12) {
				// C - D
				return;
			}

			int hap = 0;
			for (int i = 0; i < 6; i++) {
				if ((selected & (1 << i)) == (1 << i)) {
					hap += dice[i];
				}
			}
			min[size - 1] = Math.min(min[size - 1], hap);

			return;
		}

		for (int i = start; i < 6; i++) {
			play(cnt + 1, i + 1, size, selected + (1 << i));
		}
	}

}
