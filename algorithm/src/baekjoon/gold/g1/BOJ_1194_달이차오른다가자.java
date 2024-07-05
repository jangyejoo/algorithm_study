package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n, m, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][m];

		Queue<int[]> q = new LinkedList<>();
		int visited[][][] = new int[n][m][127];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}

		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = row[j];
				if (map[i][j] == '0') {
					q.offer(new int[] { i, j, 0 });
					visited[i][j][0] = 0;
				}
			}
		}

//		init done 

		int ans = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (map[cur[0]][cur[1]] == '1') {
				if (ans > visited[cur[0]][cur[1]][cur[2]]) {
					ans = visited[cur[0]][cur[1]][cur[2]];
					break;
				}
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (map[nx][ny] == '#')
					continue;

				if (visited[nx][ny][cur[2]] != -1)
					continue;

				if (map[nx][ny] == 'a') {
					if ((cur[2] & (1 << 1)) == 0) {
						visited[nx][ny][cur[2] | 1 << 1] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] | 1 << 1 });
					} else {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'b') {
					if ((cur[2] & (1 << 2)) == 0) {
						visited[nx][ny][cur[2] | 1 << 2] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] | 1 << 2 });
					} else {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'c') {
					if ((cur[2] & (1 << 3)) == 0) {
						visited[nx][ny][cur[2] | 1 << 3] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] | 1 << 3 });
					} else {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'd') {
					if ((cur[2] & (1 << 4)) == 0) {
						visited[nx][ny][cur[2] | 1 << 4] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] | 1 << 4 });
					} else {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'e') {
					if ((cur[2] & (1 << 5)) == 0) {
						visited[nx][ny][cur[2] | 1 << 5] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] | 1 << 5 });
					} else {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'f') {
					if ((cur[2] & (1 << 6)) == 0) {
						visited[nx][ny][cur[2] | 1 << 6] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] | 1 << 6 });
					} else {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'A') {
					if ((cur[2] & (1 << 1)) != 0) {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'B') {
					if ((cur[2] & (1 << 2)) != 0) {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'C') {
					if ((cur[2] & (1 << 3)) != 0) {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}

				} else if (map[nx][ny] == 'D') {
					if ((cur[2] & (1 << 4)) != 0) {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'E') {
					if ((cur[2] & (1 << 5)) != 0) {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else if (map[nx][ny] == 'F') {
					if ((cur[2] & (1 << 6)) != 0) {
						visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
						q.offer(new int[] { nx, ny, cur[2] });
					}
				} else {
					visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
					q.offer(new int[] { nx, ny, cur[2] });
				}
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

}
