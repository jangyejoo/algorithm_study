package algorithm_study_java;

import java.io.*;

public class BOJ_8958_JAVA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			char[] input = br.readLine().toCharArray();
			int sum = 0;
			int hap = 0;
			for (int j = 0; j < input.length; j++) {
				if (j > 0) {
					if (input[j] == 'O' ) {
						if (input[j - 1] == input[j]) {
							hap++;
							sum += hap;
						} else {
							sum += 1;
							hap++;
						}
					}
					if (input[j] == 'X')
						hap = 0;
				} else {
					if (input[j] == 'O') {
						sum += 1;
						hap++;
						
					}
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
