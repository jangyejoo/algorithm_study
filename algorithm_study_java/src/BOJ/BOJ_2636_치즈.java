package BOJ;

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

public class BOJ_2636_치즈 {

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int h, w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int[][] map = new int[h][w];

		List<int[]> cheeses = new ArrayList<>();
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheeses.add(new int[] { i, j });
				}
			}
		}

//		init done

		int ans = 0;
		List<Integer> size = new ArrayList<>();
		size.add(cheeses.size());
		while (!cheeses.isEmpty()) { // 치즈가 다 녹을때까지
			List<Integer> melt = new ArrayList<>();
			outside(map);

			// 녹일 치즈 정하기
			for (int i = 0; i < cheeses.size(); i++) {
				for (int d = 0; d < 4; d++) {
					int nx = cheeses.get(i)[0] + dx[d];
					int ny = cheeses.get(i)[1] + dy[d];

					if (map[nx][ny] == 2) {
						melt.add(i);
						break;
					}
				}
			}

			// 한번에 치즈 녹이기
			if (!melt.isEmpty()) {
				for (int i = melt.size() - 1; i >= 0; i--) {
					int index = melt.get(i);
					map[cheeses.get(index)[0]][cheeses.get(index)[1]] = 2;
					cheeses.remove(index);
				}
			}

			size.add(cheeses.size());
			ans++;
		}

		sb.append(ans).append("\n").append(size.get(ans - 1)).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void outside(int[][] map) {
		boolean[][] visited = new boolean[h][w];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= h || ny >= w)
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == 1)
					continue;

				map[nx][ny] = 2;
				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
			}
		}
	}

}
