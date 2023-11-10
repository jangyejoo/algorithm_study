package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12893_적의적 {

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
			adjList[b] = new Node(a, adjList[b]);
		}

		// init done

		Queue<Integer> q = new LinkedList<>();
		int[] section = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (section[i] != 0)
				continue;

			q.offer(i);
			section[i] = 1;

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					if (section[temp.to] == section[cur]) {
						System.out.println("0");
						return;
					}

					if (section[temp.to] == 0) {
						section[temp.to] = -1 * section[cur];
						q.offer(temp.to);
					}
				}
			}
		}

		System.out.println("1");

	}

}
