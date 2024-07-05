package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13424_비밀모임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine().trim());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] distance = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;

					distance[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());

				distance[from][to] = dist;
				distance[to][from] = dist;
			}

			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine().trim());

			int[] friends = new int[k];
			for (int i = 0; i < k; i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}

//			init done

//			플로이드워샬
			for (int z = 1; z <= n; z++) {
				for (int x = 1; x <= n; x++) {
					for (int y = 1; y <= n; y++) {
						if (distance[x][z] != Integer.MAX_VALUE && distance[z][y] != Integer.MAX_VALUE)
							distance[x][y] = Math.min(distance[x][y], distance[x][z] + distance[z][y]);
					}
				}
			}

//			모든 방을 돌면서 최소 거리 구하기
			int ans = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				int hap = 0;
				for (int j = 0; j < k; j++) {
					hap += distance[i][friends[j]];
				}

				if (min > hap) {
					ans = i;
					min = hap;
				}
			}

			sb.append(ans).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
