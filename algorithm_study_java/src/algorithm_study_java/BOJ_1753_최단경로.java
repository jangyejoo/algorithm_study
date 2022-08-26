package algorithm_study_java;

import java.io.*;
import java.util.*;

import algorithm_study_java.BOJ_1197_최소스패닝트리.Vertex;

public class BOJ_1753_최단경로 {

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

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int V = Integer.parseInt(br.readLine());
//
//		int[][] adjMatrix = new int[V][V];
//		for (int i = 0; i < V; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			for (int j = 0; j < V; j++) {
//				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		// start -> end로의 최단 경로
//		int start = 0; // 출발 정점
//		int end = V - 1; // 도착 정점
//		// 다익스트라 알고리즘에 필요한 자료구조
//		int[] D = new int[V]; // 출발지에서 자신으로 오는데 소요되는 최소 비용
//		boolean[] visited = new boolean[V]; // 처리한 정점 여부
//
//		Arrays.fill(D, Integer.MAX_VALUE);
//		// 출발 정점 처리
//		D[start] = 0;
//
//		int min, minVertex;
//
//		for (int i = 0; i < V; i++) {
//
//			// step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
//			min = Integer.MAX_VALUE;
//			minVertex = -1;
//			for (int j = 0; j < V; j++) {
//				if (!visited[j] && min > D[j]) {
//					min = D[j];
//					minVertex = j;
//				}
//			}
//
//			// step2. 방문처리
//			visited[minVertex] = true;
//			if (minVertex == end) break;
//
//			// step3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
//			for (int j = 0; j < V; j++) {
//				if (!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
//					D[j] = D[minVertex] + adjMatrix[minVertex][j];
//				}
//			}
//
//		}
//
//		System.out.println(Arrays.toString(D));
//		System.out.println(D[end]);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Node[] list = new Node[V + 1];

		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

//			방향 그래프
			list[from] = new Node(to, weight, list[from]);

		}

		boolean[] visited = new boolean[V + 1];
		int[] D = new int[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;

//		그냥 다익스트라
//		int min, minVertex;

//		for (int i = 1; i <= V; i++) {
//
//			// step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
//			min = Integer.MAX_VALUE;
//			minVertex = -1;
//			for (int k = 1; k <= V; k++) {
//				if (!visited[k] && min > D[k]) {
//					min = D[k];
//					minVertex = k;
//				}
//			}
//
//			// step2. 방문처리
//			if (minVertex == -1) {
//				continue;
//			}
//			visited[minVertex] = true;
//
//			// step3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
//			for (Node temp = list[minVertex]; temp != null; temp = temp.next) {
//				if (!visited[temp.vertex] && D[temp.vertex] > D[minVertex] + temp.weight) {
//					D[temp.vertex] = D[minVertex] + temp.weight;
//				}
//			}
//
//		}

//		PQ 이용 버전
		PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.weight - o2.weight;
			}
		});
		pq.offer(new Vertex(start, D[start]));

		while (true) {
			Vertex minVertex = pq.poll();

			if (minVertex == null)
				break;
			if (visited[minVertex.no])
				continue;

			visited[minVertex.no] = true;

			for (Node temp = list[minVertex.no]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && D[temp.vertex] > D[minVertex.no] + temp.weight) {
					D[temp.vertex] = D[minVertex.no] + temp.weight;
					pq.offer(new Vertex(temp.vertex, D[temp.vertex]));
				}
			}

		}

		for (int i = 1; i <= V; i++) {
			if (visited[i])
				sb.append(D[i]).append("\n");
			else
				sb.append("INF\n");
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();

	}

}
