package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {

	static class Node {
		int to;
		double dist;
		Node next;

		public Node(int to, double dist, Node next) {
			this.to = to;
			this.dist = dist;
			this.next = next;
		}
	}

	static class Vertex {
		int to;
		double dist;

		public Vertex(int to, double dist) {
			this.to = to;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		double[][] input = new double[n + 1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			input[i][0] = x;
			input[i][1] = y;
		}

//		init done

		Node[] adjList = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;

				double squareX = (input[i][0] - input[j][0]) * (input[i][0] - input[j][0]);
				double squareY = (input[i][1] - input[j][1]) * (input[i][1] - input[j][1]);
				double dist = Math.sqrt(squareX + squareY);

				adjList[i] = new Node(j, dist, adjList[i]);
				adjList[j] = new Node(i, dist, adjList[j]);
			}
		}

		PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.dist));

		int cnt = 0;
		double ans = 0;
		double[] minEdge = new double[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(minEdge, Double.MAX_VALUE);

//		임의의 처음 정점
		minEdge[1] = 0;
		pq.offer(new Vertex(1, 0));

		while (true) {
			Vertex cur = pq.poll();

			if (visited[cur.to])
				continue;

			ans += cur.dist;
			visited[cur.to] = true;

			if (++cnt == n)
				break;

			for (Node temp = adjList[cur.to]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && minEdge[temp.to] > temp.dist) {
					minEdge[temp.to] = temp.dist;
					pq.offer(new Vertex(temp.to, minEdge[temp.to]));
				}
			}
		}

		System.out.println(Math.round(ans * 100.0) / 100.0);

	}

}
