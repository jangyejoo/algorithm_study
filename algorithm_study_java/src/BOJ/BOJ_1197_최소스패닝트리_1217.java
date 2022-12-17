package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리_1217 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		Edge[] edgeList = new Edge[e];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		int[] parents = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}

		Arrays.sort(edgeList);

		int ans = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(parents, edge.to, edge.from)) {
				ans += edge.weight;
				if (++cnt == v - 1)
					break;
			}
		}
		
		System.out.println(ans);

	}

	static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents, parents[a]);
	}

	static boolean union(int[] parents, int a, int b) {
		int aRoot = find(parents, a);
		int bRoot = find(parents, b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

}
