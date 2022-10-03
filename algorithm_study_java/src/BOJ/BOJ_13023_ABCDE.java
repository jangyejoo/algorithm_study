package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

	}

	static boolean possible = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String nm = br.readLine();
		StringTokenizer st = new StringTokenizer(nm);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] list = new Node[n];

		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from] = new Node(to, list[from]);
			list[to] = new Node(from, list[to]);
		}

		for (int i = 0; i < n; i++) {
			if (list[i] != null) {
				boolean[] visited = new boolean[n];

				dfs(list, visited, i, 1);

				if (possible) {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(0);
	}

	private static void dfs(Node[] list, boolean[] visited, int cur, int depth) {
		visited[cur] = true;
		for (Node temp = list[cur]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) {
				int nxtDepth = depth + 1;
				if (nxtDepth == 5) {
					possible = true;
					return;
				}
				dfs(list, visited, temp.to, nxtDepth);
			}
		}
		visited[cur] = false;
	}

}
