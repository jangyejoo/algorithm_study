package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		boolean[] input = new boolean[2000002];
		for (int i = 0; i < n; i++) {
			input[Integer.parseInt(br.readLine()) + 1000000] = true;
		}

		// init done

		int cnt = 0;
		int idx = 0;
		while (cnt < n) {
			if (input[idx]) {
				sb.append(idx - 1000000).append("\n");
				cnt++;
			}
			idx++;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
