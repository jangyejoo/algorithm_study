package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int[][] dist = new int[v + 1][v + 1];
		for (int i = 0; i <= v; i++) {
			for (int j = 0; j <= v; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int E = 0; E < e; E++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			dist[a][b] = c;
		}

		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				for (int j = 1; j <= v; j++) {
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < v; i++) {
			if (dist[i][i] == Integer.MAX_VALUE)
				continue;
			ans = Math.min(ans, dist[i][i]);
		}

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

}
