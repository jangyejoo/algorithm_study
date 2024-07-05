package swea;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean isPossible = true;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				System.out.println(input);
				StringTokenizer st = new StringTokenizer(input);
				int nodeNum = Integer.parseInt(st.nextToken());
				String node = st.nextToken();
				if (st.countTokens() == 2) {
					if (!node.equals("+") && !node.equals("-") && !node.equals("/") && !node.equals("*")) {
						isPossible = false;
					}
				} else if (st.countTokens() == 0) {
					if (node.equals("+") || node.equals("-") || node.equals("/") || node.equals("*")) {
						isPossible = false;
					}
				} else {
					isPossible = false;
				}
			}

			sb.append("#").append(tc).append(" ").append(isPossible ? "1" : "0").append("\n");
		}
		System.out.println(sb);
	}

}
