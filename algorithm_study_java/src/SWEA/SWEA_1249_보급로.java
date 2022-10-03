package algorithm_study_java;

import java.io.*;
import java.util.*;

public class SWEA_1249_보급로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int[][] D = new int[n][n];
			for (int i = 0; i < n; i++) {
				char[] row = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = row[j] - '0';
					D[i][j] = Integer.MAX_VALUE;
				}
			}

			int dx[] = { 1, 0, -1, 0 };
			int dy[] = { 0, 1, 0, -1 };

			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			int[] pos = { 0, 0, 0 };
			q.offer(pos);

			while (!q.isEmpty()) {
				int c = q.peek()[0];
				int x = q.peek()[1];
				int y = q.peek()[2];
				q.poll();

				int cost = map[x][y] + c;
				if (cost >= D[x][y])
					continue;
				D[x][y] = cost;

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;
					q.offer(new int[] { cost, nx, ny });
				}
			}

			sb.append(D[n - 1][n - 1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
