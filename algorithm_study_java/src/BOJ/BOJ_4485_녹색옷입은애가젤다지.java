package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static int dx[] = { 1, 0, 0, -1 };
	static int dy[] = { 0, 1, -1, 0 };

	static class Rupee {
		int r, c, weight;

		public Rupee(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int pNum = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			sb.append("Problem ").append(pNum).append(": ");

			int[][] D = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				Arrays.fill(D[i], Integer.MAX_VALUE);
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			D[0][0] = map[0][0];

//			그냥 다익스트라
//			int min, minR, minC;
//			while (true) {
//				min = Integer.MAX_VALUE;
//				minR = -1;
//				minC = -1;
//				for (int i = 0; i < n; i++) {
//					for (int j = 0; j < n; j++) {
//						if (!visited[i][j] && min > D[i][j]) {
//							min = D[i][j];
//							minR = i;
//							minC = j;
//						}
//
//					}
//				}
//
//				if (minR == -1 && minC == -1)
//					break;
//				visited[minR][minC] = true;
//				if (minR == n - 1 && minC == n - 1)
//					break;
//
//				for (int d = 0; d < 4; d++) {
//					int nx = minR + dx[d];
//					int ny = minC + dy[d];
//					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
//						continue;
//					if (!visited[nx][ny] && D[nx][ny] > D[minR][minC] + map[nx][ny]) {
//						D[nx][ny] = D[minR][minC] + map[nx][ny];
//					}
//				}
//			}

			PriorityQueue<Rupee> pq = new PriorityQueue<>(new Comparator<Rupee>() {

				@Override
				public int compare(Rupee o1, Rupee o2) {
					return o1.weight - o2.weight;
				}

			});
			pq.offer(new Rupee(0, 0, D[0][0]));

			while (true) {
				Rupee minRupee = pq.poll();

				if (minRupee == null)
					break;
				if (visited[minRupee.r][minRupee.c])
					continue;

				visited[minRupee.r][minRupee.c] = true;

				for (int d = 0; d < 4; d++) {
					int nx = minRupee.r + dx[d];
					int ny = minRupee.c + dy[d];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n)
						continue;
					if (!visited[nx][ny] && D[nx][ny] > D[minRupee.r][minRupee.c] + map[nx][ny]) {
						D[nx][ny] = D[minRupee.r][minRupee.c] + map[nx][ny];
						pq.offer(new Rupee(nx, ny, D[nx][ny]));
					}
				}

			}
			sb.append(D[n - 1][n - 1]).append("\n");
			pNum++;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
