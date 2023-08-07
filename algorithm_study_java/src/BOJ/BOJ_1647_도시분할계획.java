package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		// edge를 weight로 오름차순 정렬
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}

		});

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			pq.offer(new Edge(from, to, weight));
		}

		// init done

		int hap = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			if (cnt == n - 2) {
				break;
			}

			Edge edge = pq.poll();

			int fromRoot = find(parents, edge.from);
			int toRoot = find(parents, edge.to);

			if (fromRoot == toRoot) {
				continue;
			}

			parents[fromRoot] = toRoot;
			hap += edge.weight;
			cnt++;

		}

		System.out.println(hap);

	}

	static public int find(int[] parents, int num) {
		if (parents[num] == num) {
			return num;
		}
		return parents[num] = find(parents, parents[num]);
	}

}
