package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5639_이진검색트리 {

	static StringBuilder sb = new StringBuilder();
	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		list = new ArrayList<>();
		while (true) {
			String input = br.readLine();
			if (input == null || input.length() == 0) {
				break;
			}
			list.add(Integer.parseInt(input));
		}

		// init done

		tree(0, list.size() - 1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void tree(int start, int end) {
		if (start == end) {
			sb.append(list.get(start)).append("\n");
			return;
		}

		int right = -1;
		for (int i = start + 1; i <= end; i++) {
			if (right == -1 && list.get(start) < list.get(i)) {
				right = i;
			}
		}

		if (right != -1) {
			if (start + 1 <= right - 1)
				tree(start + 1, right - 1);
		} else {
			tree(start + 1, end);
		}
		if (right != -1 && right <= end)
			tree(right, end);
		sb.append(list.get(start)).append("\n");
	}

}
