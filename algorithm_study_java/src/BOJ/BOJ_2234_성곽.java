package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234_성곽 {

//	서 북 동 남
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		int[][] room = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				room[i][j] = -1;
			}
		}

		Queue<int[]> q = new LinkedList<>();
		List<Integer> roomSize = new LinkedList<>();

		int num = 0;
		int maxRoom = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (room[i][j] != -1)
					continue;

				int size = 1;
				room[i][j] = num;
				q.offer(new int[] { i, j });

				while (!q.isEmpty()) {
					int[] cur = q.poll();

					for (int d = 0; d < 4; d++) {
//						벽이 있으면
						if ((map[cur[0]][cur[1]] & (1 << d)) != 0)
							continue;

						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];

						if (nx < 0 || ny < 0 || nx >= m || ny >= n)
							continue;

						if (room[nx][ny] != -1)
							continue;

						size++;
						room[nx][ny] = num;
						q.offer(new int[] { nx, ny });
					}
				}

				num++;
				roomSize.add(size);
				maxRoom = Math.max(maxRoom, size);

			}
		}

		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 0 || ny < 0 || nx >= m || ny >= n)
						continue;

					if (room[i][j] == room[nx][ny])
						continue;

					ans = Math.max(ans, roomSize.get(room[i][j]) + roomSize.get(room[nx][ny]));
				}
			}
		}

		System.out.println(roomSize.size());
		System.out.println(maxRoom);
		System.out.println(ans);

	}

}
