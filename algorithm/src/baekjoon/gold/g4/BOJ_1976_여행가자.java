package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == j)
					map[i][j] = 1;
			}
		}

		int[] plan = new int[m];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][k] != 0 && map[k][j] != 0)
						map[i][j] = 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < m - 1; i++) {
			if (map[plan[i]][plan[i + 1]] == 1)
				continue;
			System.out.println("NO");
			return;
		}

		System.out.println("YES");

	}

}
