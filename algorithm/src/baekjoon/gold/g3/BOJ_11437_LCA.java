package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11437_LCA {

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

		int n = Integer.parseInt(br.readLine());

		Node[] adjList = new Node[n + 1];

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

//		루트는 1
//		1에서부터 parents 완성해나가기

		int[] parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		List<Integer>[] parentsList = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			parentsList[i] = new ArrayList<>();
			parentsList[i].add(i);
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (parents[temp.to] != temp.to)
					continue;

				parents[temp.to] = cur;
				q.offer(temp.to);
			}
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

//			부모 리스트를 아직 저장하지 않았으면 탐색!
			if (parentsList[a].size() == 1) {
				int cur = a;
				while (true) {
					if (cur == 1)
						break;

					cur = parents[cur];
					parentsList[a].add(cur);
				}
			}

//			부모 리스트를 아직 저장하지 않았으면 탐색!
			if (parentsList[b].size() == 1) {
				int cur = b;
				while (true) {
					if (cur == 1)
						break;

					cur = parents[cur];
					parentsList[b].add(cur);
				}
			}

//			부모 리스트들이 준비됐으면 LCA 찾기
//			동일한 깊이로 조정
			int sizeA = parentsList[a].size();
			int sizeB = parentsList[b].size();

			int idxA = 0;
			int idxB = 0;
			if (sizeA > sizeB) {
				idxA = Math.abs(sizeA - sizeB);
			} else {
				idxB = Math.abs(sizeA - sizeB);
			}

//			한 칸씩 올라가면서 공통 조상 찾기
			int nodeA = parentsList[a].get(idxA);
			int nodeB = parentsList[b].get(idxB);
			while (true) {
				if (nodeA == nodeB) {
					sb.append(nodeA).append("\n");
					break;
				}

				nodeA = parentsList[a].get(++idxA);
				nodeB = parentsList[b].get(++idxB);
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
