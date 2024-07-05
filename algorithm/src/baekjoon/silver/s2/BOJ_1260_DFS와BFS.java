package baekjoon.silver.s2;

import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String nmv = br.readLine();
		StringTokenizer st = new StringTokenizer(nmv);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		boolean[][] info = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			info[num1][num2] = true;
			info[num2][num1] = true;
		}

//		init done

		boolean[] visited = new boolean[n + 1];
		sb.append(v + " ");
		dfs(visited, info, v, n);
		sb.append("\n");
		visited = new boolean[n + 1];
		bfs(visited, info, v, n);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void bfs(boolean[] visited, boolean[][] info, int v, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		sb.append(v + " ");
		visited[v] = true;
		while (!q.isEmpty()) {
			int cur = q.peek();
			q.poll();
			for (int j = 1; j <= n; j++) {
				if (info[cur][j] == true && !visited[j]) {
					q.add(j);
					sb.append(j + " ");
					visited[j] = true;
				}
			}
		}
	}

	private static void dfs(boolean[] visited, boolean[][] info, int v, int n) {
		visited[v] = true;
		for (int i = 1; i <= n; i++) {
			if (info[v][i] == true && !visited[i]) {
				sb.append(i + " ");
				dfs(visited, info, i, n);
			}
		}
	}

}
