package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String nmr = br.readLine();
		StringTokenizer st = new StringTokenizer(nmr);

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			st = new StringTokenizer(row);
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		int recNum = Math.min(n, m) / 2;
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < recNum; j++) {
				int x = j;
				int y = j;
				int d = 0;
				int tmp = board[x][y];

				while (true) {
					if (d == 4)
						break;
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < j || ny < j || nx == n - j || ny == m - j) {
						d++;
					} else {
						board[x][y] = board[nx][ny];
						x = nx;
						y = ny;
					}

				}
				board[x + 1][y] = tmp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}
