package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1774_우주선과의교감 {

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
		int no;
		double dist;

		public Vertex(int no, double dist) {
			this.no = no;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][2];
		Node[] adjList = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[i][0] = x;
			map[i][1] = y;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				double dist = Math.sqrt(Math.pow((map[i][0] - map[j][0]), 2) + Math.pow((map[i][1] - map[j][1]), 2));
				adjList[i] = new Node(j, dist, adjList[i]);
				adjList[j] = new Node(i, dist, adjList[j]);
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, 0, adjList[from]);
			adjList[to] = new Node(from, 0, adjList[to]);
		}

//		init done

		double[] minEdge = new double[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[1] = 0;
		double result = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> (double) o.dist));
		pq.offer(new Vertex(1, 0));

		int cnt = 0;
		while (true) {
			Vertex cur = pq.poll();

			if (visited[cur.no])
				continue;

			visited[cur.no] = true;
			result += cur.dist;

			if (++cnt == n)
				break;

			for (Node temp = adjList[cur.no]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && minEdge[temp.to] > temp.dist) {
					minEdge[temp.to] = temp.dist;
					pq.offer(new Vertex(temp.to, temp.dist));
				}
			}
		}

		System.out.println(String.format("%.2f", Math.round(result * 100) / (double) 100));

	}

}
