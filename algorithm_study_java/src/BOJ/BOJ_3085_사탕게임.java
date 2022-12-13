package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085_사탕게임 {

	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] board = new char[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 1; j <= n; j++) {
				board[i][j] = row[j - 1];
			}
		}

//		init done

		B: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 같으면 바꿔볼 필요 없다!
				if (board[i][j] == board[i][j - 1])
					continue;

				swap(board, i, j, i, j - 1);
				nyamnyam(board, n);
				swap(board, i, j, i, j - 1);

				if (max == n)
					break B;

			}
		}

		B: for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 같으면 바꿔볼 필요 없다!
				if (board[j][i] == board[j - 1][i])
					continue;

				swap(board, j, i, j - 1, i);
				nyamnyam(board, n);
				swap(board, j, i, j - 1, i);

				if (max == n)
					break B;

			}
		}

		System.out.println(max);

	}

	private static void swap(char[][] board, int curX, int curY, int nxtX, int nxtY) {
		char tmp = board[nxtX][nxtY];

		board[nxtX][nxtY] = board[curX][curY];
		board[curX][curY] = tmp;

	}

	private static void nyamnyam(char[][] board, int n) {
		int mmmaaaxxx = 0;
		int cntR = 1;
		int cntC = 1;
		for (int i = 1; i <= n; i++) {
			cntR = 1;
			for (int j = 1; j <= n; j++) {
				if (board[i][j] == board[i][j - 1]) {
					cntR++;
				} else {
					cntR = 1;
				}
				mmmaaaxxx = Math.max(mmmaaaxxx, cntR);
			}
		}

		for (int i = 1; i <= n; i++) {
			cntC = 1;
			for (int j = 1; j <= n; j++) {
				if (board[j][i] == board[j - 1][i]) {
					cntC++;
				} else {
					cntC = 1;
				}
				mmmaaaxxx = Math.max(mmmaaaxxx, cntC);
			}
		}

		max = Math.max(max, mmmaaaxxx);

	}

}
