package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String row = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = row.charAt(j - 1) - '0';
			}
		}

//		init done

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 1, 0 }); // x, y, dist, 벽을 깬 횟수

		int[][][] dist = new int[n + 1][m + 1][11];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int cnt = 0; cnt <= 10; cnt++) {
					dist[i][j][cnt] = Integer.MAX_VALUE;
				}
			}
		}
		dist[1][1][0] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 1 || ny < 1 || nx > n || ny > m)
					continue;

				if (map[nx][ny] == 1) {
//					벽일 때
//					이미 깰 수 있는 만큼 다 깨버렸음 넘어가
					if (cur[2] == k)
						continue;

//					갱신할 필요 없음
					if (dist[nx][ny][cur[2] + 1] <= dist[cur[0]][cur[1]][cur[2]] + 1)
						continue;

					dist[nx][ny][cur[2] + 1] = dist[cur[0]][cur[1]][cur[2]] + 1;
					q.offer(new int[] { nx, ny, cur[2] + 1 });
				} else {
//					벽이 없을 때
//					갱신할 필요 없음
					if (dist[nx][ny][cur[2]] <= dist[cur[0]][cur[1]][cur[2]] + 1)
						continue;

					dist[nx][ny][cur[2]] = dist[cur[0]][cur[1]][cur[2]] + 1;
					q.offer(new int[] { nx, ny, cur[2] });
				}

			}

		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= k; i++) {
			ans = Math.min(ans, dist[n][m][i]);
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

}
