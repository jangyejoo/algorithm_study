package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] taste = new int[n][2];
		for (int i = 0; i < n; i++) {
			String SB = br.readLine();
			StringTokenizer st = new StringTokenizer(SB);
			taste[i][0] = Integer.parseInt(st.nextToken()); // sour
			taste[i][1] = Integer.parseInt(st.nextToken()); // bitter
		}

		int sour = 1;
		int bitter = 0;
		ans = Integer.MAX_VALUE;

		combination(taste, 0, 0, n, sour, bitter);

		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void combination(int[][] taste, int cnt, int select, int n, int sour, int bitter) {
		if (cnt == n) {
			if (select != 0) {
				int sub = Math.abs(sour - bitter);
				ans = ans > sub ? sub : ans;
			}
			return;
		}
		// 재료를 선택했을 때
		combination(taste, cnt + 1, select + 1, n, sour * taste[cnt][0], bitter + taste[cnt][1]);
		// 재료를 선택안했을 때
		combination(taste, cnt + 1, select, n, sour, bitter);
	}

}
