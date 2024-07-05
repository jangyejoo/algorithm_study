package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2141_우체국 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long total = 0;
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int pos = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());

			total += people;
			list.add(new int[] { pos, people });
		}

		// init done

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		long mid = (total + 1) / 2;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += list.get(i)[1];

			if (sum >= mid) {
				System.out.println(list.get(i)[0]);
				return;
			}
		}

	}

}
