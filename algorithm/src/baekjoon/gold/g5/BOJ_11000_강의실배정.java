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

public class BOJ_11000_강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		List<int[]> lesson = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			lesson.add(new int[] { s, t });
		}

		// init done

		// 수업 시작하는 시간 오름차순
		Collections.sort(lesson, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		// 수업 끝나는 시간 오름차순
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}

		});

		pq.add(lesson.get(0)[1]);
		for (int i = 1; i < n; i++) {
			int start = lesson.get(i)[0];
			int end = lesson.get(i)[1];

			if (pq.peek() <= start) {
				pq.poll();
			}
			pq.add(end);
		}

		System.out.println(pq.size());

	}

}
