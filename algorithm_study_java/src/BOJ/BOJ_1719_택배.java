package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1719_택배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][][] dist = new int[n + 1][n + 1][2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					dist[i][i][0] = 0;
					continue;
				}
				dist[i][j][0] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			dist[from][to][0] = time;
			dist[to][from][0] = time;

//			다른 노드를 거치지 않고 바로 연결된 경로를 기억
			dist[from][to][1] = time;
			dist[to][from][1] = time;
		}

//		init done

//		플로이드-워샬
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][k][0] != Integer.MAX_VALUE && dist[k][j][0] != Integer.MAX_VALUE) {
						dist[i][j][0] = Math.min(dist[i][j][0], dist[i][k][0] + dist[k][j][0]);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					sb.append("-").append(" ");
					continue;
				}

//				첫번째 경유지로 어디를 갔을 때 최단 거리인가
				int stopover = 0;
				int min = Integer.MAX_VALUE;

				for (int k = 1; k <= n; k++) {
//					직접 연결된 경로만 탐색
					if (dist[i][k][1] != 0) {
						if (min > dist[i][k][1] + dist[k][j][0]) {
							stopover = k;
							min = dist[i][k][1] + dist[k][j][0];
						}
					}
				}

				sb.append(stopover).append(" ");
			}

			sb.append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
