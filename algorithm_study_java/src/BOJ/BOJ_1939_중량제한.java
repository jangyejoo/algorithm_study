package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1939_중량제한 {

	static class Node {
		int to;
		int weight;
		Node next;

		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
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
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, c, adjList[a]);
			adjList[b] = new Node(a, c, adjList[b]);
		}

		st = new StringTokenizer(br.readLine().trim());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

//		init done

//		from에서 to까지 갈 때 운송할 수 있는 최대 무게
		int[] weight = new int[n + 1];
		Arrays.fill(weight, -1);
		weight[from] = 0;

//		bfs
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}

		});
		q.offer(new int[] { from, Integer.MAX_VALUE });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int node = cur[0];
			int minValue = cur[1];

//			목적지를 만나면 바로 끝
			if (node == to)
				break;

			for (Node temp = adjList[node]; temp != null; temp = temp.next) {
				if (weight[temp.to] < Math.min(minValue, temp.weight)) {
					weight[temp.to] = Math.min(minValue, temp.weight);
					q.offer(new int[] { temp.to, weight[temp.to] });
				}
			}

		}

		System.out.println(weight[to]);

	}

}
