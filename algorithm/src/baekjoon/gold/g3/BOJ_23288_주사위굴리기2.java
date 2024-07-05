package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23288_주사위굴리기2 {

	static int n, m;
	static int[][] map;
	static int[][] point;
	static int[] dice = new int[7];

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

//		위 위옆 오옆 왼옆 아옆 바닥 순
		for (int i = 1; i <= 6; i++) {
			dice[i] = i;
		}

//		포인트
		point = new int[n + 1][m + 1];

		int x = 1;
		int y = 1;
		int ans = 0;

//		dice direction
		int dd = 0;
		for (int i = 0; i < k; i++) {
//			주사위 이동
			int nx = x + dx[dd];
			int ny = y + dy[dd];

//			만약, 지도 밖을 벗어나면 이동 방향을 반대로 함
			if (nx < 1 || ny < 1 || nx > n || ny > m) {
				dd += 2;
				dd %= 4;

				nx = x + dx[dd];
				ny = y + dy[dd];
			}

//			전개도 변화
			changeDice(dd);

//			얻을 수 있는 포인트
			if (point[nx][ny] == 0) {
				earnPoint(nx, ny);
			}

			ans += point[nx][ny];

//			이동 방향 결정
			int A = dice[6];
			int B = map[nx][ny];
			if (A > B) {
				if (dd == 3)
					dd = 0;
				else
					dd++;
			} else if (A < B) {
				if (dd == 0)
					dd = 3;
				else
					dd--;
			}

//			좌표 갱신
			x = nx;
			y = ny;
		}

		System.out.println(ans);

	}

	private static void earnPoint(int x, int y) {
		int cnt = 1;
		int num = map[x][y];

		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		boolean[][] visited = new boolean[n + 1][m + 1];

		visited[x][y] = true;
		q.offer(new int[] { x, y });
		list.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 1 || ny < 1 || nx > n || ny > m)
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] != num)
					continue;

				cnt++;
				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
				list.add(new int[] { nx, ny });
			}
		}

		for (int[] pos : list) {
			point[pos[0]][pos[1]] = cnt * num;
		}
	}

	private static void changeDice(int d) {
		int[] temp = new int[7];

		switch (d) {
//		동쪽
		case 0:
			temp[1] = dice[4];
			temp[2] = dice[2];
			temp[3] = dice[1];
			temp[4] = dice[6];
			temp[5] = dice[5];
			temp[6] = dice[3];
			break;
//		남쪽
		case 1:
			temp[1] = dice[2];
			temp[2] = dice[6];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[1];
			temp[6] = dice[5];
			break;
//		서쪽
		case 2:
			temp[1] = dice[3];
			temp[2] = dice[2];
			temp[3] = dice[6];
			temp[4] = dice[1];
			temp[5] = dice[5];
			temp[6] = dice[4];
			break;
//		북쪽
		case 3:
			temp[1] = dice[5];
			temp[2] = dice[1];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[6];
			temp[6] = dice[2];
			break;
		}

		for (int i = 1; i <= 6; i++) {
			dice[i] = temp[i];
		}
	}

}
