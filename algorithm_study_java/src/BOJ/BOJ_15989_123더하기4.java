package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15989_123더하기4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] dp = new int[10001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= 10000; i++) {
//			무조건 1로만 만드는 경우 +1
			dp[i]++;

//			1,2로 만드는 경우
			dp[i] += Math.floor(i / 2);

//			1,2,3으로 만드는 경우
			dp[i] += dp[i - 3];
		}

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(dp[input]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
