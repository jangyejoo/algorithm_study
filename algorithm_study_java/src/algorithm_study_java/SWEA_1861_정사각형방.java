package algorithm_study_java;

import java.io.*;
import java.util.*;

public class SWEA_1861_정사각형방 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] b = new int[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				StringTokenizer r = new StringTokenizer(input);
				for (int j = 0; j < N; j++) {
					b[i][j] = Integer.parseInt(r.nextToken());
				}
			}
			int max = -1;
			int max_room = 1001;
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					int cnt = move(b, visited, i, j) + 1;

					if (max == cnt && max_room > b[i][j]) {
						max_room = b[i][j];
					}
					if (max < cnt) {
						max = cnt;
						max_room = b[i][j];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max_room).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static int move(int[][] board, boolean[][] v, int x, int y) {
		v[x][y] = true;
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1)
				continue;
			if (board[nx][ny] - board[x][y] == 1) {
				return 1 + move(board, v, nx, ny);
			}

		}
		return 0;
	}

}
