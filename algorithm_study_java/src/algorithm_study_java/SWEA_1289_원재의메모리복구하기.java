package algorithm_study_java;

import java.io.*;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int T = 1; T <= t; T++) {
			int answer = 0;
			StringBuilder sb = new StringBuilder();
			String data = br.readLine();
			char[] init = new char[data.length()];
			char[] org = new char[data.length()];
			for (int i = 0; i < data.length(); i++) {
				init[i] = '0';
				org[i] = data.charAt(i);
			}

			for (int i = 0; i <= data.length() - 1; i++) {
				if (org.equals(init)) {
					break;
				}
				if (org[i] == '1' && init[i] == '0') {
					// init i 다음 다 바꾸기
					for (int j = i + 1; j <= data.length() - 1; j++) {
						init[j] = '1';
					}
					answer++;
				}
				if (org[i] == '0' && init[i] == '1') {
					// origin i 다음 다 바꾸기
					for (int j = i + 1; j <= data.length() - 1; j++) {
						init[j] = '0';
					}
					answer++;
				}
			}

			sb.append("#").append(T).append(" ").append(answer);
			System.out.println(sb);

//          System.out.println("#" + T + " " + answer);
		}
	}
}
