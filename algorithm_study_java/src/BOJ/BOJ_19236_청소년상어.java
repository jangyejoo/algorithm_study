package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {

	static int ans = 0;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] map = new int[4][4];
		int[][] fishInfo = new int[17][3];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 물고기의 번호
				int fishNum = map[i][j];
				fishInfo[fishNum][0] = i;
				fishInfo[fishNum][1] = j;
				fishInfo[fishNum][2] = Integer.parseInt(st.nextToken()); // 물고기의 방향
			}
		}

//		init done

		int fish_x = 0;
		int fish_y = 0;
		party(fishInfo, map, 0, 0, map[fish_x][fish_y]);

		System.out.println(ans);

	}

	private static void party(int[][] fishInfo, int[][] map, int fish_x, int fish_y, int hap) {
		int[][] copy_map = new int[4][4];
		int[][] copy_fishInfo = new int[17][3];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 3; j++) {
				copy_fishInfo[i][j] = fishInfo[i][j];
			}
		}

		eatFish(copy_fishInfo, copy_map, fish_x, fish_y);

		mvFish(copy_map, copy_fishInfo);

		List<Integer> fishes = findFish(copy_map, copy_fishInfo[0]);
		if (fishes.size() == 0) {
			if (hap > ans)
				ans = hap;
			return;
		} else {
			for (int i = 0; i < fishes.size(); i++) {
				party(copy_fishInfo, copy_map, copy_fishInfo[fishes.get(i)][0], copy_fishInfo[fishes.get(i)][1],
						hap + fishes.get(i));
			}
		}
	}

	private static List<Integer> findFish(int[][] map, int[] sharkInfo) {
		List<Integer> result = new ArrayList<>();
		int nx = sharkInfo[0] + dx[(sharkInfo[2] - 1) % 8];
		int ny = sharkInfo[1] + dy[(sharkInfo[2] - 1) % 8];
		while (true) {

			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
				break;

			if (map[nx][ny] != 0)
				result.add(map[nx][ny]);

			nx += dx[(sharkInfo[2] - 1) % 8];
			ny += dy[(sharkInfo[2] - 1) % 8];

		}

		return result;
	}

	private static void eatFish(int[][] fishInfo, int[][] map, int fish_x, int fish_y) {
		int fishNum = map[fish_x][fish_y];

		fishInfo[0][0] = fish_x;
		fishInfo[0][1] = fish_y;
		fishInfo[0][2] = fishInfo[fishNum][2]; // 상어의 위치와 방향 변경

		map[fish_x][fish_y] = 0;
		fishInfo[fishNum][0] = -1;
		fishInfo[fishNum][1] = -1; // 잡아먹힌 물고기 값 제거
	}

	private static void mvFish(int[][] map, int[][] fishInfo) {
		for (int i = 1; i <= 16; i++) {
			if (fishInfo[i][0] == -1) // 이미 잡아먹힌 물고기
				continue;
			int cnt = 0;
			while (true) {
				int nx = fishInfo[i][0] + dx[(fishInfo[i][2] - 1) % 8];
				int ny = fishInfo[i][1] + dy[(fishInfo[i][2] - 1) % 8];
				if ((fishInfo[0][0] == nx && fishInfo[0][1] == ny) || nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
					fishInfo[i][2]++; // 45도 회전
					cnt++;
				} else {
					if (map[nx][ny] != 0) { // 다른 물고기가 있는 칸이면
						swap(fishInfo, map, i, map[nx][ny]); // 스왑
						break;
					} else { // 빈 칸이면
						map[fishInfo[i][0]][fishInfo[i][1]] = 0;
						fishInfo[i][0] = nx;
						fishInfo[i][1] = ny;
						map[nx][ny] = i; // 이동
						break;
					}
				}

				if (cnt == 8) // 모든 방향을 탐색해도 자리를 못찾으면?
					break;
			}
			printMap(map);
		}
	}

	private static void swap(int[][] fishInfo, int[][] map, int i, int j) {
		map[fishInfo[i][0]][fishInfo[i][1]] = j;
		map[fishInfo[j][0]][fishInfo[j][1]] = i;
		int temp_X = fishInfo[i][0];
		int temp_Y = fishInfo[i][1];
		fishInfo[i][0] = fishInfo[j][0];
		fishInfo[i][1] = fishInfo[j][1];
		fishInfo[j][0] = temp_X;
		fishInfo[j][1] = temp_Y;
	}

	//////////////////////////////////////
	private static void printMap(int[][] map) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

}
