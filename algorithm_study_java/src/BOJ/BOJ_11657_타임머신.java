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

public class BOJ_11657_타임머신 {

	static class Edge {
		int start;
		int end;
		long time;

		public Edge(int start, int end, long time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long time = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(start, end, time));
		}

		// init done

		long[] dist = new long[n + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;

		for (int i = 0; i < n; i++) {
			for (Edge e : edgeList) {
				if (dist[e.start] != Long.MAX_VALUE && dist[e.end] > dist[e.start] + e.time)
					dist[e.end] = dist[e.start] + e.time;
			}
		}

		boolean isCycle = false;
		for (Edge e : edgeList) {
			if (dist[e.start] != Long.MAX_VALUE && dist[e.end] > dist[e.start] + e.time) {
				isCycle = true;
				break;
			}
		}

		if (isCycle) {
			sb.append(-1);
		} else {
			for (int i = 2; i <= n; i++) {
				if (dist[i] == Long.MAX_VALUE)
					sb.append(-1).append("\n");
				else
					sb.append(dist[i]).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
