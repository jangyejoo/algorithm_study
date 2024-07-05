package baekjoon.gold.g5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] map1 = new char[n][n];
		char[][] map2 = new char[n][n];

		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map1[i][j] = row[j];
				map2[i][j] = row[j];
			}
		}

		int r1 = v1(map1, n);
		int r2 = v2(map2, n);

		System.out.println(r1 + " "+r2);
	}

	private static int v1(char[][] map1, int n) {
//		적록색약이 아닌 사람이 봤을 때
		int result = 0;

		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				char color = map1[i][j];
				int[] input = { i, j };
				q.offer(input);
				while (!q.isEmpty()) {
					int x = q.peek()[0];
					int y = q.peek()[1];
					q.poll();
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						if (map1[nx][ny] != color)
							continue;
						if (visited[nx][ny])
							continue;
						visited[nx][ny] = true;
						int[] nxt = { nx, ny };
						q.offer(nxt);
					}
				}
				result++;
			}
		}
		return result;
	}
	
	private static int v2(char[][] map2, int n) {
//		적록색약인 사람이 봤을 때
		int result = 0;

		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				char color = map2[i][j];
				int[] input = { i, j };
				q.offer(input);
				while (!q.isEmpty()) {
					int x = q.peek()[0];
					int y = q.peek()[1];
					q.poll();
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						if (color == 'B' && map2[nx][ny] != color)
							continue;
						if (color != 'B' && map2[nx][ny] == 'B')
							continue;
						if (visited[nx][ny])
							continue;
						visited[nx][ny] = true;
						int[] nxt = { nx, ny };
						q.offer(nxt);
					}
				}
				result++;
			}
		}
		return result;
	}


}
