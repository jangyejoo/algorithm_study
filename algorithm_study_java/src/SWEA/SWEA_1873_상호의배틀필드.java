package SWEA;
import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String hw = br.readLine();
			StringTokenizer st = new StringTokenizer(hw);
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] b = new char[H][W];
			int x = 0;
			int y = 0;
			int[] dx = { 1, 0, -1, 0 };
			int[] dy = { 0, 1, 0, -1 };
			int d = 0;
			for (int i = 0; i < H; i++) {
				char[] row = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					b[i][j] = row[j];
					if (b[i][j] == '<') {
						x = i;
						y = j;
					} else if (b[i][j] == '^') {
						x = i;
						y = j;
					} else if (b[i][j] == '>') {
						x = i;
						y = j;
					} else if (b[i][j] == 'v') {
						x = i;
						y = j;
					}
				}

			}
			int cNum = Integer.parseInt(br.readLine());
			char[] c = br.readLine().toCharArray();
			// 초기화 끝!

			for (int i = 0; i < c.length; i++) {
				if (c[i] == 'U') {
					// 전차가 바라보는 방향을 위쪽으로 바꾸고,
					b[x][y] = '^';
					if (x - 1 >= 0 && b[x - 1][y] == '.') {
						// 한 칸 위의 칸이 평지라면 위 그 칸으로 이동
						b[x][y] = '.';
						x -= 1;
						b[x][y] = '^';
					}

				} else if (c[i] == 'D') {
					// 전차가 바라보는 방향을 아래쪽으로 바꾸고,
					b[x][y] = 'v';
					if (x + 1 < H && b[x + 1][y] == '.') {
						// 한 칸 아래의 칸이 평지라면 아래 그 칸으로 이동
						b[x][y] = '.';
						x += 1;
						b[x][y] = 'v';
					}
				} else if (c[i] == 'L') {
					// 전차가 바라보는 방향을 왼쪽으로 바꾸고,
					b[x][y] = '<';
					if (y - 1 >= 0 && b[x][y - 1] == '.') {
						// 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
						b[x][y] = '.';
						y -= 1;
						b[x][y] = '<';
					}
				} else if (c[i] == 'R') {
					// 전차가 바라보는 방향을 위쪽으로 바꾸고,
					b[x][y] = '>';
					if (y + 1 < W && b[x][y + 1] == '.') {
						// 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
						b[x][y] = '.';
						y += 1;
						b[x][y] = '>';
					}
				} else if (c[i] == 'S') {
					if (b[x][y] == '<') {
						int ny_b = y + dy[3];
						while (!(ny_b < 0 || ny_b > W - 1)) {
							// 벽돌 벽을 만났을 때
							if (b[x][ny_b] == '*') {
								b[x][ny_b] = '.';
								break;
							}
							// 강철 벽을 만났을 때
							if (b[x][ny_b] == '#') {
								break;
							}
							// 평지일 때
							ny_b += dy[3];
						}
					} else if (b[x][y] == '^') {
						int nx_b = x + dx[2];
						while (!(nx_b < 0 || nx_b > H - 1)) {
							// 벽돌 벽을 만났을 때
							if (b[nx_b][y] == '*') {
								b[nx_b][y] = '.';
								break;
							}
							// 강철 벽을 만났을 때
							if (b[nx_b][y] == '#') {
								break;
							}
							// 평지일 때
							nx_b += dx[2];
						}
					} else if (b[x][y] == '>') {
						int ny_b = y + dy[1];
						while (!(ny_b < 0 || ny_b > W - 1)) {
							// 벽돌 벽을 만났을 때
							if (b[x][ny_b] == '*') {
								b[x][ny_b] = '.';
								break;
							}
							// 강철 벽을 만났을 때
							if (b[x][ny_b] == '#') {
								break;
							}
							// 평지일 때
							ny_b += dy[1];
						}
					} else if (b[x][y] == 'v') {
						int nx_b = x + dx[0];
						while (!(nx_b < 0 || nx_b > H - 1)) {
							// 벽돌 벽을 만났을 때
							if (b[nx_b][y] == '*') {
								b[nx_b][y] = '.';
								break;
							}
							// 강철 벽을 만났을 때
							if (b[nx_b][y] == '#') {
								break;
							}
							// 평지일 때
							nx_b += dx[0];
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(b[i][j]).append(j+1 == W ? "\n" : "");
				}
			}
			System.out.print(sb);
		}
	}

}
