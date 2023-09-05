package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915_가장큰정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(row.charAt(j) + "");
				if (map[i][j] == 1)
					max = 1;
			}
		}

		// init done

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					continue;

				int a = 0;
				int b = 0;
				int c = 0;
				if (i != 0) {
					// 첫번째 행
					b = map[i - 1][j];
					if (j != 0) {
						// 첫번째 열
						a = map[i - 1][j - 1];
						c = map[i][j - 1];
					}
				}

				int min = Math.min(a, b);
				min = Math.min(min, c);

				if (min == 0)
					continue;

				map[i][j] = min + 1;
				max = Math.max(max, map[i][j]);

			}
		}

		System.out.println(max * max);
	}

}
