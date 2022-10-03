package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

	}

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

//			주민은 1-index
			Node[] list = new Node[n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from] = new Node(to, list[from]);
				list[to] = new Node(from, list[to]);
			}

			boolean visited[] = new boolean[n + 1];
			ans = 0;
			for (int i = 1; i <= n; i++) {
				if (visited[i])
					continue;
				if (check(list, visited, i))
					ans++;
			}
			sb.append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean check(Node[] list, boolean[] visited, int cur) {
		visited[cur] = true;
		for (Node temp = list[cur]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) {
				check(list, visited, temp.to);
			}
		}
		return true;
	}
}