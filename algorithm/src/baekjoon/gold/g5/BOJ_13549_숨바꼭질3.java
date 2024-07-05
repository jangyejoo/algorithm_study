package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[100001];

		q.offer(n);
		dist[n] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int d : new int[] { cur, 1, -1 }) {
				int nxt = cur + d;
				if (nxt < 0 || nxt > 100000)
					continue;
				if (dist[nxt] != 0 && dist[nxt] < dist[cur] + 1)
					continue;
				if (d == cur)
					dist[nxt] = dist[cur];
				else
					dist[nxt] = dist[cur] + 1;
				q.offer(nxt);
			}
		}

		System.out.println(dist[k] - 1);
	}

}