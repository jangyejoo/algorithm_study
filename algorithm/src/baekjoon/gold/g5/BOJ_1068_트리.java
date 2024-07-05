package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1068_트리 {

	static class Node {
		int child;
		Node next;

		public Node(int child, Node next) {
			this.child = child;
			this.next = next;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Node[] adjList = new Node[n];
		int[] out = new int[n];
		int[] parents = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			parents[i] = num;
			if (num != -1) {
				adjList[num] = new Node(i, adjList[num]);
				out[num]++;
			}
		}

		int delete = Integer.parseInt(br.readLine());

		// init done

		if (parents[delete] == -1) {
			System.out.println(0);
			return;
		}

		boolean[] visit = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.offer(delete);
		while (!q.isEmpty()) {
			int cur = q.poll();
			out[parents[cur]]--;
			if (visit[cur])
				continue;
			visit[cur] = true;
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				q.offer(temp.child);
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (out[i] == 0 && !visit[i])
				cnt++;
		}
		System.out.println(cnt);

	}

}
