package algorithm_study_java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		int ans = 0;
		boolean minus = false;
		List<Integer> num = new ArrayList<Integer>();
		for (int i = 0, size = input.length; i < size; i++) {
			if (input[i] - '0' >= 0 && input[i] - '0' <= 9) {
				num.add(input[i] - '0');
			} else {
				// 숫자가 아닌게 들어오면 num에 쌓인 것을 number로 바꿔버리기
				int number = 0;
				for (int j = 0, size2 = num.size(); j < size2; j++) {
					number += num.get(j) * (Math.pow(10, size2 - 1 - j));
				}
				num.clear();

				if (minus) {
					ans -= number;
				} else {
					ans += number;
				}

				if (input[i] == '-')
					minus = true;
			}
		}

		int number = 0;
		for (int j = 0, size2 = num.size(); j < size2; j++) {
			number += num.get(j) * (Math.pow(10, size2 - 1 - j));
		}

		if (minus) {
			ans -= number;
		} else {
			ans += number;
		}

		System.out.println(ans);

	}

}
