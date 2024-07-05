package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠_1024 {
	static List<int[]> zeros = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] map = new int[9][9];
		int[] cnt = new int[10];
		Arrays.fill(cnt, 9);
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0) {
					zeros.add(new int[] { i, j });
				} else {
					map[i][j] = num;
					cnt[num]--;
				}
			}
		}

		// init done

		play(map, cnt, 0);

		print(map);

	}

	private static void print(int[][] map) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean play(int[][] map, int[] cnt, int idx) {
		if (idx == zeros.size()) {
			return true;
		}

		int[] cur = zeros.get(idx);
		for (int i = 1; i < 10; i++) {
			if (cnt[i] > 0) {
				map[cur[0]][cur[1]] = i;
				cnt[i]--;
				if (isPossible(map, cur[0], cur[1])) {
					if (play(map, cnt, idx + 1))
						return true;
				}
				map[cur[0]][cur[1]] = 0;
				cnt[i]++;
			}
		}
		return false;
	}

	private static boolean isPossible(int[][] map, int x, int y) {
		boolean[] visit1 = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (visit1[map[x][i]])
				return false;
			visit1[map[x][i]] = map[x][i] == 0 ? false : true;
		}

		Arrays.fill(visit1, false);
		for (int i = 0; i < 9; i++) {
			if (visit1[map[i][y]])
				return false;
			visit1[map[i][y]] = map[i][y] == 0 ? false : true;
		}

		int start_x = 0;
		if (x >= 0 && x < 3) {
			start_x = 0;
		} else if (x >= 3 && x < 6) {
			start_x = 3;
		} else {
			start_x = 6;
		}

		int start_y = 0;
		if (y >= 0 && y < 3) {
			start_y = 0;
		} else if (y >= 3 && y < 6) {
			start_y = 3;
		} else {
			start_y = 6;
		}

		Arrays.fill(visit1, false);
		for (int i = start_x; i < start_x + 3; i++) {
			for (int j = start_y; j < start_y + 3; j++) {
				if (visit1[map[i][j]])
					return false;
				visit1[map[i][j]] = map[i][j] == 0 ? false : true;
			}
		}

		return true;

	}
}
