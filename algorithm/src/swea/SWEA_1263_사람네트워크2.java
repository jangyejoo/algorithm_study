package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[][] D = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					D[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			init done

			for (int i = 0; i < n; i++) { // 경
				for (int j = 0; j < n; j++) { // 출
					for (int j2 = 0; j2 < n; j2++) { // 도
						if (D[j][j2] == 0) {
							if (D[j][i] == 0 || D[i][j2] == 0) {
							} else {
								D[j][j2] = D[j][i] + D[i][j2];
							}
						} else {
							if (D[j][i] == 0 || D[i][j2] == 0) {
							} else {
								D[j][j2] = Math.min(D[j][j2], D[j][i] + D[i][j2]);
							}
						}
					}
				}
			}

			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int hap = 0;
				for (int j = 0; j < n; j++) {
					if (i != j)
						hap += D[i][j];
				}
				if (ans > hap)
					ans = hap;
			}

			sb.append(ans).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
