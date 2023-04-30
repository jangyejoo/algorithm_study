package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_8382_방향전환 {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		int size = -1;
		int X = -1;
		int Y = -1;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x = Math.abs(x1 - x2);
			int y = Math.abs(y2 - y1);
			if (size < Math.max(x, y)) {
				X = x;
				Y = y;
				size = Math.max(x, y);
			}

			list.add(new int[] { x, y });
		}

		int[][][] map = new int[size + 1][size + 1][2];
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= size; j++) {
				map[i][j][0] = Integer.MAX_VALUE;
				map[i][j][1] = Integer.MAX_VALUE;
			}
		}
		map[0][0][0] = 0;
		map[0][0][1] = 0;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == X && cur[1] == Y)
				break;

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx > size || ny > size)
					continue;

				if (d < 2) { // 가로이동
					if (map[cur[0]][cur[1]][1] != Integer.MAX_VALUE) {
						if (map[nx][ny][0] > map[cur[0]][cur[1]][1] + 1) {
							map[nx][ny][0] = map[cur[0]][cur[1]][1] + 1;
							q.offer(new int[] { nx, ny });
						}
					}
				} else { // 세로이동
					if (map[cur[0]][cur[1]][0] != Integer.MAX_VALUE) {
						if (map[nx][ny][1] > map[cur[0]][cur[1]][0] + 1) {
							map[nx][ny][1] = map[cur[0]][cur[1]][0] + 1;
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int x = list.get(tc - 1)[0];
			int y = list.get(tc - 1)[1];
			sb.append(Math.min(map[x][y][0], map[x][y][1])).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
