package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] input = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			input[i][0] = cost;
			input[i][1] = customer;
		}

		int[][] dist = new int[n + 1][c + 101];
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= c + 100; j++) {
				dist[i][j] = -1;
			}
		}

		// init done

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int cost = input[i][0];
			int customer = input[i][1];
			for (int j = 1; j <= c + 100; j++) {
				if (dist[i - 1][j] != -1) {
					dist[i][j] = dist[i - 1][j];
					if (j - customer >= 0 && dist[i][j - customer] != -1)
						dist[i][j] = Math.min(dist[i][j], dist[i][j - customer] + cost);
				} else {
					if (j - customer >= 0 && dist[i][j - customer] != -1)
						dist[i][j] = dist[i][j - customer] + cost;
				}

				if (i == n && j >= c && dist[i][j] != -1)
					min = Math.min(min, dist[i][j]);
			}
		}

		System.out.println(min);

	}

}
