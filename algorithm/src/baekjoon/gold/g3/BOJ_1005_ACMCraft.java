package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACMCraft {

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

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());
			int[] buildTime = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				buildTime[i] = Integer.parseInt(st.nextToken());
			}

			Node[] adjList = new Node[n + 1];
			int[] inDegree = new int[n + 1];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
			}

			// init done

			Queue<Integer> q = new LinkedList<>();
			int[] finishTime = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				if (inDegree[i] == 0) {
					q.offer(i);
					finishTime[i] += buildTime[i];
				}
			}

			while (!q.isEmpty()) {
				int cur = q.poll();
				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					finishTime[temp.to] = Math.max(finishTime[temp.to], finishTime[cur] + buildTime[temp.to]);
					if (--inDegree[temp.to] == 0) {
						q.offer(temp.to);
					}
				}
			}

			int goal = Integer.parseInt(br.readLine());
			sb.append(finishTime[goal]).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
