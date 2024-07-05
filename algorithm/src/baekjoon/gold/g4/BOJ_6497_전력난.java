package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6497_전력난 {

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

	static class Vertex {
		int num;
		int dist;

		public Vertex(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine().trim());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if (m == 0 && n == 0)
				break;

			int hap = 0;
			Node[] adjList = new Node[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());

				adjList[x] = new Node(y, z, adjList[x]);
				adjList[y] = new Node(x, z, adjList[y]);

				hap += z;
			}

			// init done

			int[] minEdge = new int[n];
			boolean[] visited = new boolean[n];

			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[0] = 0;

			PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {

				@Override
				public int compare(Vertex o1, Vertex o2) {
					return o1.dist - o2.dist;
				}

			});
			pq.offer(new Vertex(0, 0));

			int cnt = 0;
			int result = 0;
			while (!pq.isEmpty()) {
				Vertex cur = pq.poll();

				if (visited[cur.num])
					continue;

				visited[cur.num] = true;
				result += cur.dist;
				if (++cnt == n)
					break;

				for (Node temp = adjList[cur.num]; temp != null; temp = temp.next) {
					if (!visited[temp.to] && minEdge[temp.to] > temp.dist) {
						minEdge[temp.to] = temp.dist;
						pq.offer(new Vertex(temp.to, minEdge[temp.to]));
					}
				}
			}

			sb.append(hap - result).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
