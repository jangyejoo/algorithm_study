package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14621_나만안되는연애 {

	static class Node {
		int to;
		int dist;
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

		st = new StringTokenizer(br.readLine().trim());
		char[] node = new char[n + 1];
		for (int i = 1; i <= n; i++) {
			node[i] = st.nextToken().charAt(0);
		}

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

//			from이 to와 같으면 경로로 저장하지 않기
			if (node[from] == node[to])
				continue;

			adjList[from] = new Node(to, dist, adjList[from]);
			adjList[to] = new Node(from, dist, adjList[to]);
		}

//		init done

		int[] dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		dist[1] = 0;
		pq.offer(new int[] { 1, 0 });

		int cnt = 0;
		int result = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			int no = cur[0];
			int d = cur[1];

			if (visited[no])
				continue;

			visited[no] = true;

			result += d;
			if (++cnt == n)
				break;

			for (Node temp = adjList[no]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && dist[temp.to] > temp.dist) {
					dist[temp.to] = temp.dist;
					pq.offer(new int[] { temp.to, dist[temp.to] });
				}
			}
		}

		if (cnt != n) {
			System.out.println(-1);
			return;
		}

		System.out.println(result);

	}

}
