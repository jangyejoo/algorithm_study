package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {

	static int[] dx = { 0, 0, 1, -1, 0, 0 };
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		C: while (true) {
			st = new StringTokenizer(br.readLine().trim());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (l == 0 && r == 0 && c == 0)
				break;

			int[][][] dist = new int[l][r][c];
			char[][][] map = new char[l][r][c];
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					for (int j2 = 0; j2 < c; j2++) {
						dist[i][j][j2] = -1;
					}
				}
			}

			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String row = br.readLine();
					for (int j2 = 0; j2 < c; j2++) {
						map[i][j][j2] = row.charAt(j2);

						if (map[i][j][j2] == 'S') {
							q.offer(new int[] { i, j, j2 });
							dist[i][j][j2] = 0;
						}
					}
				}
				// 빈 줄
				br.readLine();
			}

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				for (int d = 0; d < 6; d++) {
					int nx = cur[1] + dx[d];
					int ny = cur[2] + dy[d];
					int nz = cur[0] + dz[d];

					if (nx < 0 || ny < 0 || nz < 0)
						continue;

					if (nx >= r || ny >= c || nz >= l)
						continue;

					if (map[nz][nx][ny] == '#')
						continue;

					if (dist[nz][nx][ny] != -1)
						continue;

					dist[nz][nx][ny] = dist[cur[0]][cur[1]][cur[2]] + 1;

					if (map[nz][nx][ny] == 'E') {
						sb.append("Escaped in ").append(dist[nz][nx][ny]).append(" minute(s).").append("\n");
						continue C;
					}

					q.offer(new int[] { nz, nx, ny });
				}
			}

			sb.append("Trapped!\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
