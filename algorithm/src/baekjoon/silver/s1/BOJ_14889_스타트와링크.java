package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

	static int[][] S;
	static int[] numbers2;
	static int n, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		S = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

//		완탐
		int[] numbers = new int[n / 2];
		numbers2 = new int[n / 2];
		min = Integer.MAX_VALUE;
		comb(numbers, 0, 0);

		System.out.println(min);

	}

	private static boolean comb(int[] numbers, int cnt, int start) {
		if (cnt == n / 2) {
//			중복이면 조합 연산 중지
			if (Arrays.toString(numbers).equals(Arrays.toString(numbers2))) {
				return true;
			}
			int team_start = calc(S, numbers);
			
//			상대팀 구성 배열
			int idx = 0;
			P: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n / 2; j++) {
					if (numbers[j] == i)
						continue P;
				}
				numbers2[idx++] = i;
				if (idx == n / 2)
					break;
			}
			int team_link = calc(S, numbers2);
			
//			차를 구해서 갱신
			int sub = Math.abs(team_start - team_link);
			if (sub < min)
				min = sub;
			
//			만약에 min==0이면 조합 연산 중지
			if (min == 0)
				return true;
			
			return false;
		}
		for (int i = start; i < n; i++) {
			numbers[cnt] = i;
			if (comb(numbers, cnt + 1, i + 1))
				return true;
		}
		return false;
	}

	private static int calc(int[][] S, int[] numbers) {
		int sum = 0;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				sum += S[numbers[i]][numbers[j]];
			}
		}
		return sum;
	}

}
