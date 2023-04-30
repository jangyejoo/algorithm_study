package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		Node[] adjList = new Node[n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

//			init done

		int cnt = 0;

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (!visited[temp.to]) {
					cnt++;
					visited[temp.to] = true;
					q.offer(temp.to);
				}
			}
		}

		System.out.println(cnt);

	}
}
