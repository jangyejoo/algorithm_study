package baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_25372_성택이의은밀한비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			int size = input.length();

			if (size >= 6 && size <= 9)
				sb.append("yes\n");
			else
				sb.append("no\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
