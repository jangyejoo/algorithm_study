package SWEA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_No2_헌터 {

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int[][] hunt = new int[n + 1][5];
			int size = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					int number = Integer.parseInt(st.nextToken());
					map[i][j] = number;
					if (number > 0) {
//						몬스터일 때
						hunt[number][0] = i;
						hunt[number][1] = j;
						hunt[number][4] = -1;
						size++;
					} else if (number < 0) {
//						고객일 때
						hunt[number * -1][2] = i;
						hunt[number * -1][3] = j;
					}
				}
			}

			int[] numbers = new int[size * 2];
			ans = Integer.MAX_VALUE;
			boolean[][] visited = new boolean[size + 1][2];
			shuffle(visited, numbers, hunt, size, 0, 0, 0, 0);

			sb.append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void shuffle(boolean[][] visited, int[] numbers, int[][] hunt, int size, int cnt, int total,
			int curX, int curY) {
		if (total > ans)
			return;

		if (size * 2 == cnt) {
			ans = total;
			return;
		}

		for (int i = size; i >= size * -1; i--) {
			if (i == 0)
				continue;
			if (i > 0 && visited[i][0])
				continue;
			if (i < 0 && visited[i * -1][1])
				continue;
			if (i < 0 && hunt[i * -1][4] == -1)
				continue;
			if (i > 0) {
				hunt[i][4] = 1;
				visited[i][0] = true;
				numbers[cnt] = i;
				int nx = hunt[i][0];
				int ny = hunt[i][1];
				shuffle(visited, numbers, hunt, size, cnt + 1, total + dist(curX, curY, nx, ny), nx, ny);
				hunt[i][4] = -1;
				visited[i][0] = false;
			}
			if (i < 0) {
				visited[i * -1][1] = true;
				numbers[cnt] = i;
				int nx = hunt[i * -1][2];
				int ny = hunt[i * -1][3];
				shuffle(visited, numbers, hunt, size, cnt + 1, total + dist(curX, curY, nx, ny), nx, ny);
				visited[i * -1][1] = false;
			}
		}

	}

	private static int dist(int curX, int curY, int x, int y) {
		return Math.abs(curX - x) + Math.abs(curY - y);
	}

}
