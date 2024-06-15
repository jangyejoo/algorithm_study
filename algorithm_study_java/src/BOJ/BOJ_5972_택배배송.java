package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972_택배배송 {

	static class Node {
		int to, feed;
		Node next;

		public Node(int to, int feed, Node next) {
			this.to = to;
			this.feed = feed;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int feed = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, feed, adjList[from]);
			adjList[to] = new Node(from, feed, adjList[to]);
		}

//		init done

		int[] feeds = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(feeds, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

//		현서는 1에서 시작
		feeds[1] = 0;
		pq.offer(new int[] { 1, 0 });

//		다익스트라
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (visited[cur[0]])
				continue;

			if (cur[0] == n)
				break;

			visited[cur[0]] = true;

			for (Node temp = adjList[cur[0]]; temp != null; temp = temp.next) {
				if (!visited[temp.to] && feeds[temp.to] > feeds[cur[0]] + temp.feed) {
					feeds[temp.to] = feeds[cur[0]] + temp.feed;
					pq.offer(new int[] { temp.to, feeds[temp.to] });
				}
			}
		}

		System.out.println(feeds[n]);

	}

}