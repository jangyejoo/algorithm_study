package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2212_센서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		if (n <= k) {
			System.out.println(0);
			return;
		}

		int[] sensors = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		Arrays.sort(sensors);

		// 센서와 센서 사이 거리 저장
		int hap = 0;
		List<Integer> gap = new LinkedList<>();
		for (int i = 1; i < n; i++) {
			int number = sensors[i] - sensors[i - 1];
			hap += number;
			gap.add(number);
		}

		// 내림차순 정렬
		Collections.sort(gap, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		// k - 1 개만큼 구간 건너뛰기
		for (int i = 0; i < k - 1; i++) {
			hap -= gap.get(i);
		}

		System.out.println(hap);

	}

}
