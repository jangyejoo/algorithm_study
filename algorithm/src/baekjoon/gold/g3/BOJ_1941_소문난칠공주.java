package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941_소문난칠공주 {

	static int ans = 0;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[] numbers = new int[7];
	static char[][] map = new char[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			String row = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = row.charAt(j);
			}
		}

//		init done

		combination(0, 0);

		System.out.println(ans);

	}

	private static void combination(int start, int cnt) {
		if (cnt == 7) {
			boolean[][] visited = new boolean[5][5];

			for (int i = 0; i < 7; i++) {
				int x = numbers[i] / 5;
				int y = numbers[i] % 5;
				visited[x][y] = true;
			}

//			다 이어져있는지 검사
			int size = 1;

			boolean[][] isChecked = new boolean[5][5];
			isChecked[numbers[0] / 5][numbers[0] % 5] = true;

			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { numbers[0] / 5, numbers[0] % 5 });

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];

					if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
						continue;

					if (!visited[nx][ny])
						continue;

					if (isChecked[nx][ny])
						continue;

					size++;
					isChecked[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}

//			이어지지 않은 부분이 있음
			if (size != 7)
				return;

			int sCnt = 0;
			for (int i = 0; i < 7; i++) {
				int x = numbers[i] / 5;
				int y = numbers[i] % 5;

				if (map[x][y] == 'S')
					sCnt++;
			}

			if (sCnt >= 4)
				ans++;

			return;
		}

		for (int i = start; i < 25; i++) {
			numbers[cnt] = i;
			combination(i + 1, cnt + 1);
		}
	}

}
