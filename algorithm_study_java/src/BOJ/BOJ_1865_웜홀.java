package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {

	static class Edge {
		int start, end, time;

		public Edge(int start, int end, int time) {
			super();
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		C: for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			List<Edge> edgeList = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				edgeList.add(new Edge(start, end, time));
				edgeList.add(new Edge(end, start, time));
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken()) * -1;

				edgeList.add(new Edge(start, end, time));
			}

			// init done

			int[] dist = new int[n + 1];
			Arrays.fill(dist, 100000000);
			dist[1] = 0;
			for (int v = 0; v < n; v++) {
				for (Edge edge : edgeList) {
					if (dist[edge.end] > dist[edge.start] + edge.time) {
						dist[edge.end] = dist[edge.start] + edge.time;

						if (v == n - 1) {
							sb.append("YES\n");
							continue C;
						}
					}
				}
			}
			sb.append("NO\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
