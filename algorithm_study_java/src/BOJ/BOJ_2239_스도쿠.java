package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239_스도쿠 {

	static StringBuilder sb;
	static List<int[]> zero;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int[][] board = new int[9][9];
		zero = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				board[i][j] = row[j] - '0';
				if (board[i][j] == 0) {
					zero.add(new int[] { i, j });
				}
			}
		}

//		init done

		play(board, 0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean play(int[][] board, int index) {
		if (index == zero.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			return true;
		}

		int R = zero.get(index)[0];
		int C = zero.get(index)[1];

		for (int n = 1; n < 10; n++) {
			if (isPossible(board, R, C, n)) {
				board[R][C] = n;

				if (play(board, index + 1))
					return true;

				board[R][C] = 0;

			}
		}
		return false;
	}

	private static boolean isPossible(int[][] board, int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == n)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == n)
				return false;
		}
		int start_r = -1;
		int start_c = -1;

		if (r < 3) {
			start_r = 0;
		} else if (r < 6) {
			start_r = 3;
		} else {
			start_r = 6;
		}

		if (c < 3) {
			start_c = 0;
		} else if (c < 6) {
			start_c = 3;
		} else {
			start_c = 6;
		}

		for (int i = start_r; i < start_r + 3; i++) {
			for (int j = start_c; j < start_c + 3; j++) {
				if (board[i][j] == n)
					return false;
			}
		}
		return true;
	}
}
