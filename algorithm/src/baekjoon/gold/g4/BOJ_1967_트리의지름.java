package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {

	static class Node {
		int to, weight;
		Node next;

		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}

	static Node[] adjList;
	static int[] dist;
	static int[] out;
	static int n, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine().trim());
		adjList = new Node[n + 1];
		out = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			out[from]++;
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		// init done

		dist = new int[n + 1];
		ans = 0;

		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0, visited);
		for (int i = 2; i <= n; i++) {
			Arrays.fill(visited, false);
			if (out[i] == 0) {
				visited[i] = true;
				dfs(i, 0, visited);
			}
		}

		System.out.println(ans);

	}

	private static void dfs(int num, int hap, boolean[] visited) {
		if (out[num] == 0 && hap > 0) {
			dist[num] = Math.max(dist[num], hap);
			ans = Math.max(ans, dist[num]);
			return;
		}

		for (Node temp = adjList[num]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) {
				visited[temp.to] = true;
				dfs(temp.to, hap + temp.weight, visited);
			}
		}

	}
}
