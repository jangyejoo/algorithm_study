package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2447_별찍기10_0911 {

	static char[][] output;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		output = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(output[i], '*');
		}

		delete(0, 0, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(output[i][j]);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void delete(int x, int y, int n) {
		if (n == 1) {
			return;
		}
		int size = n / 3;
		int start_x = x + size;
		int start_y = y + size;
		for (int i = start_x; i < start_x + size; i++) {
			for (int j = start_y; j < start_y + size; j++) {
				output[i][j] = ' ';
			}
		}
		delete(x, y, n / 3);
		delete(x + size, y, n / 3);
		delete(x + 2 * size, y, n / 3);
		delete(x, y + size, n / 3);
		delete(x + 2 * size, y + size, n / 3);
		delete(x, y + 2 * size, n / 3);
		delete(x + size, y + 2 * size, n / 3);
		delete(x + 2 * size, y + 2 * size, n / 3);
	}

}
