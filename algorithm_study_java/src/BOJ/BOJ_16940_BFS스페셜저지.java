package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16940_BFS스페셜저지 {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static int n;
	static int[] depth, parent;
	static Node[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		adjList = new Node[n + 1];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

		int[] input = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

//		init done

		depth = new int[n + 1];
		parent = new int[n + 1];
		Arrays.fill(depth, -1);

		depth[1] = 1;

		dfs(1);

//		root인 1번 노드 처리
		int[] idxInfo = new int[n + 1];
		idxInfo[1] = 1;

		for (int i = 1; i < n; i++) {
			int preLevel = depth[input[i - 1]];
			int curLevel = depth[input[i]];

			if (preLevel < curLevel) {
//				다음 레벨로 넘어 갔을 때
				idxInfo[input[i]] = 1;
			} else if (preLevel == curLevel) {
//				같은 레벨일 때
				idxInfo[input[i]] = idxInfo[input[i - 1]] + 1;

				int preParentIdx = idxInfo[parent[input[i - 1]]];
				int curParentIdx = idxInfo[parent[input[i]]];

//				이전 노드의 부모의 순서가 더 나중이면
//				잘못된 탐색
				if (preParentIdx > curParentIdx) {
					System.out.println(0);
					return;
				}
			} else {
//				레벨이 더 작아졌으면
//				잘못된 탐색
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);

	}

	private static void dfs(int num) {
		int nxtDepth = depth[num] + 1;

		for (Node temp = adjList[num]; temp != null; temp = temp.next) {
			if (depth[temp.to] != -1)
				continue;

			depth[temp.to] = nxtDepth;
			parent[temp.to] = num;

			dfs(temp.to);
		}
	}

}
