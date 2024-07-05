package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		boolean[][] visit = new boolean[n][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

//		init done

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '1' && !visit[i][j]) {
					queue.offer(new int[] { i, j });
					visit[i][j] = true;
					int cnt = 1;

					while (!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];

							if (nx < 0 || ny < 0 || nx >= n || ny >= n)
								continue;

							if (map[nx][ny] == '0' || visit[nx][ny])
								continue;

							visit[nx][ny] = true;
							cnt++;
							queue.offer(new int[] { nx, ny });
						}
					}
					pq.add(cnt);
				}
			}
		}

		sb.append(pq.size()).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
