package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<int[]> input = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int kg = Integer.parseInt(st.nextToken());
			int cm = Integer.parseInt(st.nextToken());
			input.add(new int[] { kg, cm });
		}

		// init done

		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n; j++) {
				if (input.get(i)[0] < input.get(j)[0] && input.get(i)[1] < input.get(j)[1]) {
					cnt++;
				}
			}
			sb.append(cnt).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
