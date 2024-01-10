package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1264_모음의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String row = br.readLine().toLowerCase();

			if ("#".equals(row))
				break;

			int cnt = 0;
			for (int i = 0, size = row.length(); i < size; i++) {
				char c = row.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					cnt++;
			}
			sb.append(cnt).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
