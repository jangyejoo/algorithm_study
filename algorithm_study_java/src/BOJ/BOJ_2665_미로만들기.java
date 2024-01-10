package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2665_미로만들기 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}

		// init done

		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		dp[0][0] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curDp = dp[cur[0]][cur[1]];

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if (dp[nx][ny] != -1 && dp[nx][ny] <= curDp)
					continue;

				if (map[nx][ny] == 1) {
					// 흰 방일 때
					dp[nx][ny] = curDp;
				} else {
					// 검은 방일 때
					dp[nx][ny] = curDp + 1;
				}

				q.offer(new int[] { nx, ny });

			}
		}

		System.out.println(dp[n - 1][n - 1]);

	}

	private static void print(int[][] map, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}

}
