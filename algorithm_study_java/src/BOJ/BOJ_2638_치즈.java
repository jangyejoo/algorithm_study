package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2638_치즈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];
		List<int[]> cheeses = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					cheeses.add(new int[] { i, j });
			}
		}

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		int ans = 0;

		List<int[]> melt = new ArrayList<int[]>();
		boolean[][] visited = new boolean[n][m];

//		init done

		while (!cheeses.isEmpty()) {
			for (int i = cheeses.size() - 1; i >= 0; i--) {
				int x = cheeses.get(i)[0];
				int y = cheeses.get(i)[1];
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (board[nx][ny] == 1)
						continue;
					if (board[nx][ny] == 2) {
						cnt++;
						continue;
					}
					if (outside(visited, board, nx, ny, n, m)) {
						board[nx][ny] = 2;
						cnt++;
					}
				}
				if (cnt >= 2) {
					melt.add(new int[] { x, y });
					cheeses.remove(i);
				}
			}
			for (int i = 0; i < melt.size(); i++) {
				board[melt.get(i)[0]][melt.get(i)[1]] = 0;
			}
			ans++;
			melt.clear();
		}

		System.out.println(ans);
	}

	private static boolean outside(boolean[][] visited, int[][] board, int x, int y, int n, int m) {
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		Stack<int[]> s = new Stack<int[]>();
		s.push(new int[] { x, y });
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = false;
			}
		}
		while (!s.isEmpty()) {
			int curX = s.peek()[0];
			int curY = s.peek()[1];
			if (curX == 0 || curY == 0 || curX == n - 1 || curY == m - 1) {
				return true;
			}
			s.pop();
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if (board[nx][ny] == 1)
					continue;
				if (board[nx][ny] == 2)
					return true;
				if (visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				s.push(new int[] { nx, ny });
			}
		}
		return false;
	}

}
