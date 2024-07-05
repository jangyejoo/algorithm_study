package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3568_iSharp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder basic = new StringBuilder();
		StringBuilder type = new StringBuilder();
		StringBuilder variable = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		String input = br.readLine();

		int i = 0;
		while (i < input.length()) {
			// 기본 자료형이 완성되지 않으면 바로 넘겨
			if ("".equals(basic.toString())) {
				if (input.charAt(i) == ' ') {
					basic.append(input.substring(0, i));
				}
				i++;
				continue;
			}

			// 쉼표나 세미콜론
			if (input.charAt(i) == ',' || input.charAt(i) == ';') {
				answer.append(basic.toString()).append(type.reverse().toString()).append(" ")
						.append(variable.toString()).append(";\n");

				variable = new StringBuilder();
				type = new StringBuilder();
				i++;
				continue;
			}

			// 변수
			if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
					|| (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
				variable.append(input.charAt(i));
				i++;
				continue;
			}

			// *, &
			if (input.charAt(i) == '*' || input.charAt(i) == '&') {
				type.append(input.charAt(i));
				i++;
				continue;
			}

			// []
			if (input.charAt(i) == '[') {
				type.append(']').append('[');
				i += 2;
				continue;
			}

			i++;

		}

		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
