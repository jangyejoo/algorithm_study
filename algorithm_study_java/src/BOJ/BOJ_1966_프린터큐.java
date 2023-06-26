package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine().trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] input = new int[n];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			// init done

			int cur = 0;
			int cnt = 0;
			int max = Arrays.stream(input).max().getAsInt();
			while (true) {
				if (input[cur] != -1 && input[cur] >= max) {
					input[cur] = -1;
					max = Arrays.stream(input).max().getAsInt();
					cnt++;
					if (cur == m)
						break;
				}
				cur++;
				cur %= n;
			}
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
