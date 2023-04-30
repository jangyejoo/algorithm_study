package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			boolean[][] board = new boolean[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				board[from][to] = true;
			}

//			init done

			// 플로이드 워샬
			for (int i = 1; i <= n; i++) { // 경
				for (int j = 1; j <= n; j++) { // 출
					for (int j2 = 1; j2 <= n; j2++) { // 도
						if (board[j][i] && board[i][j2])
							board[j][j2] = true;
					}
				}
			}

			int ans = 0;
			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j <= n; j++) {
					if (board[i][j] || board[j][i])
						cnt++;
				}
				if (cnt == n - 1) {
					ans++;
				}
			}

			sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
