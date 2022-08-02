package algorithm_study_java;
import java.io.*;
import java.util.StringTokenizer;

public class SWEA_2805_JAVA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] farm = new int[n][n];
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				char[] l = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					farm[i][j] = l[j] - '0';
				}
			}

			int num = n / 2;
			int sum = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int d = Math.abs(num - i) + Math.abs(num - j);
					if (d <= num) {
						sum += farm[i][j];
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(sum);
			System.out.println(sb);

		}
	}
}
