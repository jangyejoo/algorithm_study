package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {

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
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] times = new int[n + 1];
		int[] inDegree = new int[n + 1];

		Node[] adjList = new Node[n + 1];
		Queue<Integer> q = new LinkedList<>();
		// i번 작업을 끝냈을 때 시간
		int[] dp = new int[n + 1];

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int time = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			times[i] = time;
			for (int j = 0; j < cnt; j++) {
				int node = Integer.parseInt(st.nextToken());
				adjList[node] = new Node(i, adjList[node]);
				inDegree[i]++;
			}

			if (inDegree[i] == 0) {
				dp[i] = times[i];
				q.offer(i);
				ans = Math.max(ans, dp[i]);
			}
		}

		// init done

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				dp[temp.to] = Math.max(dp[temp.to], dp[cur] + times[temp.to]);
				if (--inDegree[temp.to] == 0) {
					q.offer(temp.to);
					ans = Math.max(ans, dp[temp.to]);
				}
			}
		}

		System.out.println(ans);

	}

}
