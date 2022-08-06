package algorithm_study_java;

import java.io.*;

public class BOJ_2023_JAVA {

	static int N;
	static int[] numbers;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];

		numbers[0] = 2;
		check(1);
		numbers[0] = 3;
		check(1);
		numbers[0] = 5;
		check(1);
		numbers[0] = 7;
		check(1);

		System.out.println(sb);
	}

	private static void check(int idx) {
		StringBuilder strNum = new StringBuilder();

		for (int i = 0; i < idx; i++) {
			strNum.append(numbers[i]);
		}
		int input = Integer.parseInt(strNum.toString());

		if (idx == N) {
			sb.append(input).append("\n");
			return;
		}

		for (int i = 0; i <= 9; i += 2) {
			if (isPrime(input * 10 + i)) {
				// 다음 재귀로 넘어감
				numbers[idx] = i;
				check(idx + 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
