package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int m = Integer.parseInt(br.readLine());
		boolean[] s = new boolean[21];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String command = st.nextToken();
			int number = 0;

			switch (command) {
			case "add":
				number = Integer.parseInt(st.nextToken());
				s[number] = true;
				break;
			case "remove":
				number = Integer.parseInt(st.nextToken());
				s[number] = false;
				break;
			case "check":
				number = Integer.parseInt(st.nextToken());
				if (s[number])
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "toggle":
				number = Integer.parseInt(st.nextToken());
				if (s[number])
					s[number] = false;
				else
					s[number] = true;
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					s[j] = true;
				}
				break;
			case "empty":
				for (int j = 1; j <= 20; j++) {
					s[j] = false;
				}
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
