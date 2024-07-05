package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {

	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		double[][] map = new double[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		for (int i = 0; i < n; i++) {
			garo(map, n, i, l);
			sero(map, n, i, l);
		}

		System.out.println(cnt);

	}

	private static void garo(double[][] map, int n, int i, int l) {
		boolean[] way = new boolean[n];
		int idx = 0;

		while (idx + 1 < n) {
			double gap = Math.abs(map[i][idx] - map[i][idx + 1]);

			// 경사가 2 이상인 곳을 만났을 때
			if (gap >= 2)
				return;

			// 경사 1을 만났는데 경사로 설치가 불가할 때
			if (gap == 1) {
				if (map[i][idx] > map[i][idx + 1]) {
					for (int j = idx + 1; j < idx + 1 + l; j++) {
						if (j >= n || map[i][j] != map[i][idx + 1] || way[j])
							return;
					}
					for (int j = idx + 1; j < idx + 1 + l; j++) {
						way[j] = true;
					}
				} else {
					for (int j = idx; j > idx - l; j--) {
						if (j < 0 || map[i][j] != map[i][idx] || way[j])
							return;
					}
					for (int j = idx; j > idx - l; j--) {
						way[j] = true;
					}
				}
			}

			// 경사가 없음
			idx++;
		}

		cnt++;

	}

	private static void sero(double[][] map, int n, int i, int l) {
		boolean[] way = new boolean[n];
		int idx = 0;

		while (idx + 1 < n) {
			double gap = Math.abs(map[idx][i] - map[idx + 1][i]);

			// 경사가 2 이상인 곳을 만났을 때
			if (gap >= 2)
				return;

			// 경사 1을 만났는데 경사로 설치가 불가할 때
			if (gap == 1) {
				if (map[idx][i] > map[idx + 1][i]) {
					for (int j = idx + 1; j < idx + 1 + l; j++) {
						if (j >= n || map[j][i] != map[idx + 1][i] || way[j])
							return;
					}
					for (int j = idx + 1; j < idx + 1 + l; j++) {
						way[j] = true;
					}
				} else {
					for (int j = idx; j > idx - l; j--) {
						if (j < 0 || map[j][i] != map[idx][i] || way[j])
							return;
					}
					for (int j = idx; j > idx - l; j--) {
						way[j] = true;
					}
				}
			}

			// 경사가 없음
			idx++;
		}

		cnt++;

	}

}
