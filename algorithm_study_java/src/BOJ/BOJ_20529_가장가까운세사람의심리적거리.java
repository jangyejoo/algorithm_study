package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20529_가장가까운세사람의심리적거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] input = new int[16];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				String s = st.nextToken();
				int idx = 0;
				for (int j = 0; j < 4; j++) {
					char c = s.charAt(j);
					if (c == 'E' || c == 'S' || c == 'T' || c == 'J') {
						idx += Math.pow(2, j);
					}
				}
				input[idx]++;
			}

			// init done

			int min = 8;
			for (int i = 0; i < 16; i++) {
				if (input[i] > 0) {
					input[i]--;
					for (int j = 0; j < 16; j++) {
						if (input[j] > 0) {
							input[j]--;
							for (int j2 = 0; j2 < 16; j2++) {
								if (input[j2] > 0) {
									min = Math.min(min, Integer.bitCount(i ^ j) + Integer.bitCount(i ^ j2)
											+ Integer.bitCount(j2 ^ j));
								}
							}
							input[j]++;
						}
					}
					input[i]++;
				}
			}
			sb.append(min).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
