package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516_게임개발 {

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

		int[] time = new int[n + 1];
		int[] inDegree = new int[n + 1];
		Node[] adjList = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int num = Integer.parseInt(st.nextToken());
			time[i] = num;

			while (true) {
				num = Integer.parseInt(st.nextToken());

				if (num == -1)
					break;

				inDegree[i]++;
				adjList[num] = new Node(i, adjList[num]);
			}
		}

//		init done

		Queue<Integer> q = new LinkedList<>();
		List<Integer> list = new LinkedList<>();

		int[] ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				ans[i] += time[i];
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			list.add(cur);

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				ans[temp.to] = Math.max(ans[temp.to], ans[cur]);
				if (--inDegree[temp.to] == 0) {
					ans[temp.to] += time[temp.to];
					q.offer(temp.to);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(ans[i]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
