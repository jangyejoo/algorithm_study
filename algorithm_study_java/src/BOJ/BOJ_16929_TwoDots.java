package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16929_TwoDots {

	static int n, m;
	static char[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j);
			}
		}

		// init done

		// -1 : 방문 안 한 거
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = -1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dist[i][j] >= 0)
					continue;

				dist[i][j] = 0;

				for (int d = 0; d < 4; d++) {
					if (play(dist, d, i, j)) {
						System.out.println("Yes");
						return;
					}
				}
			}
		}

		System.out.println("No");

	}

	private static boolean play(int[][] dist, int direction, int x, int y) {
		int nx = x + dx[direction];
		int ny = y + dy[direction];

		if (nx < 0 || ny < 0 || nx >= n || ny >= m)
			return false;

		if (map[x][y] != map[nx][ny])
			return false;

		if (dist[nx][ny] >= 0) {
			if (Math.abs(dist[nx][ny] - dist[x][y]) >= 3) {
				return true;
			}
			return false;
		}

		dist[nx][ny] = dist[x][y] + 1;

		for (int d = 0; d < 4; d++) {
			if (play(dist, d, nx, ny)) {
				return true;
			}
		}

		return false;

	}

}
