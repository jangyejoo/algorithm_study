package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {

	static int ans;
	static int[][] film;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			film = new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;

//			init done

			dfs(0, 0, d, w, k);

			sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int idx, int count, int d, int w, int k) {
		// count가 이미 최소값을 넘겼을 때 백트래킹
		if (count > ans)
			return;

		// ans 갱신
		if (check(d, w, k)) {
			ans = Math.min(ans, count);
		}

		// 다 탐색하면 종료
		if (idx == d)
			return;

		// film을 원본으로 돌리기 위해 origin copy
		int[] origin = Arrays.copyOf(film[idx], w);

		// 약물 투입 안했을 때
		dfs(idx + 1, count, d, w, k);

		// A 약물 투입
		for (int i = 0; i < w; i++) {
			film[idx][i] = 0;
		}
		dfs(idx + 1, count + 1, d, w, k);

		// B 약물 투입
		for (int i = 0; i < w; i++) {
			film[idx][i] = 1;
		}
		dfs(idx + 1, count + 1, d, w, k);

		// 원본으로 돌려놓기
		for (int i = 0; i < w; i++) {
			film[idx][i] = origin[i];
		}
	}

	// 성능검사
	private static boolean check(int d, int w, int k) {
		for (int i = 0; i < w; i++) {
			int cnt = 1;
			boolean isTrue = false;
			for (int j = 1; j < d; j++) {
				if (film[j][i] == film[j - 1][i])
					cnt++;
				else
					cnt = 1;
				if (cnt == k) {
					isTrue = true;
					break;
				}
			}
			if (!isTrue)
				return false;
		}
		return true;
	}

}
