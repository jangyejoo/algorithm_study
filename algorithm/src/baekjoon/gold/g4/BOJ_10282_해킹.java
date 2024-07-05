package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10282_해킹 {

	static class Node {
		int to;
		int time;
		Node next;

		public Node(int to, int time, Node next) {
			this.to = to;
			this.time = time;
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
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			Node[] adjList = new Node[n + 1];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				adjList[b] = new Node(a, time, adjList[b]);
			}

			// init done

			Queue<Integer> q = new LinkedList<>();
			q.offer(c);

			int[] time = new int[n + 1];
			Arrays.fill(time, Integer.MAX_VALUE);
			time[c] = 0;

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					if (time[temp.to] <= time[cur] + temp.time)
						continue;
					time[temp.to] = time[cur] + temp.time;
					q.offer(temp.to);
				}
			}

			int cnt = 0;
			int max = 0;
			for (int i = 1; i <= n; i++) {
				if (time[i] == Integer.MAX_VALUE)
					continue;
				cnt++;
				max = Math.max(max, time[i]);
			}
			sb.append(cnt).append(" ").append(max).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
