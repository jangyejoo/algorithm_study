package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_색종이붙이기 {

	static int ans = 25;
	static int[][] map;
	static int[] papers = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		func(0, 0, 0);

		if (ans == 25) {
			ans = -1;
		}

		System.out.println(ans);

	}

	private static void func(int x, int y, int cnt) {
//		끝까지 탐색했으면 최소값 갱신 후 return
		if (x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}

//		이미 최소값이 아니면 return
		if (ans <= cnt) {
			return;
		}

		if (y > 9) {
			func(x + 1, 0, cnt);
			return;
		}

		if (map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (papers[i] > 0 && check(x, y, i)) {
					attach(x, y, i, 0);
					papers[i]--;
					func(x, y + 1, cnt + 1);
					attach(x, y, i, 1);
					papers[i]++;
				}
			}
		} else {
			func(x, y + 1, cnt);
		}
	}

	private static void attach(int x, int y, int size, int state) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}

	private static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				if (map[i][j] != 1)
					return false;
			}
		}
		return true;
	}

}
