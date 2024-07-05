package baekjoon.gold.g4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {

	static int ans, r, c;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String rc = br.readLine();
		StringTokenizer st = new StringTokenizer(rc);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char[][] board = new char[r][c];
		for (int i = 0; i < r; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				board[i][j] = row[j];
			}
		}

		boolean[] visited = new boolean[26];
		visited[board[0][0] - 'A'] = true;
		ans = 0;

		check(board, visited, 1, 0, 0);
		
		System.out.println(ans);

	}

	private static void check(char[][] board, boolean[] visited, int cnt, int x, int y) {
		boolean possible = false;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx > r - 1 || ny > c - 1)
				continue;
			if (visited[board[nx][ny] - 'A'])
				continue;
			possible = true;
			visited[board[nx][ny] - 'A'] = true;
			check(board, visited, cnt + 1, nx, ny);
			visited[board[nx][ny] - 'A'] = false;
		}
		if (!possible) {
			ans = ans < cnt ? cnt : ans;
			return;
		}
	}

}
