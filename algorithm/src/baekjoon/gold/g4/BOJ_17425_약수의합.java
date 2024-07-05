package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17425_약수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		long[] g = new long[1000001];
		for (int i = 1; i <= 1000000; i++) {
			for (int j = 1; i * j <= 1000000; j++) {
				g[i * j] += i;
			}
			g[i] += g[i - 1];
		}

		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(g[n]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
