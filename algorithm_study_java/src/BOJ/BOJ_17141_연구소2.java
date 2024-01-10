package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {

	static int n, m, place, ans;
	static int[] selected;
	static int[][] map;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		place = 0;
		ans = Integer.MAX_VALUE;

		map = new int[n][n];
		selected = new int[m];
		List<int[]> viruses = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					map[i][j] = 0;
					viruses.add(new int[] { i, j });
				}

				// 벽이 아닌 공간 카운팅
				if (map[i][j] != 1) {
					place++;
				}
			}
		}

		// init done

		combination(viruses, 0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static void combination(List<int[]> viruses, int start, int idx) {
		if (idx == m) {
			// combination done

			int max = 0;
			int cnt = place;

			Queue<int[]> q = new LinkedList<>();
			int[][] dist = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = -1;
				}
			}

			for (int i = 0; i < m; i++) {
				int[] selectedVirus = viruses.get(selected[i]);

				cnt--;
				q.offer(selectedVirus);
				dist[selectedVirus[0]][selectedVirus[1]] = 0;
			}

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;

					if (map[nx][ny] == 1)
						continue;

					if (dist[nx][ny] >= 0)
						continue;

					cnt--;
					q.offer(new int[] { nx, ny });
					dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

					max = Math.max(max, dist[nx][ny]);
				}

			}

			if (cnt == 0)
				ans = Math.min(ans, max);

			return;
		}

		for (int i = start, size = viruses.size(); i < size; i++) {
			selected[idx] = i;
			combination(viruses, i + 1, idx + 1);
		}
	}

}
