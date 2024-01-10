package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14267_회사문화1 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static Node[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjList = new Node[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			int from = Integer.parseInt(st.nextToken());

			if (from == -1)
				continue;

			adjList[from] = new Node(i, adjList[from]);
		}

		int[] ans = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int node = Integer.parseInt(st.nextToken());
			int amount = Integer.parseInt(st.nextToken());

			ans[node] += amount;
		}

//		init done

		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			play(i, visited, ans);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(ans[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void play(int node, boolean[] visited, int[] ans) {
		for (Node temp = adjList[node]; temp != null; temp = temp.next) {
			if (visited[temp.to])
				continue;

			visited[temp.to] = true;
			ans[temp.to] += ans[node];
			play(temp.to, visited, ans);
		}
	}

}
