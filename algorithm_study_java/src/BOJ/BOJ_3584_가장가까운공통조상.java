package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3584_가장가까운공통조상 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			int[] parents = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				parents[b] = a;
			}

			st = new StringTokenizer(br.readLine().trim());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			// init done

			Queue<Integer> q = new LinkedList<>();
			find(parents, q, num1);
			int result = find(parents, q, num2);

			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int find(int[] parents, Queue<Integer> q, int num) {
		if (q.contains(num))
			return num;
		q.offer(num);
		if (parents[num] == num) {
			return num;
		}
		return num = find(parents, q, parents[num]);
	}

}
