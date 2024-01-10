package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		boolean[] notsosu = new boolean[10000];

		notsosu[0] = true;
		notsosu[1] = true;

		for (int i = 2; i * i < 10000; i++) {
			if (!notsosu[i]) {
				for (int j = i * i; j < 10000; j += i) {
					notsosu[j] = true;
				}
			}
		}

		C: for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// init done

			if (a == b) {
				sb.append(0).append("\n");
				continue C;
			}

			int[] dist = new int[10000];
			Arrays.fill(dist, -1);

			Queue<Integer> q = new LinkedList<>();

			dist[a] = 0;
			q.offer(a);

			while (!q.isEmpty()) {
				int cur = q.poll();

				int one = cur % 10;
				int ten = (cur % 100 - one) / 10;
				int hund = (cur % 1000 - ten - one) / 100;
				int thousand = (cur % 10000 - hund - ten - one) / 1000;

				for (int i = 0; i <= 9; i++) {

					int[] nexts = findNext(one, ten, hund, thousand, i);

					for (int d = 0; d < 4; d++) {
						int next = nexts[d];

						if (notsosu[next])
							continue;

						if (dist[next] != -1)
							continue;

						if (next < 1000)
							continue;

						dist[next] = dist[cur] + 1;

						if (next == b) {
							sb.append(dist[next]).append("\n");
							continue C;
						}

						q.offer(next);
					}
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int[] findNext(int one, int ten, int hund, int thousand, int num) {
		int[] result = new int[4];

		result[0] = thousand * 1000 + hund * 100 + ten * 10 + num;
		result[1] = thousand * 1000 + hund * 100 + num * 10 + one;
		result[2] = thousand * 1000 + num * 100 + ten * 10 + one;
		result[3] = num * 1000 + hund * 100 + ten * 10 + one;

		return result;
	}

}
