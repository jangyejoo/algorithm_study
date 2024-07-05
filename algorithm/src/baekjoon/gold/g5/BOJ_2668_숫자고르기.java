package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2668_숫자고르기 {

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

		int n = Integer.parseInt(br.readLine());
		Node[] adjList = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());
			adjList[i] = new Node(num, adjList[i]);
		}

		// init done
		int[] info = new int[n + 1];
		C: for (int i = 1; i <= n; i++) {
			if (info[i] != 0)
				continue;

			Queue<Integer> q = new LinkedList<>();
			q.offer(i);

			// 방문 표시
			info[i] = 1;

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
					if (info[temp.to] == 0) {
						info[temp.to] = 1;
						q.offer(temp.to);
					} else if (info[temp.to] == 1) {
						if (temp.to == i) {
							// 시작 지점으로 다시 돌아온 사이클 완성
							for (int j = 1; j <= n; j++) {
								if (info[j] == 1)
									info[j] = 2;
							}
							continue C;
						}
					} else {
						// 이미 완성된 사이클을 만나거나 가능성 없는 노드를 만남
						for (int j = 1; j <= n; j++) {
							if (info[j] == 1)
								info[j] = -1;
						}
					}
				}
			}

			// 사이클을 완성 못한 경우 다시 방문 표시 초기화
			for (int j = 1; j <= n; j++) {
				if (info[j] == 1)
					info[j] = 0;
			}

			// 해당 노드로 시작하는 사이클은 불가능
			info[i] = -1;

		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (info[i] == 2) {
				cnt++;
				sb.append(i).append("\n");
			}
		}

		bw.write(cnt + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
