package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19942_다이어트 {

	static int n;
	static int[][] input;
	static boolean[] ansArray;
	static boolean[] selected;
	static int[] min = new int[4];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 4; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}

		input = new int[n][5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 5; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		selected = new boolean[n];

		play(0, 0, 0, 0, 0, 0);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
			for (int i = 0; i < n; i++) {
				if (ansArray[i])
					System.out.print((i + 1) + " ");
			}
		}

	}

	private static void play(int idx, int p, int f, int s, int v, int c) {
		if (p >= min[0] && f >= min[1] && s >= min[2] && v >= min[3]) {
			if (c < ans) {
				ans = c;
				ansArray = new boolean[n];
				for (int i = 0; i < n; i++) {
					ansArray[i] = selected[i];
				}
			}
			return;
		}

		if (idx == n)
			return;

		selected[idx] = true;
		play(idx + 1, p + input[idx][0], f + input[idx][1], s + input[idx][2], v + input[idx][3], c + input[idx][4]);

		selected[idx] = false;
		play(idx + 1, p, f, s, v, c);

	}

}
