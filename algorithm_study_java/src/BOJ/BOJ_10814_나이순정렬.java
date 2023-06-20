package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		StringBuilder[] p = new StringBuilder[202];
		for (int i = 0; i < p.length; i++) {
			p[i] = new StringBuilder();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			p[age].append(age).append(" ").append(name).append("\n");
		}

		StringBuilder sb = new StringBuilder();
		for (StringBuilder stringBuilder : p) {
			sb.append(stringBuilder);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
