package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11779_최소비용구하기2 {

	static class Node {
		int to, fee;
		Node next;

		public Node(int to, int fee, Node next) {
			this.to = to;
			this.fee = fee;
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

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, fee, adjList[from]);
		}

		st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

//		init done

		int[][] fees = new int[n + 1][2]; // 비용, 이전 도시
		for (int i = 1; i <= n; i++) {
			fees[i][0] = Integer.MAX_VALUE;
		}
		fees[start][0] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});
		pq.offer(new int[] { start, 0 });

//		다익스트라
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			int node = cur[0];
			int fee = cur[1];

			for (Node temp = adjList[node]; temp != null; temp = temp.next) {
				if (fees[temp.to][0] > temp.fee + fee) {
//					최소 비용 갱신
					fees[temp.to][0] = temp.fee + fee;
					fees[temp.to][1] = node;
					pq.offer(new int[] { temp.to, fees[temp.to][0] });
				}
			}
		}

		int cnt = 0;
		Stack<Integer> route = new Stack();

		int cur = end;
		while (true) {
			cnt++;
			route.add(cur);

			if (cur == start)
				break;

			cur = fees[cur][1];
		}

		sb.append(fees[end][0]).append("\n");
		sb.append(cnt).append("\n");
		while (!route.isEmpty()) {
			sb.append(route.pop()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
