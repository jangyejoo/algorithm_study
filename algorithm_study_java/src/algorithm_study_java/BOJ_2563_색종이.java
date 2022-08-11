package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean b[][] = new boolean[100][100];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			for (int j = startX; j < startX + 10; j++) {
				for (int j2 = startY; j2 < startY + 10; j2++) {
					if (b[j][j2])
						continue;
					b[j][j2] = true;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
