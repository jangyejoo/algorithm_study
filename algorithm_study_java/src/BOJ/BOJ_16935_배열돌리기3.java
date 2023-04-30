package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String nmr = br.readLine();
		StringTokenizer st = new StringTokenizer(nmr);

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int size = n > m ? n : m;
		int r = Integer.parseInt(st.nextToken());

		int[][] board = new int[size][size];

		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			st = new StringTokenizer(row);
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		String command = br.readLine();
		st = new StringTokenizer(command);
		for (int i = 0; i < r; i++) {
			int commandNum = Integer.parseInt(st.nextToken());
			switch (commandNum) {
			case 1:
				board = rotate1(board);
				break;
			case 2:
				board = rotate2(board);
				break;
			case 3:
				board = rotate3(board);
				break;
			case 4:
				board = rotate4(board);
				break;
			case 5:
				board = rotate5(board);
				break;
			case 6:
				board = rotate6(board);
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static int[][] rotate1(int[][] b) {
//		상하반전
		int[][] copy = new int[n][m];
		int idx = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = b[idx][j];
			}
			idx--;
		}
		return copy;
	}

	private static int[][] rotate2(int[][] b) {
//		좌우반전
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			int idx = m - 1;
			for (int j = 0; j < m; j++) {
				copy[i][j] = b[i][idx--];
			}
		}
		return copy;
	}

	private static int[][] rotate3(int[][] b) {
//		오른쪽 90 회전
		int[][] copy = new int[m][n];
		int idx = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[j][idx] = b[i][j];
			}
			idx--;
		}
		int tmp = m;
		m = n;
		n = tmp;
		return copy;
	}

	private static int[][] rotate4(int[][] b) {
//		왼쪽 90 회전
		int[][] copy = new int[m][n];
		for (int i = 0; i < n; i++) {
			int idx = m - 1;
			for (int j = 0; j < m; j++) {
				copy[idx--][i] = b[i][j];
			}
		}
		int tmp = m;
		m = n;
		n = tmp;
		return copy;
	}

	private static int[][] rotate5(int[][] board) {
//		4개로 쪼개서 시계 방향 회전
		int[][] copy = new int[n][m];
		int midX = n / 2;
		int midY = m / 2;
		for (int i = 0; i < midX; i++) {
			for (int j = 0; j < midY; j++) {
				copy[i][j] = board[i + midX][j];
			}
		}
		for (int i = midX; i < n; i++) {
			for (int j = 0; j < midY; j++) {
				copy[i][j] = board[i][j + midY];
			}
		}
		for (int i = 0; i < midX; i++) {
			for (int j = midY; j < m; j++) {
				copy[i][j] = board[i][j - midY];
			}
		}
		for (int i = midX; i < n; i++) {
			for (int j = midY; j < m; j++) {
				copy[i][j] = board[i - midX][j];
			}
		}
		return copy;
	}

	private static int[][] rotate6(int[][] board) {
//		4개로 쪼개서 반시계 방향 회전
		int[][] copy = new int[n][m];
		int midX = n / 2;
		int midY = m / 2;
		for (int i = 0; i < midX; i++) {
			for (int j = 0; j < midY; j++) {
				copy[i][j] = board[i][j + midY];
			}
		}
		for (int i = midX; i < n; i++) {
			for (int j = 0; j < midY; j++) {
				copy[i][j] = board[i - midX][j];
			}
		}
		for (int i = 0; i < midX; i++) {
			for (int j = midY; j < m; j++) {
				copy[i][j] = board[i + midX][j];
			}
		}
		for (int i = midX; i < n; i++) {
			for (int j = midY; j < m; j++) {
				copy[i][j] = board[i][j - midY];
			}
		}
		return copy;
	}

}
