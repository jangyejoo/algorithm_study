package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1263_시간관리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<int[]> works = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			works.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// init done

		Collections.sort(works, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[1] == o1[1])
					return o1[0] - o2[0];
				return o2[1] - o1[1];
			}

		});

		int time = 1000000;
		for (int[] work : works) {
			time = Math.min(time, work[1]) - work[0];
		}

		System.out.println(time < 0 ? -1 : time);

	}

}
