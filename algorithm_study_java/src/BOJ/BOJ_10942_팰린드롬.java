package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n + 1];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;

			if (i + 1 <= n && numbers[i] == numbers[i + 1])
				dp[i][i + 1] = true;
		}

		for (int size = 2; size < n; size++) {
			for (int i = 1; i + size <= n; i++) {
				if (numbers[i] == numbers[i + size] && dp[i + 1][i + size - 1])
					dp[i][i + size] = true;
			}
		}

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (dp[start][end])
				sb.append("1\n");
			else
				sb.append("0\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
