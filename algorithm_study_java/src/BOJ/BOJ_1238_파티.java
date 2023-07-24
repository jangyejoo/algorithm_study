package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			adjList[start] = new Node(end, distance, adjList[start]);
		}

		// init done

		// ver 1.
//		boolean[] visited = new boolean[n + 1];
//		int[] dist = new int[n + 1];
//		Arrays.fill(dist, Integer.MAX_VALUE);
//		dist[x] = 0;
//
//		for (int i = 1; i <= n; i++) {
//			int nodeDist = Integer.MAX_VALUE;
//			int nodeIdx = 0;
//			for (int j = 1; j <= n; j++) {
//				if (!visited[j] && dist[j] < nodeDist) {
//					nodeDist = dist[j];
//					nodeIdx = j;
//				}
//			}
//			visited[nodeIdx] = true;
//			for (Node temp = adjList[nodeIdx]; temp != null; temp = temp.next) {
//				dist[temp.vertex] = Math.min(dist[temp.vertex], dist[nodeIdx] + temp.weight);
//			}
//		}
//
//		int ans = 0;
//		for (int i = 1; i <= n; i++) {
//			visited = new boolean[n + 1];
//			int[] NtoX = new int[n + 1];
//			Arrays.fill(NtoX, Integer.MAX_VALUE);
//			NtoX[i] = 0;
//			for (int i2 = 1; i2 <= n; i2++) {
//				int nodeDist = Integer.MAX_VALUE;
//				int nodeIdx = 0;
//				for (int j = 1; j <= n; j++) {
//					if (!visited[j] && NtoX[j] < nodeDist) {
//						nodeDist = NtoX[j];
//						nodeIdx = j;
//					}
//				}
//				visited[nodeIdx] = true;
//				for (Node temp = adjList[nodeIdx]; temp != null; temp = temp.next) {
//					NtoX[temp.vertex] = Math.min(NtoX[temp.vertex], NtoX[nodeIdx] + temp.weight);
//				}
//			}
//			dist[i] += NtoX[x];
//			ans = Math.max(ans, dist[i]);
//		}
//
//		System.out.println(ans);

		// ver 2.
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		q.offer(new int[] { x, 0 });
		dist[x] = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (dist[cur[0]] < cur[1]) {
				continue;
			}
			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (dist[temp.vertex] > cur[1] + temp.weight) {
					dist[temp.vertex] = cur[1] + temp.weight;
					q.offer(new int[] { temp.vertex, dist[temp.vertex] });
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int[] NtoX = new int[n + 1];
			Arrays.fill(NtoX, Integer.MAX_VALUE);
			q.offer(new int[] { i, 0 });
			NtoX[i] = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				if (NtoX[cur[0]] < cur[1]) {
					continue;
				}
				for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
					if (NtoX[temp.vertex] > cur[1] + temp.weight) {
						NtoX[temp.vertex] = cur[1] + temp.weight;
						q.offer(new int[] { temp.vertex, NtoX[temp.vertex] });
					}
				}
			}
			dist[i] += NtoX[x];
			ans = Math.max(ans, dist[i]);
		}

		System.out.println(ans);
	}
}