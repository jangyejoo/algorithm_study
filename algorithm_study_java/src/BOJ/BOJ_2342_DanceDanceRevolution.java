package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2342_DanceDanceRevolution {

	static int size = 0;
	static int[] input = new int[100002];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		while (true) {
			int num = Integer.parseInt(st.nextToken());

			if (num == 0)
				break;

			input[size++] = num;
		}

//		init done

//		입력값에 대한 예외 처리
		if (size == 1) {
			System.out.println(2);
			return;
		}

//		dp 초기화
		int[][][] dp = new int[size][5][5];
		for (int i = 0; i < size; i++) {
			for (int left = 0; left <= 4; left++) {
				for (int right = 0; right <= 4; right++) {
					dp[i][left][right] = Integer.MAX_VALUE;
				}
			}
		}

//		ver 1. 그냥 dp
		dp[0][input[0]][0] = 2;
		dp[0][0][input[0]] = 2;

		for (int i = 1; i < size; i++) {
			int num = input[i];

//			왼쪽 발을 num으로 옮길 때
			for (int left = 0; left <= 4; left++) {
				int power = 0;

				if (left == 0)
					power = 2;
				else if (left == num)
					power = 1;
				else if ((left + num) % 2 == 0)
					power = 4;
				else
					power = 3;

				for (int right = 0; right <= 4; right++) {
					if (right == num || left == right)
						continue;

					if (dp[i - 1][left][right] != Integer.MAX_VALUE)
						dp[i][num][right] = Math.min(dp[i][num][right], dp[i - 1][left][right] + power);
				}
			}

//			오른쪽 발로 누를 때
			for (int right = 0; right <= 4; right++) {
				int power = 0;

				if (right == 0)
					power = 2;
				else if (right == num)
					power = 1;
				else if ((right + num) % 2 == 0)
					power = 4;
				else
					power = 3;

				for (int left = 0; left <= 4; left++) {
					if (left == num || left == right)
						continue;

					if (dp[i - 1][left][right] != Integer.MAX_VALUE)
						dp[i][left][num] = Math.min(dp[i][left][num], dp[i - 1][left][right] + power);
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		int last = input[size - 1];
		for (int i = 0; i <= 4; i++) {
			ans = Math.min(ans, dp[size - 1][last][i]);
			ans = Math.min(ans, dp[size - 1][i][last]);
		}
		System.out.println(ans);

//		ver 2. dp + 재귀 
		/*
		 * System.out.println(solve(0, 0, 0));
		 * 
		 * }
		 * 
		 * private static int solve(int idx, int left, int right) { if (idx == size)
		 * return 0;
		 * 
		 * if (dp[idx][left][right] != Integer.MAX_VALUE) return dp[idx][left][right];
		 * 
		 * dp[idx][left][right] = Math.min(solve(idx + 1, input[idx], right) +
		 * power(left, input[idx]), solve(idx + 1, left, input[idx]) + power(right,
		 * input[idx])); return dp[idx][left][right]; }
		 * 
		 * private static int power(int cur, int next) { if (cur == 0) return 2; else if
		 * (cur == next) return 1; else if ((cur + next) % 2 == 0) return 4; return 3; }
		 */
	}

}
