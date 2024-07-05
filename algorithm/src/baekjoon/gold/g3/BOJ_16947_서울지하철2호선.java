package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16947_서울지하철2호선 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static int n;
	static boolean[] cycle, visited;
	static Node[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		adjList = new Node[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, adjList[a]);
			adjList[b] = new Node(a, adjList[b]);
		}

//		init done

		cycle = new boolean[n + 1];
		visited = new boolean[n + 1];

//		순환선 확인
		check(1, -1);

		for (int i = 1; i <= n; i++) {
			sb.append(dist(i)).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int dist(int num) {
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		q.offer(num);
		dist[num] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cycle[cur])
				return dist[cur];

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (dist[temp.to] != Integer.MAX_VALUE)
					continue;

				q.offer(temp.to);
				dist[temp.to] = dist[cur] + 1;
			}
		}
		return -1;
	}

	private static int check(int num, int prev) {
		visited[num] = true;

		int start = 0;

		for (Node temp = adjList[num]; temp != null; temp = temp.next) {
//			이전 역이 아닌데 방문했었으면 순환
			if (visited[temp.to] && temp.to != prev && !cycle[temp.to]) {
				start = temp.to;
			}

			if (!visited[temp.to]) {
				start += check(temp.to, num);
			}
		}

		if (start > 0) {
			cycle[num] = true;

			if (start == num) {
				return 0;
			} else {
				return start;
			}
		}

		return 0;
	}

}
