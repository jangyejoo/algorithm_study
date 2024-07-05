package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17430_가로등 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		C: for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			Map<Integer, List<Integer>> map = new HashMap<>();
			int standard_x = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (standard_x == 0) {
					standard_x = x;
				}

				List<Integer> list;
				if (!map.containsKey(x)) {
					list = new ArrayList<>();
				} else {
					list = map.get(x);
				}
				list.add(y);
				map.put(x, list);
			}

			List<Integer> standard = map.get(standard_x);
			Collections.sort(standard);
			for (Integer key : map.keySet()) {
				List<Integer> cur = map.get(key);
				Collections.sort(cur);
				if (!standard.toString().equals(cur.toString())) {
					sb.append("NOT BALANCED").append("\n");
					continue C;
				}
			}

			sb.append("BALANCED").append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
