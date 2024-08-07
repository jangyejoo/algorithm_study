package baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11718_그대로출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input == null || input.length() == 0)
				break;

			sb.append(input).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
