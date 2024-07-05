package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {

	static int[][] map;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, n);
		map = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] command = new int[q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

//		init done

//		command를 입력받자마자 할 수도 있지만~ 난 이게 편해
		Queue<int[]> ice = new LinkedList<>();
		for (int i = 0; i < q; i++) {
			int commandSize = (int) Math.pow(2, command[i]);

//			1. 주어진 크기로 격자 나누고 시계 방향으로 돌리기
			for (int x = 0; x < size; x += commandSize) {
				for (int y = 0; y < size; y += commandSize) {
					rotate(x, y, commandSize);
				}
			}

//			2. 주변에 얼음있는 인접 칸 개수가 2개 이하면 -1
			for (int x = 0; x < size; x++) {
				for (int y = 0; y < size; y++) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];

						if (nx < 0 || ny < 0 || nx >= size || ny >= size)
							continue;

						if (map[nx][ny] <= 0)
							continue;

//						얼음이 있는 곳
						cnt++;
					}

//					얼음이 인접한 면이 3개도 안됨
					if (cnt < 3) {
						ice.offer(new int[] { x, y });
					}
				}
			}

			while (!ice.isEmpty()) {
				int[] cur = ice.poll();
				map[cur[0]][cur[1]]--;
			}
		}

//		남아있는 얼음의 합
//		가장 큰 얼음 덩어리의 크기
		int hap = 0;
		int maxSize = 0;
		int section = 0;
		int[][] result = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (map[x][y] <= 0)
					continue;

				hap += map[x][y];

				if (result[x][y] != 0)
					continue;

				int iceSize = 1;
				result[x][y] = ++section;
				ice.offer(new int[] { x, y });

				while (!ice.isEmpty()) {
					int[] cur = ice.poll();

					for (int d = 0; d < 4; d++) {
						int nx = cur[0] + dx[d];
						int ny = cur[1] + dy[d];

						if (nx < 0 || ny < 0 || nx >= size || ny >= size)
							continue;

						if (map[nx][ny] <= 0)
							continue;

						if (result[nx][ny] != 0)
							continue;

						iceSize++;
						result[nx][ny] = section;
						ice.offer(new int[] { nx, ny });
					}
				}

				maxSize = Math.max(maxSize, iceSize);

			}
		}

		System.out.println(hap);
		System.out.println(maxSize);

	}

	private static void rotate(int x, int y, int commandSize) {
//		임시 배열에 복사
		int[][] temp = new int[commandSize][commandSize];
		for (int i = x; i < x + commandSize; i++) {
			for (int j = y; j < y + commandSize; j++) {
				temp[i - x][j - y] = map[i][j];
			}
		}

//		90도 돌려서 저장
		for (int i = 0; i < commandSize; i++) {
			for (int j = 0; j < commandSize; j++) {
				map[x + j][y + commandSize - 1 - i] = temp[i][j];
			}
		}
	}

}
