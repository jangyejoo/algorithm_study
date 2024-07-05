package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] adjMatrix = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjMatrix[from][to] = Math.min(adjMatrix[from][to], weight);

		}

		st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

//		init done

		boolean[] visited = new boolean[n + 1];

		int[] D = new int[n + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;

//		ver1. 기본 다익스트라 (424ms)
		int min, minVertex;

		for (int i = 0; i < n; i++) {
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 1; j <= n; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			if (minVertex == end)
				break;

			for (int j = 1; j <= n; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] != Integer.MAX_VALUE && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
					D[j] = D[minVertex] + adjMatrix[minVertex][j];
				}
			}

		}

		System.out.println(D[end]);
		
//		ver2. 다익스트라 + PriorityQueue 이용 (568ms)
//		PriorityQueue<int[]> pQueue = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);
//		pQueue.offer(new int[] { start, D[start] });
//
//		while (!pQueue.isEmpty()) {
//			int[] poll = pQueue.poll();
//			int minVertex = poll[0];
//
//			if (!visited[minVertex]) {
//				visited[minVertex] = true;
//				if (minVertex == end)
//					break;
//				for (int j = 1; j <= n; j++) {
//					if (!visited[j] && adjMatrix[minVertex][j] != Integer.MAX_VALUE
//							&& D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
//						D[j] = D[minVertex] + adjMatrix[minVertex][j];
//						pQueue.offer(new int[] { j, D[j] });
//					}
//				}
//			}
//		}
//
//		System.out.println(D[end]);

	}

}
