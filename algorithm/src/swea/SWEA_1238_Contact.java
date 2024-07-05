package swea;

import java.io.*;
import java.util.*;

public class SWEA_1238_Contact {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		int tc = 1;
		while (tc <= 10) {
			sb.append("#").append(tc).append(" ");
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int l = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			String fromto = br.readLine();
			st = new StringTokenizer(fromto);
			Node[] list = new Node[101];
			for (int i = 0, size = l / 2; i < size; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from] = new Node(to, list[from]);

			}
			int[] visited = new int[101];
			sb.append(bfs(list, visited, start)).append("\n");
			tc++;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int bfs(Node[] list, int[] visited, int start) {
		Queue<Integer> q = new ArrayDeque<>();

		int ans = 0;
		int maxDeep = 1;

		visited[start] = 1;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node temp = list[cur]; temp != null; temp = temp.next) {
				if (visited[temp.to] == 0) {
					visited[temp.to] = 1;
					int deep = visited[cur] + 1;
					visited[temp.to] = deep;
					maxDeep = maxDeep < deep ? deep : maxDeep;
					q.offer(temp.to);
				}
			}
		}
		for (int i = 1; i <= 100; i++) {
			if (maxDeep == visited[i]) {
				ans = ans < i ? i : ans;
			}
		}
		return ans;
	}

}
