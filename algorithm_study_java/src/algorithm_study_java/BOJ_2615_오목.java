package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[20][20];

		for (int i = 1; i <= 19; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int j = 1; j <= 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dx[] = { 1, 0, -1, 1 };
		int dy[] = { 0, 1, 1, 1 };

		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
//				검은 바둑돌
				if (board[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int cnt_B = 0;
						int x = i;
						int y = j;
						for (int l = 1; l <= 5; l++) {
							if (x < 1 || x > 19 || y < 1 || y > 19 || board[x][y] != 1)
								break;
							else {
								cnt_B++;
								x += dx[k];
								y += dy[k];
							}
						}

						if (cnt_B == 5) {
							if (check(i - dx[k], j - dy[k])) {
								if (board[i - dx[k]][j - dy[k]] != 1) {
									if (check(i + (5 * dx[k]), j + (5 * dy[k]))) {
										if (board[i + (5 * dx[k])][j + (5 * dy[k])] != 1) {
											result(i, j, 1);
										}
									} else {
										result(i, j, 1);
									}
								}
							} else {
								if (check(i + (5 * dx[k]), j + (5 * dy[k]))) {
									if (board[i + (5 * dx[k])][j + (5 * dy[k])] != 1) {
										result(i, j, 1);
									}
								} else {
									result(i, j, 1);
								}
							}
						}
					}

				}
//				흰 바둑돌
				if (board[i][j] == 2) {
					for (int k = 0; k < 4; k++) {
						int cnt_W = 0;
						int x = i;
						int y = j;
						for (int l = 1; l <= 5; l++) {
							if (x < 1 || x > 19 || y < 1 || y > 19 || board[x][y] != 2)
								break;
							else {
								cnt_W++;
								x += dx[k];
								y += dy[k];
							}
						}

						if (cnt_W == 5) {
							if (check(i - dx[k], j - dy[k])) {
								if (board[i - dx[k]][j - dy[k]] != 2) {
									if (check(i + (5 * dx[k]), j + (5 * dy[k]))) {
										if (board[i + (5 * dx[k])][j + (5 * dy[k])] != 2) {
											result(i, j, 2);
										}
									} else {
										result(i, j, 2);
									}
								}
							} else {
								if (check(i + (5 * dx[k]), j + (5 * dy[k]))) {
									if (board[i + (5 * dx[k])][j + (5 * dy[k])] != 2) {
										result(i, j, 2);
									}
								} else {
									result(i, j, 2);
								}
							}
						}
					}
				}
			}
		}
		System.out.println(0);
	}

	public static boolean check(int x, int y) {
		if (x < 1 || x > 19 || y < 1 || y > 19)
			return false;
		return true;
	}

	public static void result(int i, int j, int num) {
		System.out.println(num);
		System.out.println(i + " " + j);
		System.exit(0);
	}

}
