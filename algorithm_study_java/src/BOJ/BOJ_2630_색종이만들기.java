package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {

	static int[][] input;
	static int[] paper = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		input = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// init done

		cut(0, 0, n);

		System.out.println(paper[0]);
		System.out.println(paper[1]);

	}

	private static void cut(int x, int y, int size) {
		int color = input[x][y];

		boolean isPaper = true;
		B: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (color != input[i][j]) {
					isPaper = false;
					break B;
				}
			}
		}

		if (isPaper) {
			paper[color]++;
			return;
		} else {
			int nextSize = size / 2;
			cut(x, y, nextSize);
			cut(x + nextSize, y, nextSize);
			cut(x, y + nextSize, nextSize);
			cut(x + nextSize, y + nextSize, nextSize);
		}
	}

}
