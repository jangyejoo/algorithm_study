package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405_경쟁적전염 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][n + 1];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}

		});

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0)
					pq.add(new int[] { 0, map[i][j], i, j }); // dist, virus type, x, y
			}
		}

		st = new StringTokenizer(br.readLine().trim());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// init done

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			int dist = cur[0];
			int virus = cur[1];

			if (dist == s) {
				// 끝
				System.out.println(map[x][y]);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur[2] + dx[d];
				int ny = cur[3] + dy[d];

				if (nx < 1 || ny < 1 || nx > n || ny > n)
					continue;

				if (map[nx][ny] != 0)
					continue;

				map[nx][ny] = virus;
				pq.offer(new int[] { dist + 1, virus, nx, ny });
			}
		}

		System.out.println(map[x][y]);

	}

}
