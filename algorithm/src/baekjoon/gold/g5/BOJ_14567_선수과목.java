package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14567_선수과목 {

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[n + 1];
		int[] inDegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}

		// init done

		Queue<Integer> q = new LinkedList<>();
		int depth[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				depth[temp.vertex] = depth[cur] + 1;
				if (--inDegree[temp.vertex] == 0) {
					q.offer(temp.vertex);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(depth[i] + 1).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
