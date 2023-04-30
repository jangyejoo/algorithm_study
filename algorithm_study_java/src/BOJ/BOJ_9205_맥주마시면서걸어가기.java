package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] pos = new int[n + 2][2];
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}

//			init done

			boolean[][] D = new boolean[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				D[i][i] = true;
				for (int j = 0; j < n + 2; j++) {
					if (!D[i][j])
						D[i][j] = check(pos, i, j);
				}
			}

			for (int i = 0; i < n + 2; i++) { // 경
				for (int j = 0; j < n + 2; j++) { // 출
					for (int j2 = 0; j2 < n + 2; j2++) { // 도
						if (!D[j][j2]) {
							if (D[j][i] && D[i][j2])
								D[j][j2] = true;
						}

					}
				}
			}

			if (D[0][n + 1]) {
				sb.append("happy").append("\n");
			} else {
				sb.append("sad").append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static boolean check(int[][] pos, int start, int end) {
		if (Math.abs(pos[start][0] - pos[end][0]) + Math.abs(pos[start][1] - pos[end][1]) > 1000)
			return false;
		else
			return true;
	}

}
