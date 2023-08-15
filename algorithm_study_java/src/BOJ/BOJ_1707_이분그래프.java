package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {

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
		C: for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			Node[] adjList = new Node[n + 1];
			int startNode = 0;
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList[from] = new Node(to, adjList[from]);
				adjList[to] = new Node(from, adjList[to]);
			}

			// init done

			Queue<Integer> q = new LinkedList<>();
			int[] section = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				q.offer(i);
				while (!q.isEmpty()) {
					int cur = q.poll();
					int curSection = section[cur];
					int nextSection;
					if (curSection == 0) {
						section[cur] = 1;
						nextSection = -1;
					} else {
						nextSection = -1 * section[cur];
					}
					for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
						if (section[temp.to] == 0) {
							section[temp.to] = nextSection;
							q.offer(temp.to);
						} else if (section[temp.to] == curSection) {
							sb.append("NO\n");
							continue C;
						}
					}
				}
			}

			sb.append("YES\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
