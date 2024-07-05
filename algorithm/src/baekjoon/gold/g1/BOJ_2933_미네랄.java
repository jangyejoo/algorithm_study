package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2933_미네랄 {

	static char[][] map;
	static int r, c, input[];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int n = Integer.parseInt(br.readLine());
		input = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		play(n);

		print();
	}

	private static void play(int n) {
		for (int t = 0; t < n; t++) {

			// 1. 막대 던짐
			if (t % 2 == 1) {
				// 오른쪽부터
				for (int j = c - 1; j >= 0; j--) {
					if (map[r - input[t]][j] == 'x') {
						map[r - input[t]][j] = '.';
						break;
					}
				}
			} else {
				// 왼쪽부터
				for (int j = 0; j < c; j++) {
					if (map[r - input[t]][j] == 'x') {
						map[r - input[t]][j] = '.';
						break;
					}
				}
			}

			// 2. 클러스터 떨구기
			int[][] types = new int[r][c];
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < c; i++) {
				if (map[r - 1][i] == 'x') {
					q.offer(new int[] { r - 1, i });
					types[r - 1][i] = 1;
				}
			}

			// 2-1. 땅에 붙어있는 클러스터 범위 찾기
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (types[nx][ny] != 0)
						continue;
					if (map[nx][ny] == '.')
						continue;

					types[nx][ny] = 1;
					q.offer(new int[] { nx, ny });
				}
			}

			// 2-2. 땅에 안붙어있는 클러스터 떨구기

			// 2-2-1. 클러스터 범위 찾기
			int type = 2;
			List<int[]> cluster = new ArrayList<>();
			B: for (int i = r - 1; i >= 0; i--) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == 'x' && types[i][j] == 0) {
						q.offer(new int[] { i, j });
						cluster.add(new int[] { i, j });
						types[i][j] = type;

						while (!q.isEmpty()) {
							int[] cur = q.poll();
							int x = cur[0];
							int y = cur[1];
							for (int d = 0; d < 4; d++) {
								int nx = x + dx[d];
								int ny = y + dy[d];

								if (nx < 0 || ny < 0 || nx >= r || ny >= c)
									continue;
								if (types[nx][ny] != 0)
									continue;
								if (map[nx][ny] == '.')
									continue;

								types[nx][ny] = type;
								q.offer(new int[] { nx, ny });
								cluster.add(new int[] { nx, ny });
							}
						}
						break B;
					}
				}
			}

			// 2-2-2. 클러스터 닿을 때까지 한 칸씩 떨구기
			int drop = 1;
			if (!cluster.isEmpty()) {
				B: while (true) {
					for (int[] cur : cluster) {
						if (cur[0] + drop >= r
								|| map[cur[0] + drop][cur[1]] == 'x' && types[cur[0] + drop][cur[1]] == 1) {
							drop--;
							break B;
						}
					}
					drop++;
				}

				for (int[] cur : cluster) {
					map[cur[0]][cur[1]] = '.';
				}

				for (int[] cur : cluster) {
					map[cur[0] + drop][cur[1]] = 'x';
				}
			}

		}
	}

	private static void print() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
