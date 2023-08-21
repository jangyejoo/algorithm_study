package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9086_문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String input = br.readLine();
			sb.append(input.charAt(0)).append(input.charAt(input.length() - 1)).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
