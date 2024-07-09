package baekjoon.gold.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

//		보석을 무게가 작은 순으로 정렬
		PriorityQueue<int[]> jewels = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			jewels.offer(new int[] { w, v });
		}

//		가방의 최대 무게가 작은 순으로 정렬
		PriorityQueue<Integer> bags = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}

		});

		for (int i = 1; i <= k; i++) {
			bags.offer(Integer.parseInt(br.readLine()));
		}

//		init done

		long ans = 0;

//		담을 수 있는 가벼운 보석들
		PriorityQueue<Integer> lightJewels = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

//		greedy -> 작은 가방부터 탐색해서 이 가방에 들어갈 수 있는 최대 가치인 보석 찾기
		while (!bags.isEmpty()) {
			int bag = bags.poll();

//			담을 수 있는 보석 확보
			while (!jewels.isEmpty()) {
				int[] jewel = jewels.peek();
				int jewelW = jewel[0];
				int jewelV = jewel[1];

//				이 보석부터는 무거워서 넣을 수가 없음
				if (bag < jewelW)
					break;

				jewels.poll();
				lightJewels.offer(jewelV);
			}

//			가방에 넣을 수 있는 보석이 하나도 없음
			if (lightJewels.isEmpty())
				continue;

//			넣을 수 있는 가벼운 보석 중 가장 가치가 큰 보석 챙김
			ans += lightJewels.poll();

		}

		System.out.println(ans);

	}

}