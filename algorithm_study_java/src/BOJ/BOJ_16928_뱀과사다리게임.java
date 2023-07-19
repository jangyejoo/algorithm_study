package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] jump = new int[101];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			jump[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			jump[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		// init done

		Queue<Integer> q = new LinkedList<>();

		int[] dist = new int[101];
		Arrays.fill(dist, -1);

		int start = jump[1] != 0 ? jump[1] : 1;
		q.add(start);
		dist[start] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int dice = 1; dice <= 6; dice++) {
				int next = cur + dice;

				if (next > 100)
					continue;

				next = jump[next] != 0 ? jump[next] : next;

				if (dist[next] != -1)
					continue;

				dist[next] = dist[cur] + 1;

				if (next == 100) {
					System.out.println(dist[100]);
					return;
				}

				q.add(next);

			}
		}

	}

}
