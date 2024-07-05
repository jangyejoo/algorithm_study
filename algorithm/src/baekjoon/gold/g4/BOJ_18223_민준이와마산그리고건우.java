package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18223_민준이와마산그리고건우 {

	static class Node {
		int to, dist;
		Node next;

		Node(int to, int dist, Node next) {
			this.to = to;
			this.dist = dist;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[v + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, dist, adjList[from]);
			adjList[to] = new Node(from, dist, adjList[to]);
		}

//		init done

//		1에서 N까지
//		1에서 P까지
		int[] dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		boolean[] visited = new boolean[v + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		dist[1] = 0;
		pq.offer(new int[] { 1, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (visited[cur[0]])
				continue;

			visited[cur[0]] = true;

			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && dist[temp.to] > dist[cur[0]] + temp.dist) {
					dist[temp.to] = dist[cur[0]] + temp.dist;
					pq.offer(new int[] { temp.to, dist[temp.to] });
				}
			}
		}

		int one_v = dist[v];
		int one_p = dist[p];

//		P에서 N까지
		dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(visited, false);

		pq.clear();

		dist[p] = 0;
		pq.offer(new int[] { p, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (visited[cur[0]])
				continue;

			visited[cur[0]] = true;

			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && dist[temp.to] > dist[cur[0]] + temp.dist) {
					dist[temp.to] = dist[cur[0]] + temp.dist;
					pq.offer(new int[] { temp.to, dist[temp.to] });
				}
			}
		}

		int p_v = dist[v];

		if (one_v == (one_p + p_v)) {
			System.out.println("SAVE HIM");
			return;
		}

		System.out.println("GOOD BYE");

	}

}
