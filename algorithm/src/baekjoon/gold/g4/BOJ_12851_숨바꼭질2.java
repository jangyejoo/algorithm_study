package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		int[][] dist = new int[100001][2];

		q.offer(n);
		dist[n][0] = 1;
		dist[n][1] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int d : new int[] { 1, -1, cur }) {
				int nxt = cur + d;
				if (nxt < 0 || nxt > 100000)
					continue;
				if (dist[nxt][0] != 0 && dist[nxt][0] < dist[cur][0] + 1)
					continue;
				if (dist[nxt][0] == dist[cur][0] + 1) {
					dist[nxt][1]++;
					q.offer(nxt);
					continue;
				}
				dist[nxt][0] = dist[cur][0] + 1;
				dist[nxt][1] = 1;
				q.offer(nxt);
			}
		}

		System.out.println(dist[k][0] - 1);
		System.out.println(dist[k][1]);

	}
}
