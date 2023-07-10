package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운최단거리 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] ans = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					q.add(new int[] { i, j });
			}
		}

		// init done

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (map[nx][ny] != 1)
					continue;
				if (ans[nx][ny] != 0)
					continue;
				ans[nx][ny] = ans[cur[0]][cur[1]] + 1;
				q.add(new int[] { nx, ny });
			}
		}

		// print
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ans[i][j] == 0 && map[i][j] == 1)
					sb.append(-1).append(" ");
				else
					sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
