package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {

	static int n, m, ans, empty;
	static int[][] map;
	static int[] numbers;
	static List<int[]> virus = new LinkedList<>();

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		empty = 0;
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
//					바이러스가 있는 위치이면
					virus.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
//					빈 칸이면
					empty++;
				}
			}
		}

//		init done

//		nCm
		ans = Integer.MAX_VALUE;
		numbers = new int[m];

		combination(0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static void combination(int start, int cnt) {
		if (cnt == m) {
//			바이러스 조합 완성 후 bfs
			Queue<int[]> q = new LinkedList<>();
			int[][] result = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result[i][j] = Integer.MAX_VALUE;
				}
			}

//			활성화된 바이러스 표시
			for (int i = 0; i < m; i++) {
				int x = virus.get(numbers[i])[0];
				int y = virus.get(numbers[i])[1];

				result[x][y] = 0;
				q.offer(new int[] { x, y });
			}

			int max = 0;
			int emptyCnt = 0;
			B: while (!q.isEmpty()) {
				int[] cur = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];

					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;

					if (result[nx][ny] != Integer.MAX_VALUE)
						continue;

//					벽이면
					if (map[nx][ny] == 1)
						continue;

					result[nx][ny] = result[cur[0]][cur[1]] + 1;

					if (map[nx][ny] == 0) {
//						빈 칸에 바이러스를 퍼뜨림
						max = Math.max(max, result[nx][ny]);
						if (++emptyCnt == empty) {
//							빈 칸에 바이러스 전부 다 퍼뜨림
							break B;
						}
					}

//					나름의 백트래킹
					if (max >= ans)
						return;

					q.offer(new int[] { nx, ny });
				}
			}

			if (emptyCnt < empty) {
//				빈 칸에 바이러스를 다 퍼뜨리지 못한 경우
				return;
			}

			ans = Math.min(ans, max);
			return;

		}

		for (int i = start; i < virus.size(); i++) {
			numbers[cnt] = i;
			combination(i + 1, cnt + 1);
		}
	}

}
