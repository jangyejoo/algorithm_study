package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2448_별찍기11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		// init done

		char[][] painting = new char[n + 1][2 * n];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < 2 * n; j++) {
				painting[i][j] = ' ';
			}
		}

		// 배열, 꼭지점 x 좌표, 꼭지점 y 좌표, 삼각형 크기
		paint(painting, 1, n, n);

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < 2 * n; j++) {
				sb.append(painting[i][j]);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void paint(char[][] painting, int x, int y, int size) {
		if (size == 3) {
			painting[x][y] = '*';

			painting[x + 1][y - 1] = '*';
			painting[x + 1][y + 1] = '*';

			painting[x + 2][y - 2] = '*';
			painting[x + 2][y - 1] = '*';
			painting[x + 2][y] = '*';
			painting[x + 2][y + 1] = '*';
			painting[x + 2][y + 2] = '*';

			return;
		}

		paint(painting, x, y, size / 2);
		paint(painting, x + size / 2, y - size / 2, size / 2);
		paint(painting, x + size / 2, y + size / 2, size / 2);

	}

}
