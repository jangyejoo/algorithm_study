package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

	// 북 동 남 서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] cleaned = new boolean[n][m];
		st = new StringTokenizer(br.readLine().trim());
		int rx = Integer.parseInt(st.nextToken());
		int ry = Integer.parseInt(st.nextToken());
		int rd = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		int cnt = 0;
		while (true) {
			if (cleaned[rx][ry] == false) {
				cleaned[rx][ry] = true;
				cnt++;
			}
			boolean havetoclean = false;
			for (int d = 0; d < 4; d++) {
				int nx = rx + dx[d];
				int ny = ry + dy[d];
				if (!cleaned[nx][ny] && map[nx][ny] != 1) {
					havetoclean = true;
				}
			}
			if (havetoclean) {
				// 현재 칸 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
				// 1. 반시계 방향으로 90도 회전한다.
				int direction = rd == 0 ? 3 : rd - 1;
				int nx = rx + dx[direction];
				int ny = ry + dy[direction];
				// 2. 바라보는 방향 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한 칸 전진한다.
				if (!cleaned[nx][ny] && map[nx][ny] != 1) {
					rx = nx;
					ry = ny;
					rd = direction;
				} else {
					rd = direction;
				}
			} else {
				// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
				// 바라보는 방향을 유지한 채로 한 칸 후진하고 1번으로 돌아감
				int direction = (rd + 2) % 4;
				int nx = rx + dx[direction];
				int ny = ry + dy[direction];
				if (map[nx][ny] != 1) {
					rx = nx;
					ry = ny;
				} else {
					break;
				}
			}

		}

		System.out.println(cnt);

	}

}
