package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_16236_아기상어 {

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

//		아기상어 초기 값
		int initX = -1;
		int initY = -1;
		int size = 2;

		List<int[]> fish = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 9) {
//					물고기면 list에 저장
					int[] input = { i, j, map[i][j] };
					fish.add(input);
				}
				if (map[i][j] == 9) {
//					아기상어 초기위치 저장
					initX = i;
					initY = j;
					map[i][j] = 0;
				}
			}
		}

		Collections.sort(fish, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		int ans = 0;
		int alreadyEat = 0; // 먹은 개수

		while (true) {
			int selectedFish[] = pickOne(fish, map, n, initX, initY, size);
			if (selectedFish == null) {
				break;
			}
			alreadyEat++;
			ans += selectedFish[2];
			if (alreadyEat == size) {
				size++;
				alreadyEat = 0;
			}
			initX = selectedFish[0];
			initY = selectedFish[1]; // 아기상어 위치 변경
			map[initX][initY] = 0;
		}

		System.out.println(ans);

	}

	private static int[] pickOne(List<int[]> canEat, int[][] map, int n, int initX, int initY, int bsSize) {
		int resultD = Integer.MAX_VALUE;
		int resultIdx = -1;
		int resultX = -1;
		int resultY = -1;

		Queue<int[]> q = new LinkedList<int[]>();
		int[][] distance = new int[n][n];
		for (int j = 0; j < n; j++) {
			for (int j2 = 0; j2 < n; j2++) {
				distance[j][j2] = -1;
			}
		}
		distance[initX][initY] = 0;

		int[] input = { initX, initY };
		q.offer(input);
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (distance[nx][ny] != -1)
					continue;
				if (bsSize < map[nx][ny])
					continue;
				distance[nx][ny] = distance[x][y] + 1;
				int[] nxt = { nx, ny };
				q.offer(nxt);
			}
		}

		for (int i = 0, size = canEat.size(); i < size; i++) {
			int fishX = canEat.get(i)[0]; // 목표로 하는 물고기의 x 좌표
			int fishY = canEat.get(i)[1]; // 목표로 하는 물고기의 y 좌표
			if (map[fishX][fishY] >= bsSize)
				continue;
//			목표로 하는 물고기의 distance 배열 완성
			int BabySharktoFish = distance[fishX][fishY];

//			result에 값 담기
			if (BabySharktoFish != -1 && BabySharktoFish < resultD) {
				resultD = BabySharktoFish;
				resultIdx = i;
				resultX = fishX;
				resultY = fishY;
			}
		}

		if (resultIdx != -1) {
			canEat.remove(resultIdx);
			int result[] = { resultX, resultY, resultD };
			return result;
		} else {
			return null;
		}
	}
}
