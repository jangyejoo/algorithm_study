package algorithm_study_java;

import java.io.*;

public class BOJ_2742_JAVA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = N; i > 0; i--) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

}
