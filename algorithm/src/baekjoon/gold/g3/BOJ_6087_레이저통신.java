package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087_레이저통신 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		Queue<int[]> cs = new LinkedList<>();
		char[][] map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j);

				if (map[i][j] == 'C') {
					cs.offer(new int[] { i, j });
				}
			}
		}

//		init done

		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		int[] start = cs.poll();
		int[] end = cs.poll();

		dist[start[0]][start[1]] = -1;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start[0], start[1] });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int x = cur[0];
			int y = cur[1];
			int mirror = dist[x][y];

			if (x == end[0] && y == end[1])
				break;

			for (int d = 0; d < 4; d++) {
				int nx = x;
				int ny = y;

//				한 방향으로 계속 탐색
				while (true) {
					nx += dx[d];
					ny += dy[d];

//					범위 벗어나면 멈춤
					if (nx < 0 || ny < 0 || nx >= n || ny >= m)
						break;

//					벽이면 멈춤
					if (map[nx][ny] == '*')
						break;

					if (dist[nx][ny] != Integer.MAX_VALUE)
						continue;

					dist[nx][ny] = mirror + 1;
					q.offer(new int[] { nx, ny });

				}
			}
		}

		System.out.println(dist[end[0]][end[1]]);

	}
}
