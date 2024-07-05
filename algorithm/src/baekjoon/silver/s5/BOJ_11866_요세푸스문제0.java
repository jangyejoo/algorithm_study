package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		// init done

		sb.append("<");
		int index = k - 1;
		while (true) {
			if (list.size() == 1) {
				sb.append(list.get(0)).append(">");
				break;
			}
			sb.append(list.get(index)).append(", ");
			list.remove(index);
			index += k - 1;
			index %= list.size();
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
