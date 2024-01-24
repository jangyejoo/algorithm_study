package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1613_역사 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] inDegree = new int[n + 1];
		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			inDegree[to]++;
			adjList[from] = new Node(to, adjList[from]);
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[][] connected = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
//				부모 체크
				connected[temp.to][cur] = true;

//				부모의 부모들도 체크
				for (int i = 1; i <= n; i++) {
					if (connected[cur][i]) {
						connected[temp.to][i] = true;
					}
				}

				if (--inDegree[temp.to] == 0) {
					q.offer(temp.to);
				}
			}
		}

		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (connected[a][b]) {
				sb.append(1).append("\n");
			} else if (connected[b][a]) {
				sb.append(-1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
