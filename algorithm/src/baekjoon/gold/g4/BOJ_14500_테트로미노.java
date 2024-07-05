package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {

	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		block(map, n, m, new int[] { 0, 0, 0, 0 }, new int[] { 0, 1, 2, 3 });
		block(map, n, m, new int[] { 0, 1, 2, 3 }, new int[] { 0, 0, 0, 0 });
		
		block(map, n, m, new int[] { 0, 0, 1, 1 }, new int[] { 0, 1, 0, 1 });

		block(map, n, m, new int[] { 0, 0, 0, 1 }, new int[] { 0, 1, 2, 0 });
		block(map, n, m, new int[] { 0, 1, 2, 2 }, new int[] { 0, 0, 0, 1 });
		block(map, n, m, new int[] { 0, 0, 0, -1 }, new int[] { 0, 1, 2, 2 });
		block(map, n, m, new int[] { 0, 0, 1, 2 }, new int[] { 0, 1, 1, 1 });
		
		block(map, n, m, new int[] { 0, 0, 0, 1 }, new int[] { 0, 1, 2, 2 });
		block(map, n, m, new int[] { 0, 1, 2, 2 }, new int[] { 0, 0, 0, -1 });
		block(map, n, m, new int[] { 0, 0, 0, -1 }, new int[] { 0, 1, 2, 0 });
		block(map, n, m, new int[] { 0, 0, 1, 2 }, new int[] { 1, 0, 0, 0 });

		block(map, n, m, new int[] { 0, 1, 1, 2 }, new int[] { 0, 0, 1, 1 });
		block(map, n, m, new int[] { 0, 0, 1, 1 }, new int[] { 0, 1, 0, -1 });
		block(map, n, m, new int[] { 0, 1, 1, 2 }, new int[] { 0, 0, -1, -1 });
		block(map, n, m, new int[] { 0, 0, 1, 1 }, new int[] { 0, 1, 1, 2 });

		block(map, n, m, new int[] { 0, 0, 0, 1 }, new int[] { 0, 1, 2, 1 });
		block(map, n, m, new int[] { 0, 1, 2, 1 }, new int[] { 0, 0, 0, 1 });
		block(map, n, m, new int[] { 0, 0, 0, -1 }, new int[] { 0, 1, 2, 1 });
		block(map, n, m, new int[] { 0, -1, 0, 1 }, new int[] { 0, 1, 1, 1 });

		System.out.println(ans);

	}

	private static void block(int[][] map, int n, int m, int[] dx, int[] dy) {
		int x = 0;
		int y = 0;
		C: while (true) {
			int hap = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0) {
					x++;
					continue C;
				} else if (ny < 0) {
					y++;
					continue C;
				} else if (nx >= n) {
					break C;
				} else if (ny >= m) {
					x++;
					y = 0;
					continue C;
				}
				hap += map[nx][ny];
			}
			y++;
			if (ans < hap)
				ans = hap;
		}
	}

}
