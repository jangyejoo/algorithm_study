package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		int[] ans = new int[n + 1];
		ans[n] = -1;
		for (int i = n - 1; i >= 1; i--) {
			if (input[i + 1] > input[i]) {
				ans[i] = i + 1;
			} else {
				int next = ans[i + 1];
				while (true) {
					if (next == -1) {
						ans[i] = -1;
						break;
					}

					if (input[next] > input[i]) {
						ans[i] = next;
						break;
					}
					next = ans[next];
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(ans[i] == -1 ? -1 : input[ans[i]]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
