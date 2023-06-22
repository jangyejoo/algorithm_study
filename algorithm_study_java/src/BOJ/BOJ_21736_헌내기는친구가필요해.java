package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는친구가필요해 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][m];
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = row[j];
				if (row[j] == 'I')
					q.offer(new int[] { i, j });
			}
		}

		// init done

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			visited[cur[0]][cur[1]] = true;
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] == 'X')
					continue;

				if (map[nx][ny] == 'P')
					cnt++;

				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
			}
		}

		System.out.println(cnt == 0 ? "TT" : cnt);

	}

}
