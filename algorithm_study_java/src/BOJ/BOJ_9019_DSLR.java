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

public class BOJ_9019_DSLR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine().trim());
			int input = Integer.parseInt(st.nextToken());
			int output = Integer.parseInt(st.nextToken());

			// init done

			Queue<Integer> q = new LinkedList<>();
			int[] prev = new int[10000];
			char[] command = new char[10000];
			Arrays.fill(command, 'n');
			q.add(input);

			B: while (!q.isEmpty()) {
				int cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int next = 0;
					switch (i) {
					case 0:
						next = d(cur);
						if (command[next] == 'n') {
							prev[next] = cur;
							command[next] = 'D';
							q.add(next);
						}
						break;
					case 1:
						next = s(cur);
						if (command[next] == 'n') {
							prev[next] = cur;
							command[next] = 'S';
							q.add(next);
						}
						break;
					case 2:
						next = l(cur);
						if (command[next] == 'n') {
							prev[next] = cur;
							command[next] = 'L';
							q.add(next);
						}
						break;
					case 3:
						next = r(cur);
						if (command[next] == 'n') {
							prev[next] = cur;
							command[next] = 'R';
							q.add(next);
						}
						break;
					}
					if (next == output)
						break B;
				}
			}

			int idx = output;
			String ans = "";
			while (idx != input) {
				ans = command[idx] + ans;
				idx = prev[idx];
			}

			sb.append(ans).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int d(int n) {
		int twotimes = 2 * n;
		if (twotimes > 9999)
			return twotimes % 10000;
		return twotimes;
	}

	private static int s(int n) {
		if (n == 0)
			return 9999;
		return n - 1;
	}

	private static int l(int n) {
		int thousand = n / 1000;
		int thousandmod = n % 1000;
		return thousandmod * 10 + thousand;
	}

	private static int r(int n) {
		int ten = n / 10;
		int tenmod = n % 10;
		return tenmod * 1000 + ten;
	}
}
