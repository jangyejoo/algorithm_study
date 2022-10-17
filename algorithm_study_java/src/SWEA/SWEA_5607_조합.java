package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long[] factorial = new long[1000001];
		factorial[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			factorial[i] = (i * factorial[i - 1]) % 1234567891;
		}

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			sb.append(
					(factorial[n] * calc((factorial[r] * factorial[n - r]) % 1234567891, 1234567891 - 2)) % 1234567891)
					.append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static long calc(long a, int b) {
		if (b == 0)
			return 1;
		long half = calc(a, b / 2);
		long result = (half * half) % 1234567891;
		if (b % 2 == 0)
			return result;
		else
			return (result * a) % 1234567891;
	}

}
