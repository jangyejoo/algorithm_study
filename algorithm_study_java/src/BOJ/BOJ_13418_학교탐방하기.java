package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13418_학교탐방하기 {

	static class Node {
		int to, best, worst;
		Node next;

		public Node(int to, int best, int worst, Node next) {
			this.to = to;
			this.best = best;
			this.worst = worst;
			this.next = next;
		}
	}

	static Node[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjList = new Node[n + 1];

		for (int i = 0; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

//			cost 보정
//			최적경로 : 내리막길 0, 오르막길 1
//			최악경로 : 내리막길 1, 오르막길 0
			int c1 = st.nextToken().equals("1") ? 0 : 1;
			int c2 = c1 == 0 ? 1 : 0;

			adjList[a] = new Node(b, c1, c2, adjList[a]);
			adjList[b] = new Node(a, c1, c2, adjList[b]);
		}

//		init done

		System.out.println(Math.abs(findRoute(n, 1) - findRoute(n, 0)));

	}

	private static int findRoute(int n, int uphill) {
		int[] minEdge = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		Arrays.fill(minEdge, Integer.MAX_VALUE);

//		아무것도 의미하지 않는 숫자 2
		minEdge[0] = 2;
		pq.offer(new int[] { 0, 2 });

		int k = 0;
		int cnt = 0;

		while (true) {
			int[] cur = pq.poll();

			if (visited[cur[0]])
				continue;

			visited[cur[0]] = true;

//			오르막길 개수
			if (cur[1] == uphill)
				k++;

			if (++cnt == n + 1)
				break;

			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				int flag = compare(temp, uphill);
				if (!visited[temp.to] && minEdge[temp.to] > flag) {
					minEdge[temp.to] = flag;
					pq.offer(new int[] { temp.to, flag });
				}
			}
		}
		return k * k;
	}

	private static int compare(Node temp, int option) {
//		최적 경로 구할 때 오르막길이 1
		if (option == 1)
			return temp.best;

//		최악 경로 구할 때 오르막길이 0
		return temp.worst;
	}

}
