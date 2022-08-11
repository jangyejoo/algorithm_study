package algorithm_study_java;

import java.io.*;

public class BOJ_2577_숫자의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		int n = A * B * C;
		char [] num = String.valueOf(n).toCharArray();
		int [] digit = new int [11];
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < num.length; i++) {
			if (num[i]-'0' == 1) {
				digit[1]++;
			} else if (num[i]-'0' == 2) {
				digit[2]++;
			} else if (num[i]-'0' == 3) {
				digit[3]++;
			} else if (num[i]-'0' == 4) {
				digit[4]++;
			} else if (num[i]-'0' == 5) {
				digit[5]++;
			} else if (num[i]-'0' == 6) {
				digit[6]++;
			} else if (num[i]-'0' == 7) {
				digit[7]++;
			} else if (num[i]-'0' == 8) {
				digit[8]++;
			} else if (num[i]-'0' == 9) {
				digit[9]++;
			} else {
				digit[0]++;
			}
		}
		
		sb.append(digit[0]).append("\n")
		.append(digit[1]).append("\n")
		.append(digit[2]).append("\n")
		.append(digit[3]).append("\n")
		.append(digit[4]).append("\n")
		.append(digit[5]).append("\n")
		.append(digit[6]).append("\n")
		.append(digit[7]).append("\n")
		.append(digit[8]).append("\n")
		.append(digit[9]).append("\n");
		
		System.out.println(sb);
		
	}

}
