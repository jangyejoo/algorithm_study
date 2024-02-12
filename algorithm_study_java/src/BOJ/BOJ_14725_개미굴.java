package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14725_개미굴 {

	static class Node {
		int idx;
		String name;

//		자식
		List<Node> childs = new ArrayList<>();

		public Node(int idx, String name) {
			this.idx = idx;
			this.name = name;
		}
	}

	static StringBuilder sb = new StringBuilder();
	static List<Node> nodeList = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

//		최상위 굴 추가
		int idx = 0;
		nodeList.add(new Node(idx++, "root"));

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int k = Integer.parseInt(st.nextToken());

			Node prev = nodeList.get(0);
			C: for (int j = 0; j < k; j++) {
				String cur = st.nextToken();

//				이미 추가한 노드면 넘어감
				for (Node child : prev.childs) {
					if (cur.equals(child.name)) {
						prev = child;
						continue C;
					}
				}

//				이전에 추가된 적 없는 노드
				Node newNode = new Node(idx, cur);

//				노드리스트에 추가
				nodeList.add(newNode);

//				부모의 자식 리스트에 추가
				prev.childs.add(newNode);

//				다음으로 넘어감
				prev = newNode;
				idx++;
			}
		}

//		사전순 정렬
		for (Node node : nodeList) {
			Collections.sort(node.childs, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					return o1.name.compareTo(o2.name);
				}

			});
		}

//		dfs
		dfs(0, 0);

		System.out.println(sb);

	}

	private static void dfs(int parentIdx, int depth) {
		List<Node> childs = nodeList.get(parentIdx).childs;

		for (Node node : childs) {
			for (int i = 0; i < depth; i++) {
				sb.append("--");
			}

			sb.append(node.name).append("\n");

			dfs(node.idx, depth + 1);
		}

	}

}
