package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16637_괄호추가하기 {

	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

//		1. 연산자는 + - *
//	 	2. 중첩된 괄호는 안됨
//		3. 괄호 안에는 연산자 하나만

		max = Integer.MIN_VALUE;

//		괄호 없을 때
		boolean[] parenthesis = new boolean[n];
		calc(input, parenthesis);
		
//		괄호 5개일 때
		if (n >= 19) {
			parenthesis = new boolean[n];
			comb(input, parenthesis, 0, 0, 5);
		}
		
//		괄호 4개일 때
		if (n >= 15) {
			parenthesis = new boolean[n];
			comb(input, parenthesis, 0, 0, 4);
		}
		
//		괄호 3개일 때
		if (n >= 11) {
			parenthesis = new boolean[n];
			comb(input, parenthesis, 0, 0, 3);
		}
		
//		괄호 2개일 때
		if (n >= 7) {
			parenthesis = new boolean[n];
			comb(input, parenthesis, 0, 0, 2);
		}
		
//		괄호 1개일 때
		if (n >= 3) {
			parenthesis = new boolean[n];
			comb(input, parenthesis, 0, 0, 1);
		}

		System.out.println(max);
	}

	private static void calc(char[] input, boolean[] parenthesis) {
		int result = 0;
		int mid = 0;
		char operator = '+';
		for (int i = 0, size = input.length; i < size; i++) {
			switch (input[i]) {
			case '+':
				if (!parenthesis[i])
					operator = '+';
				break;
			case '-':
				if (!parenthesis[i])
					operator = '-';
				break;
			case '*':
				if (!parenthesis[i])
					operator = '*';
				break;
			default:
//				( A 연산자 B )
				if (i < size - 1 && parenthesis[i + 1]) { // A
					mid += input[i] - '0';
				} else if (i > 0 && parenthesis[i - 1]) { // B
					if (operator == '+') {
						if (input[i - 1] == '+') { // 연산자 +
							result += mid + (input[i] - '0');
						} else if (input[i - 1] == '-') {
							result += mid - (input[i] - '0');
						} else {
							result += mid * (input[i] - '0');
						}
					} else if (operator == '-') { // 연산자 -
						if (input[i - 1] == '+') {
							result -= mid + (input[i] - '0');
						} else if (input[i - 1] == '-') {
							result -= mid - (input[i] - '0');
						} else {
							result -= mid * (input[i] - '0');
						}
					} else { // 연산자 *
						if (input[i - 1] == '+') {
							result *= mid + (input[i] - '0');
						} else if (input[i - 1] == '-') {
							result *= mid - (input[i] - '0');
						} else {
							result *= mid * (input[i] - '0');
						}
					}
					mid = 0;
				} else { // 괄호가 없으면
					if (operator == '+') {
						result += input[i] - '0';
					} else if (operator == '-') {
						result -= input[i] - '0';
					} else {
						result *= input[i] - '0';
					}
				}
				break;
			}
		}

		if (max < result)
			max = result;

	}

	private static void comb(char[] input, boolean[] parenthesis, int cnt, int start, int n) {
		if (cnt == n) {
			calc(input, parenthesis);
			return;
		}
		for (int i = start, size = input.length; i < size; i++) {
			if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
				parenthesis[i] = true;
				comb(input, parenthesis, cnt + 1, i + 4, n);
				parenthesis[i] = false;
			}
		}
	}
}
