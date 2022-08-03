package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_2001_JAVA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String nm = br.readLine();
			StringTokenizer st = new StringTokenizer(nm);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] b = new int[N][N];

			for (int i = 0; i < N; i++) {
				String command = br.readLine();
				StringTokenizer st2 = new StringTokenizer(command);
				for (int j = 0; j < N; j++) {
					b[i][j] = Integer.parseInt(st2.nextToken());
				}
			}

			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int hap = 0;
					for (int j2 = i; j2 < i + M; j2++) {
						for (int k = j; k < j + M; k++) {
							if (j2 < 0 || k < 0 || j2 > N - 1 || k > N - 1)
								continue;
							hap += b[j2][k];
						}
					}
					if (hap > max)
						max = hap;
				}
			}

			sb.append("#").append(t).append(" ").append(max).append("\n");

		}
		System.out.println(sb);

	}

}
