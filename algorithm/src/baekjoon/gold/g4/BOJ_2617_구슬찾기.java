package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2617_구슬찾기 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static Node[] adjList1, adjList2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjList1 = new Node[n + 1];
		adjList2 = new Node[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList1[a] = new Node(b, adjList1[a]);
			adjList2[b] = new Node(a, adjList2[b]);
		}

		// init done

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int big = bfs(0, i, n);
			int small = bfs(1, i, n);

			if (big > (n - 1) / 2 || small > (n - 1) / 2)
				ans++;
		}

		System.out.println(ans);

	}

	private static int bfs(int option, int node, int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];
		q.offer(node);
		visit[node] = true;

		int cnt = 0;
		if (option == 0) {
			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList1[cur]; temp != null; temp = temp.next) {
					if (visit[temp.to])
						continue;

					cnt++;
					q.offer(temp.to);
					visit[temp.to] = true;
				}
			}
		} else {
			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList2[cur]; temp != null; temp = temp.next) {
					if (visit[temp.to])
						continue;

					cnt++;
					q.offer(temp.to);
					visit[temp.to] = true;
				}
			}
		}

		return cnt;

	}

}
