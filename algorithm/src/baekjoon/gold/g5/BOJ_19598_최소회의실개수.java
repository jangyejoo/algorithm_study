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

public class BOJ_19598_최소회의실개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<int[]> lectures = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			lectures.add(new int[] { start, end });
		}

		// init done

		// 강의 시작 시간 오름차순 정렬
		Collections.sort(lectures, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		// 강의 끝나는 시간 오름차순 정렬
		PriorityQueue<Integer> rooms = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}

		});

		rooms.offer(0);

		for (int i = 0; i < n; i++) {
			int roomEndTime = rooms.peek();

			int[] lecture = lectures.get(i);
			int start = lecture[0];
			int end = lecture[1];

			if (roomEndTime <= start) {
				rooms.poll();
			}
			rooms.offer(end);
		}

		System.out.println(rooms.size());

	}

}
