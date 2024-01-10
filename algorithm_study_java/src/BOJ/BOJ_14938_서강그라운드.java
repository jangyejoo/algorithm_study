package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {

	static class Node {
		int to;
		int weight;
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
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] node = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, weight, adjList[a]);
			adjList[b] = new Node(a, weight, adjList[b]);
		}

		// init done

		int ans = 0;
		int[] dist = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[j] = Integer.MAX_VALUE;
			}

			dist[i] = 0;

			Queue<Integer> q = new LinkedList<>();
			q.offer(i);

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					int nextDist = dist[cur] + temp.weight;

					if (nextDist > m)
						continue;

					if (nextDist < dist[temp.to]) {
						dist[temp.to] = nextDist;
						q.offer(temp.to);
					}
				}
			}

			int hap = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[j] > m)
					continue;
				hap += node[j];
			}
			ans = Math.max(ans, hap);
		}
		System.out.println(ans);
	}

}
