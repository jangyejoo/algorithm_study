package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1911_흙길보수하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		List<int[]> holes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			holes.add(new int[] { start, end });
		}

		// init done

		Collections.sort(holes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int cnt = 0;
		int curPos = 0;
		int plankIdx = 0;
		while (plankIdx < n) {
			int[] hole = holes.get(plankIdx);

			if (curPos >= hole[0] && curPos < hole[1]) {
				cnt++;
				curPos += l;
			} else if (curPos < hole[0]) {
				curPos = holes.get(plankIdx)[0];
			} else {
				plankIdx++;
			}
		}

		System.out.println(cnt);

	}

}
