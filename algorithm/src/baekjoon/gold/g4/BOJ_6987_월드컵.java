package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {

	static int[] result = new int[18];
	static int[][] input = new int[4][19]; // 마지막 칸은 결과, 가능은 1 불가능은 -1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // 0-index
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 18; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if (input[i][j] == 6)
					input[i][18] = -1;
			}
		}

		// init done

		func(0, 1);

		for (int i = 0; i < 4; i++) {
			if (input[i][18] == -1) {
				System.out.print(0 + " ");
				continue;
			}
			System.out.print(input[i][18] + " ");
		}

	}

	private static void func(int my, int you) {
		if (my == 5) {
			// 완성된 점수판과 비교하는 로직
			C: for (int i = 0; i < 4; i++) {
				if (input[i][18] == 0) {
					for (int j = 0; j < 18; j++) {
						if (input[i][j] != result[j])
							continue C;
					}
					input[i][18] = 1;
				}
			}
			return;
		}

		if (you == 6) {
			// 경기가 끝났는데 input과 같은 값이 없을 때 백트래킹
			boolean possible = false;
			for (int i = 0; i < 4; i++) {
				if (input[i][18] != -1 && input[i][my * 3] == result[my * 3]
						&& input[i][my * 3 + 1] == result[my * 3 + 1] && input[i][my * 3 + 2] == result[my * 3 + 2]) {
					possible = true;
					break;
				}
			}
			if (!possible)
				return;

			// 하나라도 같은 값이 있으면 다음으로 넘어 감!
			func(my + 1, my + 2);
			return;
		}

		// 승
		result[3 * my]++;
		result[3 * you + 2]++;
		func(my, you + 1);
		result[3 * my]--;
		result[3 * you + 2]--;

		// 무승부
		result[3 * my + 1]++;
		result[3 * you + 1]++;
		func(my, you + 1);
		result[3 * my + 1]--;
		result[3 * you + 1]--;

		// 패
		result[3 * my + 2]++;
		result[3 * you]++;
		func(my, you + 1);
		result[3 * my + 2]--;
		result[3 * you]--;
	}

}