package algorithm_study_java;

import java.io.*;
import java.util.*;

public class BOJ_7576_토마토 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[m][n];
		Queue<int[]> tomato = new LinkedList<int[]>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					int[] input = { i, j };
					tomato.offer(input);
				}
			}
		}

		int dist[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = -1;
				}
			}
		}

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		int max = 0;

		while (!tomato.isEmpty()) {
			int x = tomato.peek()[0];
			int y = tomato.peek()[1];
			tomato.poll();
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				if (dist[nx][ny] != -1)
					continue;
				if (board[nx][ny] != 0)
					continue;
				int nxtDist = dist[x][y] + 1;
				dist[nx][ny] = nxtDist;
				board[nx][ny] = 1;
				max = nxtDist > max ? nxtDist : max;
				int[] nxt = { nx, ny };
				tomato.offer(nxt);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(max);

	}

}
