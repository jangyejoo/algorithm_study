package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

//		init done

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		dist[0][0] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1 && cur[1] == m - 1)
				break;
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (map[nx][ny] == '0')
					continue;
				if (dist[nx][ny] != 0)
					continue;
				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
				q.offer(new int[] { nx, ny });
			}
		}

		System.out.println(dist[n - 1][m - 1]);

	}

}