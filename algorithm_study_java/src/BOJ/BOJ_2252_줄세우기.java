package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

	}

	static Node[] adjList;
	static int[] inDegree;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjList = new Node[n + 1];
		inDegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}

		ArrayList<Integer> result = topologySort();
		for (Integer integer : result) {
			sb.append(integer);
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (--inDegree[temp.vertex] == 0)
					queue.offer(temp.vertex);
			}
		}
		return list;
	}
}
