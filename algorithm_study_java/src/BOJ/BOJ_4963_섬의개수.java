package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {

	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			int ans = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						q.offer(new int[] { i, j });
						visited[i][j] = true;
						while (!q.isEmpty()) {
							int[] cur = q.poll();
							for (int d = 0; d < 8; d++) {
								int nx = cur[0] + dx[d];
								int ny = cur[1] + dy[d];

								if (nx < 0 || ny < 0 || nx >= h || ny >= w)
									continue;

								if (map[nx][ny] == 0)
									continue;

								if (visited[nx][ny])
									continue;

								visited[nx][ny] = true;
								q.offer(new int[] { nx, ny });
							}
						}
						ans++;
					}
				}
			}

			sb.append(ans).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
