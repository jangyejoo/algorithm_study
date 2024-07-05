package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// init done

			if (!union(parents, a, b)) {
				System.out.println(i + 1);
				return;
			}
		}

		System.out.println(0);
		return;

	}

	private static boolean union(int[] parents, int a, int b) {
		int aRoot = find(parents, a);
		int bRoot = find(parents, b);

		if (aRoot != bRoot) {
			if (a < b)
				parents[aRoot] = bRoot;
			else
				parents[bRoot] = aRoot;
		} else {
			return false;
		}
		return true;
	}

	private static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents, parents[a]);
	}

}
