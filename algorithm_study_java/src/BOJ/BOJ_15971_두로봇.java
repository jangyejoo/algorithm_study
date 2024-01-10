package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15971_두로봇 {

	static class Node {
		int to;
		int dist;
		Node next;

		public Node(int to, int dist, Node next) {
			this.to = to;
			this.dist = dist;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int robot1 = Integer.parseInt(st.nextToken());
		int robot2 = Integer.parseInt(st.nextToken());

		if (n == 1 || robot1 == robot2) {
			System.out.println(0);
			return;
		}

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, dist, adjList[a]);
			adjList[b] = new Node(a, dist, adjList[b]);
		}

		// init done

		int[] dist1 = new int[n + 1];
		Arrays.fill(dist1, -1);

		Queue<Integer> q = new LinkedList<>();
		q.offer(robot1);
		dist1[robot1] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (dist1[temp.to] != -1)
					continue;

				dist1[temp.to] = dist1[cur] + temp.dist;
				q.offer(temp.to);
			}
		}

		// robot1 dist 완성!

		int ans = Integer.MAX_VALUE;

		int[] dist2 = new int[n + 1];
		Arrays.fill(dist2, -1);

		q.offer(robot2);
		dist2[robot2] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (dist2[temp.to] != -1)
					continue;

				if (dist1[temp.to] != -1) {
					ans = Math.min(ans, dist2[cur] + dist1[temp.to]);
				}

				dist2[temp.to] = dist2[cur] + temp.dist;
				q.offer(temp.to);
			}
		}

		System.out.println(ans);

	}

}
