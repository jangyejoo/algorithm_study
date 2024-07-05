package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10159_저울 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] info = new int[2][n + 1]; // 나로 들어오는 친구, 나에서 부터 검색 가능한 친구
		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, adjList[a]);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int start = 1; start <= n; start++) {
			boolean[] visit = new boolean[n + 1];
			q.offer(start);
			visit[start] = true;

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					if (visit[temp.to])
						continue;
					info[0][temp.to]++;
					info[1][start]++;
					q.offer(temp.to);
					visit[temp.to] = true;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(n - info[0][i] - info[1][i] - 1).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
