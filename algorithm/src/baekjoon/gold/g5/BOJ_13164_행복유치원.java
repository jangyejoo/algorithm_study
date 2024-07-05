package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13164_행복유치원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] students = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}

		});

		for (int i = 1; i < n; i++) {
			pq.offer(new int[] { i, students[i] - students[i - 1] });
		}

		List<Integer> startPoint = new ArrayList<>();
		for (int i = 0; i < k - 1; i++) {
			int[] cur = pq.poll();

			startPoint.add(cur[0]);
		}

		Collections.sort(startPoint, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}

		});

		int ans = 0;
		int start = 0;
		for (int i = 0, size = startPoint.size(); i < size; i++) {
			int nextStart = startPoint.get(i);

			ans += students[nextStart - 1] - students[start];
			start = nextStart;
		}
		ans += students[n - 1] - students[start];

		System.out.println(ans);

	}

}
