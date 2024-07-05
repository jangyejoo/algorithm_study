package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][n + 1];
		int[][] likes = new int[n * n + 1][4];
		for (int s = 0; s < n * n; s++) {
			st = new StringTokenizer(br.readLine().trim());

			int student = Integer.parseInt(st.nextToken());
			likes[student][0] = Integer.parseInt(st.nextToken());
			likes[student][1] = Integer.parseInt(st.nextToken());
			likes[student][2] = Integer.parseInt(st.nextToken());
			likes[student][3] = Integer.parseInt(st.nextToken());

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0]) {
						if (o1[1] == o2[1]) {
							if (o1[2] == o2[2]) {
								return o1[3] - o2[3];
							}
							return o1[2] - o2[2];
						}
						return o2[1] - o1[1];
					}
					return o2[0] - o1[0];
				}

			});

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] != 0)
						continue;

					int likeCnt = 0;
					int emptyCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (nx < 1 || ny < 1 || nx > n || ny > n)
							continue;

						if (map[nx][ny] == 0) {
							emptyCnt++;
							continue;
						}

						for (int l = 0; l < 4; l++) {
							if (map[nx][ny] == likes[student][l]) {
								likeCnt++;
								break;
							}
						}
					}
					pq.offer(new int[] { likeCnt, emptyCnt, i, j });
				}
			}

			int[] priority = pq.poll();
			map[priority[2]][priority[3]] = student;
		}

		// 만족도 계산
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int likeCnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (nx < 1 || ny < 1 || nx > n || ny > n)
						continue;

					for (int l = 0; l < 4; l++) {
						if (map[nx][ny] == likes[map[i][j]][l])
							likeCnt++;
					}
				}

				if (likeCnt == 4) {
					ans += 1000;
				} else if (likeCnt == 3) {
					ans += 100;
				} else if (likeCnt == 2) {
					ans += 10;
				} else if (likeCnt == 1) {
					ans++;
				}
			}
		}

		System.out.println(ans);

	}

}
