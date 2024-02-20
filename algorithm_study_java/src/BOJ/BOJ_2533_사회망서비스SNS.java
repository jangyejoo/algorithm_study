package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2533_사회망서비스SNS {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static int n;
	static int[][] dp;
	static Node[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		adjList = new Node[n + 1];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, adjList[a]);
			adjList[b] = new Node(a, adjList[b]);
		}

//		init done

		dp = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
		}

//		임의의 점(== 1)에서 시작...
//		dfs 하면서 dp 갱신하기

		visited = new boolean[n + 1];
		System.out.println(dfs(1));

	}

	private static int dfs(int node) {
//		이 노드가 얼리 어답터가 아니면
//		노드와 연결된 근접 노드들은 반드시 얼리 어답터여야 됨

//		이 노드가 얼리 어답터이면
//		노드와 연결된 근접 노드들은 얼리 어답터가 아니어도 됨

//		방문 표시
		visited[node] = true;

		int min = 1;
		int earlyAdaptor = 0;
		for (Node temp = adjList[node]; temp != null; temp = temp.next) {
			if (visited[temp.to])
				continue;

			min += dfs(temp.to);
			earlyAdaptor += dp[temp.to][1];
		}

		dp[node][1] = min;
		dp[node][0] = earlyAdaptor;

		return Math.min(dp[node][0], dp[node][1]);
	}

}
