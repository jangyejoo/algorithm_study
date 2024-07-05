package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1461_도서관 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Integer> negative = new ArrayList<>();
		List<Integer> positive = new ArrayList<>();
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > 0)
				positive.add(num);
			else
				negative.add(num * -1);
		}

		// init done

		Collections.sort(negative, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		Collections.sort(positive, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		int hap = 0;

		int idx = m;
		while (true) {
			if (idx < negative.size())
				hap += negative.get(idx) * 2;
			if (idx < positive.size())
				hap += positive.get(idx) * 2;
			if (idx >= negative.size() && idx >= positive.size())
				break;
			idx += m;
		}

		if (negative.size() == 0) {
			hap += positive.get(0);
			System.out.println(hap);
			return;
		}

		if (positive.size() == 0) {
			hap += negative.get(0);
			System.out.println(hap);
			return;
		}

		if (negative.get(0) > positive.get(0)) {
			hap += negative.get(0);
			hap += positive.get(0) * 2;
		} else {
			hap += negative.get(0) * 2;
			hap += positive.get(0);
		}

		System.out.println(hap);

	}

}
