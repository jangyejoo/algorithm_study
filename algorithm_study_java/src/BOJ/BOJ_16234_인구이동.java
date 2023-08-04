package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		int days = 0;
		while (true) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visit = new boolean[n][n];
			boolean isThereMoving = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j])
						continue;
					List<int[]> section = new ArrayList<>();
					int hap = map[i][j];
					q.offer(new int[] { i, j });
					visit[i][j] = true;
					section.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n)
								continue;
							if (visit[nx][ny])
								continue;
							int gap = Math.abs(map[nx][ny] - map[cur[0]][cur[1]]);
							if (gap < l || gap > r)
								continue;
							isThereMoving = true;
							hap += map[nx][ny];
							q.offer(new int[] { nx, ny });
							visit[nx][ny] = true;
							section.add(new int[] { nx, ny });
						}
					}
					for (int[] cur : section) {
						map[cur[0]][cur[1]] = hap / section.size();
					}
				}
			}
			if (isThereMoving) {
				days++;
			} else {
				System.out.println(days);
				return;
			}
		}

	}

}
