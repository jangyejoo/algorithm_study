package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11062_카드게임 {

	static int[][] dp;
	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine().trim());

			list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

//			init done

			dp = new int[n][n];

			play(0, n - 1, 0);

			sb.append(dp[0][n - 1]).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int play(int start, int end, int turn) {
		if (start > end)
			return 0;

		if (dp[start][end] != 0)
			return dp[start][end];

		if (turn % 2 == 0) {
//			근우 차례
			return dp[start][end] = Math.max(list.get(start) + play(start + 1, end, turn + 1),
					list.get(end) + play(start, end - 1, turn + 1));
		}

		return dp[start][end] = Math.min(play(start + 1, end, turn + 1), play(start, end - 1, turn + 1));

	}

}
