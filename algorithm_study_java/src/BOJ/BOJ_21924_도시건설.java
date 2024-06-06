package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21924_도시건설 {

	static class Node {
		int to;
		long dist;
		Node next;

		public Node(int to, long dist, Node next) {
			this.to = to;
			this.dist = dist;
			this.next = next;
		}
	}

	static class Vertex {
		int num;
		long dist;

		public Vertex(int num, long dist) {
			this.num = num;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

//		모든 도로를 다 설치할 때 드는 비용
		long total = 0;

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long dist = Long.parseLong(st.nextToken());

			adjList[from] = new Node(to, dist, adjList[from]);
			adjList[to] = new Node(from, dist, adjList[to]);

			total += dist;
		}

//		init done

		PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return (int) (o1.dist - o2.dist);
			}

		});

		long[] minEdge = new long[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

//		임의의 점부터 시작
		minEdge[1] = 0;
		pq.offer(new Vertex(1, 0));

		int cnt = 0;
		long hap = 0;
		while (!pq.isEmpty()) {
			Vertex cur = pq.poll();

			if (visited[cur.num])
				continue;

			hap += cur.dist;
			visited[cur.num] = true;

			if (++cnt == n)
				break;

			for (Node temp = adjList[cur.num]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && minEdge[temp.to] > temp.dist) {
					minEdge[temp.to] = temp.dist;
					pq.offer(new Vertex(temp.to, temp.dist));
				}
			}
		}

		if (cnt != n) {
			System.out.println(-1);
			return;
		}

		System.out.println(total - hap);

	}
}
