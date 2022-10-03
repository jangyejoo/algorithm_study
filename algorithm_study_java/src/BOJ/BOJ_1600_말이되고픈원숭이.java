package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] monkey_x = { 1, 0, -1, 0 };
		int[] monkey_y = { 0, 1, 0, -1 };
		int[] horse_x = { 1, 1, 2, 2, -1, -1, -2, -2 };
		int[] horse_y = { 2, -2, 1, -1, 2, -2, 1, -1 };

		int[][][] dist = new int[H][W][31];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}

		int ans = Integer.MAX_VALUE;

//		init done

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, K, 0 });
		dist[0][0][K] = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int leftJump = q.peek()[2];
			int moved = q.peek()[3];
			q.poll();

			if (moved > ans)
				continue;

			if (x == H - 1 && y == W - 1 && map[x][y] == 0) {
				ans = Math.min(moved, ans);
				continue;
			}

			if (leftJump > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = x + horse_x[i];
					int ny = y + horse_y[i];

					if (nx < 0 || ny < 0 || nx >= H || ny >= W)
						continue;

					if (map[nx][ny] == 1)
						continue;

					if (dist[nx][ny][leftJump - 1] != Integer.MAX_VALUE)
						continue;

					dist[nx][ny][leftJump - 1] = dist[nx][ny][leftJump] + 1;
					q.offer(new int[] { nx, ny, leftJump - 1, moved + 1 });

				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + monkey_x[i];
				int ny = y + monkey_y[i];

				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue;

				if (map[nx][ny] == 1)
					continue;

				if (dist[nx][ny][leftJump] != Integer.MAX_VALUE)
					continue;

				dist[nx][ny][leftJump] = dist[nx][ny][leftJump] + 1;
				q.offer(new int[] { nx, ny, leftJump, moved + 1 });
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

}
