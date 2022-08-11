package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {

	static int ans;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String nl = br.readLine();
			StringTokenizer st = new StringTokenizer(nl);
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] ingred = new int[n][2];
			for (int i = 0; i < n; i++) {
				String tk = br.readLine();
				st = new StringTokenizer(tk);
				ingred[i][0] = Integer.parseInt(st.nextToken()); // t
				ingred[i][1] = Integer.parseInt(st.nextToken()); // k
			}

			ans = 0;
			nums = new int[n];
			combination(ingred, 0, n, 0, 0, l);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void combination(int[][] ingredient, int cnt, int n, int score, int kcal, int maxKcal) {
		if (kcal > maxKcal) {
			return;
		}
		ans = ans < score ? score : ans;
		if (cnt == n) {
			return;
		}
		// 재료를 선택할 경우
		combination(ingredient, cnt + 1, n, score + ingredient[cnt][0], kcal + ingredient[cnt][1], maxKcal);
		// 재료를 선택하지 않을 경우
		combination(ingredient, cnt + 1, n, score, kcal, maxKcal);

	}

}
