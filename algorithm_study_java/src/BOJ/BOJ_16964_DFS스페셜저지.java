package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public abstract class BOJ_16964_DFS스페셜저지 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static int[] parent, childCnt;
	static Node[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		adjList = new Node[n + 1];

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a] = new Node(b, adjList[a]);
			adjList[b] = new Node(a, adjList[b]);
		}

		int[] input = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

//		init done

		parent = new int[n + 1];
		childCnt = new int[n + 1];
		Arrays.fill(parent, -1);

		parent[1] = 0;
		dfs(1);

		int p = 1;
		for (int i = 1; i < n; i++) {
			int c = input[i];

			if (parent[c] == p) {
//				바로 연결된 간선

//				검색된 child 줄이기
				childCnt[p]--;

				if (childCnt[c] > 0) {
//					자식이 있으면 level 한번 더 들어감
					p = c;
				} else {
//					자식이 없으면
//					childCnt가 남아있는 가장 가까운 부모 찾기
					while (true) {
						if (p == 1 || childCnt[p] > 0)
							break;

						p = parent[p];
					}
				}
			} else {
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);

	}

	private static void dfs(int num) {
		for (Node temp = adjList[num]; temp != null; temp = temp.next) {
			if (parent[temp.to] != -1)
				continue;

			parent[temp.to] = num;
			childCnt[num]++;

			dfs(temp.to);
		}
	}

}
