package baekjoon.silver.s2;

import java.io.*;
import java.util.*;

public class BOJ_10971_외판원순회2 {

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] w = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[n];
		getMin(visited, w, n, 0, 0, 0);

		System.out.println(ans);

	}

	private static void getMin(boolean[] visited, int[][] w, int n, int start, int result, int cnt) {
		if (result > ans) {
			return;
		}
		if (cnt == n - 1) {
			if (w[start][0] == 0)
				return;
			ans = ans > result + w[start][0] ? result + w[start][0] : ans;
			return;
		}

		visited[start] = true;

		for (int i = 0; i < n; i++) {
			if (visited[i] || w[start][i] == 0)
				continue;
			getMin(visited, w, n, i, result + w[start][i], cnt + 1);
			visited[i] = false;
		}
	}

}
