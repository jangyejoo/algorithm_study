package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import BOJ.BOJ_17472_다리만들기2.Edge;

public class BOJ_17471_게리맨더링 {

	static int[] population;
	static boolean[][] edge;
	static int ans = Integer.MAX_VALUE;

	static class Edge {
		int from, to;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		population = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		edge = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				edge[i][Integer.parseInt(st.nextToken())] = true;
			}
		}

//		edge배열 확인
//		printEdge(edge, n);

//		init done

		boolean[] selected = new boolean[n];
		subset(selected, n, 0);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void printEdge(boolean[][] edge, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(edge[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	private static boolean subset(boolean[] selected, int n, int cnt) {
		if (cnt == n) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (selected[i])
					A.add(i + 1);
				else
					B.add(i + 1);
			}

			if (A.size() == 0 || B.size() == 0) {
				return false;
			}

			int resultA = check(A, n);
			int resultB = check(B, n);
			if (resultA == -1 || resultB == -1) {
			} else {
				int sub = Math.abs(resultA - resultB);
				if (sub < ans) {
					ans = sub;
				}
			}

			if (A.size() == n - 1) {
				return true;
			} else {
				return false;
			}
		}

		selected[cnt] = false;
		if (subset(selected, n, cnt + 1))
			return true;

		selected[cnt] = true;
		if (subset(selected, n, cnt + 1))
			return true;

		return false;

	}

	private static int check(List<Integer> list, int n) {
		int size = list.size();
		List<Edge> edgeList = new ArrayList<>();
		int result = 0;
		for (int i = 0; i < size; i++) {
			result += population[list.get(i)];
			for (int j = i; j < size; j++) {
				int I = list.get(i);
				int J = list.get(j);
				if (edge[I][J])
					edgeList.add(new Edge(I, J));
			}
		}

		if (size == 1) {
			return result;
		}

		int[] parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(parents, edge.from, edge.to)) {
				if (++cnt == size - 1)
					break;
			}
		}

		if (cnt == size - 1) {
			return result;
		} else {
			return -1;
		}

	}

	static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents, parents[a]);
	}

	static boolean union(int[] parents, int a, int b) {
		int aRoot = find(parents, a);
		int bRoot = find(parents, b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

}
