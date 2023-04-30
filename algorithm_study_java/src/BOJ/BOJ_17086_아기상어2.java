package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {

	static int dx[] = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int dy[] = { 0, 1, 0, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.offer(new int[] { i, j });
			}
		}

//		init done

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 8; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (map[nx][ny] == 0) {
					map[nx][ny] = map[cur[0]][cur[1]] + 1;
					q.add(new int[] { nx, ny });
				} else {
					if (map[nx][ny] > map[cur[0]][cur[1]] + 1) {
						map[nx][ny] = map[cur[0]][cur[1]] + 1;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}

		int ans = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ans < map[i][j])
					ans = map[i][j];
			}
		}
		System.out.println(ans - 1);
	}

}
