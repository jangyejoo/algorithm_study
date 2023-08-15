package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {

	static class Node {
		int to, weight;
		Node next;

		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, c, adjList[a]);
			adjList[b] = new Node(a, c, adjList[b]);
		}

		st = new StringTokenizer(br.readLine().trim());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// init done

		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] { 1, 0 });
		dist[1] = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (dist[cur[0]] < cur[1]) {
				continue;
			}
			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (dist[temp.to] > cur[1] + temp.weight) {
					dist[temp.to] = cur[1] + temp.weight;
					pq.offer(new int[] { temp.to, dist[temp.to] });
				}
			}
		}

		int fromOneToV1 = dist[v1];
		int fromOneToV2 = dist[v2];

		if (v1 == 1 && v2 == n) {
			System.out.println(dist[n] == Integer.MAX_VALUE ? -1 : dist[n]);
			return;
		}

		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new int[] { v1, 0 });
		dist[v1] = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (dist[cur[0]] < cur[1]) {
				continue;
			}
			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (dist[temp.to] > cur[1] + temp.weight) {
					dist[temp.to] = cur[1] + temp.weight;
					pq.offer(new int[] { temp.to, dist[temp.to] });
				}
			}
		}

		int fromV1ToV2 = dist[v2];
		int fromV1ToN = dist[n];

		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new int[] { v2, 0 });
		dist[v2] = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (dist[cur[0]] < cur[1]) {
				continue;
			}
			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (dist[temp.to] > cur[1] + temp.weight) {
					dist[temp.to] = cur[1] + temp.weight;
					pq.offer(new int[] { temp.to, dist[temp.to] });
				}
			}
		}

		int fromV2ToN = dist[n];

		boolean isPossibleV1ToV2 = true;
		boolean isPossibleV2ToV1 = true;

		if (fromV1ToV2 == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		if (fromOneToV1 == Integer.MAX_VALUE || fromV2ToN == Integer.MAX_VALUE) {
			isPossibleV1ToV2 = false;
		}

		if (fromOneToV2 == Integer.MAX_VALUE || fromV1ToN == Integer.MAX_VALUE) {
			isPossibleV2ToV1 = false;
		}

		int ans = Integer.MAX_VALUE;
		if (isPossibleV1ToV2 && isPossibleV2ToV1) {
			ans = Math.min(fromOneToV1 + fromV1ToV2 + fromV2ToN, fromOneToV2 + fromV1ToV2 + fromV1ToN);
		} else if (isPossibleV1ToV2 && !isPossibleV2ToV1) {
			ans = fromOneToV1 + fromV1ToV2 + fromV2ToN;
		} else if (!isPossibleV1ToV2 && isPossibleV2ToV1) {
			ans = fromOneToV2 + fromV1ToV2 + fromV1ToN;
		} else {
			ans = -1;
		}

		System.out.println(ans);
	}

}
