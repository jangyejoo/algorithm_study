package baekjoon.silver.s4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<String> list1 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list1.add(br.readLine());
		}

		List<String> list2 = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			list2.add(br.readLine());
		}

		// init done

		Collections.sort(list1);
		Collections.sort(list2);

		List<String> ans;
		if (n > m) {
			ans = compare(list1, list2, n, m);
		} else {
			ans = compare(list2, list1, m, n);
		}

		sb.append(ans.size()).append("\n");
		for (String string : ans) {
			sb.append(string).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static List<String> compare(List<String> list1, List<String> list2, int n, int m) {
		int compareIndex = 0;
		int index = 0;
		List<String> ans = new ArrayList<>();

		while (index < m && compareIndex < n) {
			String compare = list1.get(compareIndex);
			String name = list2.get(index);
			if (name.equals(compare)) {
				ans.add(name);
				compareIndex++;
				index++;
				continue;
			}
			if (name.compareTo(compare) < 0) {
				index++;
			} else {
				compareIndex++;
			}
		}

		return ans;
	}

}
