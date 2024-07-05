package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16562_친구비 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		int[] friendsFee = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			friendsFee[i] = Integer.parseInt(st.nextToken());
		}

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[v] = new Node(w, adjList[v]);
			adjList[w] = new Node(v, adjList[w]);
		}

		// init done

		int ans = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (visited[i])
				continue;

			q.offer(i);
			int min = friendsFee[i];

			while (!q.isEmpty()) {
				int cur = q.poll();

				visited[cur] = true;

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					if (visited[temp.to])
						continue;

					visited[temp.to] = true;
					min = Math.min(min, friendsFee[temp.to]);

					q.offer(temp.to);
				}
			}

			ans += min;
		}

		System.out.println(ans <= k ? ans : "Oh no");
	}

}
