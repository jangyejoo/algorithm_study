package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_6808_규영이와인영이의카드게임 {

	static int win_K, win_I;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] cards_K = new int[9];
			int[] cards_I = new int[9];
			boolean[] isSelected = new boolean[19];
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int j = 0; j < 9; j++) {
				cards_K[j] = Integer.parseInt(st.nextToken());
				isSelected[cards_K[j]] = true;
			}
			for (int j = 1, idx = 0; j <= 18; j++) {
				if (!isSelected[j])
					cards_I[idx++] = j;
			}
			isSelected = new boolean[19];
			win_K = 0;
			win_I = 0;
			shuffle(cards_K, cards_I, isSelected, 0, 0, 0);
			sb.append("#").append(tc).append(" ").append(win_K).append(" ").append(win_I).append("\n");
		}
		System.out.println(sb);

	}

	private static void shuffle(int[] K, int[] I, boolean[] isSelected, int cnt, int score_K, int score_I) {
		if (cnt == 9) {
			// 승패
			if (score_K > score_I)
				win_K++;
			if (score_K < score_I)
				win_I++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (isSelected[I[i]])
				continue;
			isSelected[I[i]] = true;

			if (I[i] > K[cnt]) {
				shuffle(K, I, isSelected, cnt + 1, score_K, score_I + I[i] + K[cnt]);
			} else if (I[i] < K[cnt]) {
				shuffle(K, I, isSelected, cnt + 1, score_K + I[i] + K[cnt], score_I);
			} else {
				shuffle(K, I, isSelected, cnt + 1, score_K, score_I);
			}
			isSelected[I[i]] = false;
		}

	}

}
