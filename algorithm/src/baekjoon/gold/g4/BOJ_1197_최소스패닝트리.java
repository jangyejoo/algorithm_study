package baekjoon.gold.g4;

import java.io.*;
import java.util.*;

public class BOJ_1197_최소스패닝트리 {

//	Edge For KRUSKAL
//	static class Edge implements Comparable<Edge> {
//		int from, to, weight;
//
//		public Edge(int from, int to, int weight) {
//			super();
//			this.from = from;
//			this.to = to;
//			this.weight = weight;
//		}
//
//		@Override
//		public int compareTo(Edge o) {
//			return this.weight - o.weight;
//		}
//
//	}

//	Node For PRIM
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

	static class Vertex {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

//		EdgeList For KRUSKAL
//		int[] parents = new int[V + 1];
//		Edge[] edgeList = new Edge[E];
//
//		for (int i = 1; i <= V; i++) {
//			parents[i] = i;
//		}
//
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
//					Integer.parseInt(st.nextToken()));
//		}
//
//		Arrays.sort(edgeList);
//
//		int result = 0;
//		int cnt = 0;
//		for (Edge edge : edgeList) {
//			if (union(parents, edge.from, edge.to)) {
//				result += edge.weight;
//				if (++cnt == V - 1)
//					break;
//			}
//		}
//
//		System.out.println(result);

//		Node adjList For PRIM
//		int[] minEdge = new int[V + 1]; // 해당 정점까지 가는 데에 최소 가중치
//		boolean[] visited = new boolean[V + 1];
//		Node[] adjList = new Node[V + 1];
//
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
//			int weight = Integer.parseInt(st.nextToken());
//			adjList[from] = new Node(to, weight, adjList[from]);
//			adjList[to] = new Node(from, weight, adjList[to]);
//		}
//
//		Arrays.fill(minEdge, Integer.MAX_VALUE);
//
//		minEdge[1] = 0;
//		int result = 0;
//
//		for (int i = 0; i < V; i++) {
//			int min = Integer.MAX_VALUE;
//			int minVertex = -1;
//			for (int j = 1; j <= V; j++) {
//				if (!visited[j] && min > minEdge[j]) {
//					min = minEdge[j];
//					minVertex = j;
//				}
//			}
//
//			visited[minVertex] = true;
//			result += min;
//
//			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
//				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
//					minEdge[temp.vertex] = temp.weight;
//				}
//			}
//		}
//
//		System.out.println(result);

//		Node adjList For PRIM + PQ
		int[] minEdge = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Node[] adjList = new Node[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[1] = 0;
		int result = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.weight - o2.weight;
			}

		});
		pq.offer(new Vertex(1, minEdge[1]));

		int cnt = 0;
		
		while (true) {
			Vertex minVertex = pq.poll();

			if (visited[minVertex.no])
				continue;

			visited[minVertex.no] = true;
			result += minVertex.weight;
			if (++cnt == V)
				break;

			for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pq.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
				}
			}
		}
		
		System.out.println(result);

	}

//	Method For KRUSKAL
//	static int find(int[] parents, int a) {
//		if (parents[a] == a)
//			return a;
//		return parents[a] = find(parents, parents[a]);
//	}
//
//	static boolean union(int[] parents, int a, int b) {
//		int aRoot = find(parents, a);
//		int bRoot = find(parents, b);
//		if (aRoot != bRoot) {
//			parents[bRoot] = aRoot;
//			return true;
//		}
//		return false;
//	}
}
