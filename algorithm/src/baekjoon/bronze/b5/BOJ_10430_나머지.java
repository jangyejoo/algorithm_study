package baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10430_나머지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// init done

		sb.append((a + b) % c).append("\n");
		sb.append(((a % c) + (b % c)) % c).append("\n");
		sb.append((a * b) % c).append("\n");
		sb.append(((a % c) * (b % c)) % c).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
