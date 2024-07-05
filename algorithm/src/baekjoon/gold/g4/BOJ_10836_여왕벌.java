package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10836_여왕벌 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[m][m];

//		입력으로 주어지는 애벌레들 성장 속도
		int[] growth = new int[2 * m - 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int idx = 0;
			for (int num = 0; num < 3; num++) {
				int cnt = Integer.parseInt(st.nextToken());

				for (int k = 0; k < cnt; k++) {
					growth[idx++] += num;
				}
			}
		}

		int idx = 0;

		for (int x = m - 1; x > 0; x--) {
			for (int y = 0; y < m; y++) {
				map[x][y] = growth[idx];
			}
			idx++;
		}

		for (int x = 0; x < m; x++) {
			map[x][x] = growth[idx];
		}
		idx++;

		for (int y = 1; y < m; y++) {
			for (int x = 0; x < m; x++) {
				map[x][y] = growth[idx];
			}
			idx++;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j] + 1).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
