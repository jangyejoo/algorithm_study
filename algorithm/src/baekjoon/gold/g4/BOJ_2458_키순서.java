package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2458_키순서 {

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

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, adjList[a]);
		}

		// init done

		int[][] nodeInfo = new int[n + 1][2]; // 나보다 큰 친구 개수, 나보다 작은 친구 개수
		for (int i = 1; i <= n; i++) {
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);

			int cnt = 1;
			boolean[] visit = new boolean[n + 1];
			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					if (visit[temp.to])
						continue;
					cnt++;
					visit[temp.to] = true;
					nodeInfo[temp.to][1]++;
					q.offer(temp.to);
				}
			}

			nodeInfo[i][0] = cnt;
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (nodeInfo[i][0] + nodeInfo[i][1] == n)
				ans++;
		}
		System.out.println(ans);

	}

}
