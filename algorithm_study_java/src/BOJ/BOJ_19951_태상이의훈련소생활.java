package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_19951_태상이의훈련소생활 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] grounds = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			grounds[i] = Integer.parseInt(st.nextToken());
		}

		int[] prefix = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			prefix[a] += k;

			if (b + 1 <= n)
				prefix[b + 1] += -k;
		}

//		누적합
		for (int i = 1; i <= n; i++) {
			prefix[i] += prefix[i - 1];
		}

		for (int i = 1; i <= n; i++) {
			sb.append(grounds[i] + prefix[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
