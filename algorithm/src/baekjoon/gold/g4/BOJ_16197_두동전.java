package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16197_두동전 {

	static int n, m;
	static int ans = 11;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] coins = new int[2][2];
		char[][] map = new char[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j + 1] = row.charAt(j);
				if (map[i][j + 1] == 'o') {
					if (coins[0][0] == 0) {
						coins[0][0] = i;
						coins[0][1] = j + 1;
					} else {
						coins[1][0] = i;
						coins[1][1] = j + 1;
					}
				}
			}
		}

		// init done

		int[][] copy = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				copy[i][j] = coins[i][j];
			}
		}
		for (int d = 0; d < 4; d++) {
			play(map, d, coins, 1);

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					coins[i][j] = copy[i][j];
				}
			}
		}

		System.out.println(ans == 11 ? -1 : ans);

	}

	private static void play(char[][] map, int direction, int[][] coins, int cnt) {
		int coinCnt = 2;

		// 코인 이동
		for (int c = 0; c < 2; c++) {
			if (coins[c][0] == 0) {
				// 이미 떨어진 동전
				coinCnt--;
				continue;
			}

			int nx = coins[c][0] + dx[direction];
			int ny = coins[c][1] + dy[direction];

			// 판 밖에 떨어질 때
			if (nx < 1 || ny < 1 || nx > n || ny > m) {
				coinCnt--;
				coins[c][0] = 0;
				coins[c][1] = 0;
				continue;
			}

			// 벽을 만나면 안 움직여
			if (map[nx][ny] == '#')
				continue;

			// 한 칸씩 움직여
			coins[c][0] = nx;
			coins[c][1] = ny;
		}

		if (coinCnt == 0) {
			// 2개 다 떨어짐
			return;
		}

		if (coinCnt == 1) {
			// 1개만 떨어짐 - 성공!
			ans = Math.min(ans, cnt);
			return;
		}

		if (cnt >= 10) {
			// 10번 해도 안됨
			return;
		}

		int[][] copy = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				copy[i][j] = coins[i][j];
			}
		}
		for (int d = 0; d < 4; d++) {
			play(map, d, coins, cnt + 1);

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					coins[i][j] = copy[i][j];
				}
			}
		}
	}

}
