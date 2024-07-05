package baekjoon.gold.g4;

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

public class BOJ_14502_연구소 {

	static List<int[]> zero, virus;
	static int[] numbers;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n, m, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		zero = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zero.add(new int[] { i, j });
				else if (map[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}

//		init done

		ans = 0;
		numbers = new int[3];
		build(map, 0, 0);

		System.out.println(ans);

	}

	private static void build(int[][] map, int cnt, int start) {
		if (cnt == 3) {
			// 벽 세우기
			for (int i = 0; i < 3; i++) {
				int x = zero.get(numbers[i])[0];
				int y = zero.get(numbers[i])[1];
				map[x][y] = 1;
			}

			// 빈 칸 개수 세기
			int c = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0)
						c++;
				}
			}

			// 만약 빈 칸 개수가 ans보다 작으면 가망 x이므로 return
			if (c < ans) {
				for (int i = 0; i < 3; i++) {
					int x = zero.get(numbers[i])[0];
					int y = zero.get(numbers[i])[1];
					map[x][y] = 0;
				}
				return;
			}

			// 바이러스 bfs
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[n][m];

			for (int i = 0; i < virus.size(); i++) {
				q.offer(new int[] { virus.get(i)[0], virus.get(i)[1] });
				visited[virus.get(i)[0]][virus.get(i)[1]] = true;
			}

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m)
						continue;
					if (map[nx][ny] == 1 || visited[nx][ny])
						continue;
					c--;
					// 만약 빈 칸 개수가 ans보다 작으면 가망 x이므로 return
					if (c < ans) {
						for (int i = 0; i < 3; i++) {
							int x = zero.get(numbers[i])[0];
							int y = zero.get(numbers[i])[1];
							map[x][y] = 0;
						}
						return;
					}
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}

			// 값 갱신
			if (ans < c)
				ans = c;

			// 벽 원래대로
			for (int i = 0; i < 3; i++) {
				int x = zero.get(numbers[i])[0];
				int y = zero.get(numbers[i])[1];
				map[x][y] = 0;
			}
			return;
		}
		for (int i = start; i < zero.size(); i++) {
			numbers[cnt] = i;
			build(map, cnt + 1, i + 1);
		}
	}

}
