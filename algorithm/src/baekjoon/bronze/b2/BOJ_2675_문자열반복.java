package baekjoon.bronze.b2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2675_문자열반복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String command = br.readLine();
			StringTokenizer st = new StringTokenizer(command);
			int loop = Integer.parseInt(st.nextToken());
			char[] c = st.nextToken().toCharArray();

			for (int j = 0; j < c.length; j++) {
				for (int i = 0; i < loop; i++) {
					sb.append(c[j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
