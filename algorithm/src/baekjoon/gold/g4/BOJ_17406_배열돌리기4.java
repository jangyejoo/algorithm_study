package baekjoon.gold.g4;

import java.io.*;
import java.util.*;

public class BOJ_17406_배열돌리기4 {

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };
	static int k, ans, n, m;
	static List<int[]> commandList;
	static int[][] b, init;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String smk = br.readLine();
		StringTokenizer st = new StringTokenizer(smk);

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = new int[n + 1][m + 1];
		init = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String r = br.readLine();
			st = new StringTokenizer(r);
			for (int j = 1; j <= m; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
				init[i][j] = b[i][j];
			}
		}

		commandList = new ArrayList<int[]>();
		ans = Integer.MAX_VALUE;
		boolean[] isSelected = new boolean[k];
		int[] numbers = new int[k];
		// 연산 개수만큼 돌리기
		for (int K = 0; K < k; K++) {
			String command = br.readLine();
			st = new StringTokenizer(command);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			int[] oneCommand = new int[3];
			oneCommand[0] = r;
			oneCommand[1] = c;
			oneCommand[2] = s;

			commandList.add(oneCommand);

		}

		shuffle(0, numbers, isSelected);

		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void shuffle(int cnt, int[] numbers, boolean[] isSelected) {
		if (cnt == k) {
			for (int i = 0; i < k; i++) {
				int r = commandList.get(numbers[i])[0];
				int c = commandList.get(numbers[i])[1];
				int s = commandList.get(numbers[i])[2];
				rotate(b, r, c, s);

			}
			int calc = calc(b, n, m);
			ans = ans > calc ? calc : ans;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					b[i][j] = init[i][j];
				}
			}
			return;
		}
		for (int i = 0; i < k; i++) {
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			shuffle(cnt + 1, numbers, isSelected);
			isSelected[i] = false;
		}
	}

	private static int calc(int[][] b, int n, int m) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= m; j++) {
				sum += b[i][j];
			}
			min = min > sum ? sum : min;
		}
		return min;
	}

	private static void rotate(int[][] b, int r, int c, int s) {
		for (int i = 1; i <= s; i++) {
			int x = r - i;
			int y = c - i;
			int d = 0;
			int tmp = b[x][y];

			while (true) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < r - i || ny < c - i || nx > r + i || ny > c + i) {
					d = (d + 1) % 4;
				} else {
					b[x][y] = b[nx][ny];
					x = nx;
					y = ny;
					if (x == r - i && y == c - i)
						break;
				}

			}
			b[x][y + 1] = tmp;
		}
	}
}
