package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {

	static int[] cnt = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[101][101];
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		int[] cnt;
		int time = 0;
		int sizeR = 3;
		int sizeC = 3;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}

		});

		while (time <= 100) {
			if (map[r][c] == k) {
				System.out.println(time);
				return;
			}

			if (sizeR >= sizeC) {
				// R 연산 실행
				int max = 0;
				for (int i = 1; i <= sizeR; i++) {
					cnt = new int[101];
					for (int j = 1; j <= sizeC; j++) {
						cnt[map[i][j]]++;
					}

					// pq 설정
					for (int j = 1; j <= 100; j++) {
						if (cnt[j] == 0)
							continue;
						pq.offer(new int[] { j, cnt[j] });
					}

					int y = 1;
					int size = pq.size() * 2;
					max = Math.max(max, size);

					while (!pq.isEmpty()) {
						int[] cur = pq.poll();

						map[i][y] = cur[0];
						y++;
						map[i][y] = cur[1];
						y++;
					}

					for (int j = size + 1; j <= sizeC; j++) {
						map[i][j] = 0;
					}
				}
				sizeC = max;
			} else {
				// C 연산 실행
				int max = 0;
				for (int i = 1; i <= sizeC; i++) {
					cnt = new int[101];
					for (int j = 1; j <= sizeR; j++) {
						cnt[map[j][i]]++;
					}

					// pq 설정
					for (int j = 1; j <= 100; j++) {
						if (cnt[j] == 0)
							continue;
						pq.offer(new int[] { j, cnt[j] });
					}

					int x = 1;
					int size = pq.size() * 2;
					max = Math.max(max, size);

					while (!pq.isEmpty()) {
						int[] cur = pq.poll();

						map[x][i] = cur[0];
						x++;
						map[x][i] = cur[1];
						x++;
					}

					for (int j = size + 1; j <= sizeR; j++) {
						map[j][i] = 0;
					}
				}
				sizeR = max;
			}
			time++;
		}

		System.out.println(-1);

	}

}
