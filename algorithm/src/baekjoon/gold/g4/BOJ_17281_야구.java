package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {

	static int[][] result;
	static int max = Integer.MIN_VALUE;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		result = new int[n + 1][10];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		int[] numbers = new int[9];
		permutation(numbers, 0, 0);

		System.out.println(max);

	}

	private static void permutation(int[] numbers, int cnt, int flag) {
		if (cnt == 9) {
			int score = calc(numbers);
			if (score > max)
				max = score;
			return;
		}

		if (cnt == 3) {
			numbers[cnt++] = 1;
		}

		for (int i = 2; i <= 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[cnt] = i;
			permutation(numbers, cnt + 1, flag | 1 << i);
		}
	}

	private static int calc(int[] numbers) {
		int score = 0;
		int idx = 0;
		boolean[] bases;
		for (int i = 0; i < n; i++) {
			bases = new boolean[4];
			int outcnt = 0;
			B: while (true) {
				int num = result[i + 1][numbers[idx % 9]];
				idx++;
				switch (num) {
				case 0: // 아웃
					if (++outcnt == 3)
						break B;
					break;
				case 1: // 안타
					if (bases[3]) {
						score++;
						bases[3] = false;
					}
					if (bases[2]) {
						bases[3] = true;
						bases[2] = false;
					}
					if (bases[1]) {
						bases[2] = true;
						bases[1] = false;
					}
					bases[1] = true;
					break;
				case 2: // 2루타
					if (bases[3]) {
						score++;
						bases[3] = false;
					}
					if (bases[2]) {
						score++;
						bases[2] = false;
					}
					if (bases[1]) {
						bases[3] = true;
						bases[1] = false;
					}
					bases[2] = true;
					break;
				case 3: // 3루타
					if (bases[3]) {
						score++;
						bases[3] = false;
					}
					if (bases[2]) {
						score++;
						bases[2] = false;
					}
					if (bases[1]) {
						score++;
						bases[1] = false;
					}
					bases[3] = true;
					break;
				case 4: // 홈런
					score++;
					if (bases[3]) {
						score++;
						bases[3] = false;
					}
					if (bases[2]) {
						score++;
						bases[2] = false;
					}
					if (bases[1]) {
						score++;
						bases[1] = false;
					}
					break;
				}
			}
		}
		return score;
	}
}
