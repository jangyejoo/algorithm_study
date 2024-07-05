package baekjoon.silver.s1;

import java.io.*;

public class BOJ_1992_쿼드트리 {

	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];

		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = row[j];
			}
		}

		check(map, 0, 0, n);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void check(char[][] map, int startX, int startY, int size) {
		boolean allSame = true;
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (map[i][j] != map[startX][startY]) {
					allSame = false;
					break;
				}
				if (!allSame) {
					break;
				}
			}
		}

		if (allSame) {
			sb.append(map[startX][startY]);
		} else {
			sb.append("(");
			check(map, startX, startY, size / 2);
			check(map, startX, startY + size / 2, size / 2);
			check(map, startX + size / 2, startY, size / 2);
			check(map, startX + size / 2, startY + size / 2, size / 2);
			sb.append(")");
		}

	}
}
