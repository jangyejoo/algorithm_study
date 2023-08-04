package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 2][n + 2];

		// 벽
		for (int i = 0; i < n + 2; i++) {
			if (i == 0 || i == n + 1)
				Arrays.fill(map[i], 1);
			map[i][0] = 1;
			map[i][n + 1] = 1;
		}

		// 뱀
		map[1][1] = 3;

		// 사과
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine().trim());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}

		int ans = 0;
		int direction = 0;

		Deque<int[]> snake = new LinkedList<>();
		snake.add(new int[] { 1, 1 });

		int l = Integer.parseInt(br.readLine());
		char[] input = new char[10001];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			input[X] = C;
		}

		while (true) {
			char turn = input[++ans];
			int[] head = snake.getFirst();
			int nx = head[0] + dx[direction];
			int ny = head[1] + dy[direction];
			if (map[nx][ny] == 1 || map[nx][ny] == 3) {
				System.out.println(ans);
				return;
			}

			snake.offerFirst(new int[] { nx, ny });
			if (map[nx][ny] != 2) {
				// 사과가 없다면
				int[] tail = snake.pollLast();
				map[tail[0]][tail[1]] = 0;
			}
			map[nx][ny] = 3;

			if (turn == 'L') {
				// 왼쪽
				direction = (direction + 1) % 4;
			} else if (turn == 'D') {
				// 오른쪽
				direction = direction == 0 ? 3 : direction - 1;
			}

		}

	}

}
