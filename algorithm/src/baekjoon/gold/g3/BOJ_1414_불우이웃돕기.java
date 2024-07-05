package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1414_불우이웃돕기 {

	static class Node {
		int to, length;
		Node next;

		public Node(int to, int length, Node next) {
			this.to = to;
			this.length = length;
			this.next = next;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int total = 0;
		Node[] adjList = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
//			아스키 코드 a == 97, A == 65
			for (int j = 1; j <= n; j++) {
				int code = (int) input.charAt(j - 1);

//				대문자
				int length = code - 38;

//				소문자이면 수정
				if (code >= 97)
					length = code - 96;

//				길이가 0이면 연결 x
				if (code == 48)
					continue;

//				가지고 있는 랜선 전체 길이
				total += length;

				adjList[i] = new Node(j, length, adjList[i]);
				adjList[j] = new Node(i, length, adjList[j]);
			}
		}

//		init done

		int[] minEdge = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

//		임의의 컴퓨터 1에서 시작
		minEdge[1] = 0;
		pq.offer(new int[] { 1, 0 });

		int cnt = 0;
		int mst = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (visited[cur[0]])
				continue;

			visited[cur[0]] = true;
			mst += cur[1];
			if (++cnt == n)
				break;

			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && minEdge[temp.to] > temp.length) {
					minEdge[temp.to] = temp.length;
					pq.offer(new int[] { temp.to, temp.length });
				}
			}
		}

		if (cnt != n) {
//			모든 컴퓨터를 연결할 수 없음
			System.out.println(-1);
			return;
		}

		System.out.println(total - mst);

	}

}
