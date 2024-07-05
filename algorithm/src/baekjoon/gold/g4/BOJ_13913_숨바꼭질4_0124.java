package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913_숨바꼭질4_0124 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] dist = new int[100001][2];
		Queue<Integer> q = new LinkedList<>();

		q.offer(n);
		dist[n][0] = 1;
		dist[n][1] = -1;

		B: while (!q.isEmpty()) {
			int cur = q.poll();
			for (int d : new int[] { 1, -1, cur }) {
				int nxt = cur + d;
				if (nxt < 0 || nxt > 100000)
					continue;
				if (dist[nxt][0] != 0)
					continue;
				dist[nxt][0] = dist[cur][0] + 1;
				dist[nxt][1] = cur;
				if (nxt == k)
					break B;
				q.offer(nxt);
			}
		}

		System.out.println(dist[k][0] - 1);
		List<Integer> result = new ArrayList<>();
		int num = k;
		while (num != -1) {
			result.add(num);
			num = dist[num][1];
		}
		for (int i = result.size() - 1; i >= 0; i--) {
			sb.append(result.get(i)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
