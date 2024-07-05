package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

//	상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] type_one = { 0, 1, 2, 3 };

//	상하
	static int[] type_two = { 0, 1 };

//	좌우
	static int[] type_three = { 2, 3 };

//	상우
	static int[] type_four = { 0, 3 };

//	하우
	static int[] type_five = { 1, 3 };

//	하좌
	static int[] type_six = { 1, 2 };

//	상좌
	static int[] type_seven = { 0, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int[] manhole = new int[2];
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			manhole[0] = Integer.parseInt(st.nextToken());
			manhole[1] = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			int[][] dist = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = -1;
				}
			}
			int cnt = 1;
			if (l == 1) {
				sb.append(1).append("\n");
				continue;
			}
			
//			init done

			Queue<int[]> q = new LinkedList<>();
			dist[manhole[0]][manhole[1]] = 1;
			q.offer(manhole);
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				switch (map[cur[0]][cur[1]]) {
				case 1:
					for (int d : type_one) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (goContinue(map, dist, nx, ny, n, m))
							continue;
						if (noConnect(map, nx, ny, n, m, d))
							continue;
						if (dist[cur[0]][cur[1]] < l) {
							dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
							cnt++;
							q.offer(new int[] { nx, ny });
						}
					}
					break;
				case 2:
					for (int d : type_two) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (goContinue(map, dist, nx, ny, n, m))
							continue;
						if (noConnect(map, nx, ny, n, m, d))
							continue;
						if (dist[cur[0]][cur[1]] < l) {
							dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
							cnt++;
							q.offer(new int[] { nx, ny });
						}
					}
					break;
				case 3:
					for (int d : type_three) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (goContinue(map, dist, nx, ny, n, m))
							continue;
						if (noConnect(map, nx, ny, n, m, d))
							continue;
						if (dist[cur[0]][cur[1]] < l) {
							dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
							cnt++;
							q.offer(new int[] { nx, ny });
						}
					}
					break;
				case 4:
					for (int d : type_four) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (goContinue(map, dist, nx, ny, n, m))
							continue;
						if (noConnect(map, nx, ny, n, m, d))
							continue;
						if (dist[cur[0]][cur[1]] < l) {
							dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
							cnt++;
							q.offer(new int[] { nx, ny });
						}
					}
					break;
				case 5:
					for (int d : type_five) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (goContinue(map, dist, nx, ny, n, m))
							continue;
						if (noConnect(map, nx, ny, n, m, d))
							continue;
						if (dist[cur[0]][cur[1]] < l) {
							dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
							cnt++;
							q.offer(new int[] { nx, ny });
						}
					}
					break;
				case 6:
					for (int d : type_six) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (goContinue(map, dist, nx, ny, n, m))
							continue;
						if (noConnect(map, nx, ny, n, m, d))
							continue;
						if (dist[cur[0]][cur[1]] < l) {
							dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
							cnt++;
							q.offer(new int[] { nx, ny });
						}
					}
					break;
				case 7:
					for (int d : type_seven) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];
						if (goContinue(map, dist, nx, ny, n, m))
							continue;
						if (noConnect(map, nx, ny, n, m, d))
							continue;
						if (dist[cur[0]][cur[1]] < l) {
							dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
							cnt++;
							q.offer(new int[] { nx, ny });
						}
					}
					break;
				}
//				print(dist, n, m);
			}
			sb.append(cnt).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean goContinue(int[][] map, int[][] dist, int nx, int ny, int n, int m) {
		if (nx < 0 || ny < 0 || nx >= n || ny >= m)
			return true;
		if (dist[nx][ny] != -1)
			return true;
		if (map[nx][ny] == 0)
			return true;
		return false;
	}

	private static boolean noConnect(int[][] map, int nx, int ny, int n, int m, int d) {
		switch (d) {
		case 0:
			if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)
				return true;
			else
				return false;
		case 1:
			if (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)
				return true;
			else
				return false;
		case 2:
			if (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)
				return true;
			else
				return false;
		case 3:
			if (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)
				return true;
			else
				return false;
		}
		return true;
	}
}
