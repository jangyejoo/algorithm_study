package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10423_전기가부족해 {

	static class Node {
		int to, cost;
		Node next;

		public Node(int to, int cost, Node next) {
			this.to = to;
			this.cost = cost;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[n + 1];
		int[] minEdge = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());
			minEdge[num] = 0;
			pq.offer(new int[] { num, 0 });
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, cost, adjList[from]);
			adjList[to] = new Node(from, cost, adjList[to]);
		}

//		init done

		int cnt = 0;
		int result = 0;

		while (true) {
			int[] cur = pq.poll();

			if (visited[cur[0]])
				continue;

			visited[cur[0]] = true;
			result += cur[1];
			if (++cnt == n)
				break;

			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && minEdge[temp.to] > temp.cost) {
					minEdge[temp.to] = temp.cost;
					pq.offer(new int[] { temp.to, minEdge[temp.to] });
				}
			}
		}

		System.out.println(result);

	}

}
