package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14950_정복자 {

	static class Node {
		int to, dist;
		Node next;

		public Node(int to, int dist, Node next) {
			this.to = to;
			this.dist = dist;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, dist, adjList[from]);
			adjList[to] = new Node(from, dist, adjList[to]);
		}

//		init done

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		int[] minEdge = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		pq.offer(new int[] { 1, 0 });

		int cnt = 0;
		int hap = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (visited[cur[0]])
				continue;

			hap += cur[1];
			visited[cur[0]] = true;

			if (++cnt == n)
				break;

			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && minEdge[temp.to] > temp.dist) {
					minEdge[temp.to] = temp.dist;
					pq.offer(new int[] { temp.to, temp.dist });
				}
			}
		}

//		한 번 정복할 때마다 t씩 비용 증가
		System.out.println(hap + (t * (n - 2) * (n - 1) / 2));

	}

}
