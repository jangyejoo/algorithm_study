package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559_PuyoPuyo {

	static int answer = 0;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// init done

		play(map);

		System.out.println(answer);
	}

	private static void play(char[][] map) {
		while (true) {
			// 한 방에 터뜨릴 뿌요 좌표
			List<int[]> puyo = new ArrayList<>();

			// bfs queue
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visit = new boolean[12][6];

			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					// 뿌요를 만났을 때
					if (map[i][j] != '.' && !visit[i][j]) {
						// 뿌요 범위
						List<int[]> group = new ArrayList<>();
						q.add(new int[] { i, j });
						group.add(new int[] { i, j });
						visit[i][j] = true;
						while (!q.isEmpty()) {
							int[] cur = q.poll();
							int x = cur[0];
							int y = cur[1];
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								if (nx < 0 || ny < 0 || nx > 11 || ny > 5)
									continue;
								if (visit[nx][ny])
									continue;
								if (map[nx][ny] != map[x][y])
									continue;
								visit[nx][ny] = true;
								q.add(new int[] { nx, ny });
								group.add(new int[] { nx, ny });
							}
						}
						// 뿌요 크기가 4 이상일 때 한 방에 터뜨릴 list에 추가
						if (group.size() >= 4) {
							puyo.addAll(group);
						}
					}

				}
			}

			if (!puyo.isEmpty()) {
				// 터뜨릴 뿌요가 있을 때 연쇄 카운트 증가
				for (int[] pos : puyo) {
					map[pos[0]][pos[1]] = '.';
				}
				answer++;
			} else {
				// 터뜨릴 뿌요가 없을 때 종료
				return;
			}

			// 빈 공간 채우기
			for (int i = 0; i < 6; i++) {
				int cnt = 0;
				for (int j = 11; j >= 0; j--) {
					if (map[j][i] == '.') {
						cnt++;
					} else {
						if (cnt > 0) {
							map[j + cnt][i] = map[j][i];
							map[j][i] = '.';
						}
					}
				}

			}
		}

	}
}
