package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_14395_4연산 {

	static class Item {
		long num;
		StringBuilder mark = new StringBuilder();

		public Item(long num) {
			this.num = num;
		}

		public Item(long num, String mark) {
			this.num = num;
			this.mark.append(mark);
		}

		public void addMark(String mark) {
			this.mark.append(mark);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		long s = Long.parseLong(st.nextToken());
		long t = Long.parseLong(st.nextToken());

//		init done

		if (s == t) {
			System.out.println(0);
			return;
		}

//		t가 0이나 1이면 무조건 한 번에 됨
		if (t == 0) {
			System.out.println("-");
			return;
		}

		if (t == 1) {
			System.out.println("/");
			return;
		}

		Queue<Item> q = new LinkedList<>();
		q.offer(new Item(s));

//		값의 범위가 10^9 이기 때문에 방문 처리 set 이용
		Set<Long> set = new HashSet();

//		할 수 있는 연산은 1, 2s, s^2
		while (!q.isEmpty()) {
			Item cur = q.poll();

			long num = cur.num;

			if (set.contains(num))
				continue;

//			방문 표시
			set.add(num);

			String nextMark = cur.mark.toString();

//			정답
			if (num * num == t) {
				System.out.println(nextMark + "*");
				return;
			}

			if (num * 2 == t) {
				System.out.println(nextMark + "+");
				return;
			}

//			next item
			if (num * num < t) {
				q.offer(new Item(num * num, nextMark + "*"));
			}

			if (num * 2 < t) {
				q.offer(new Item(num * 2, nextMark + "+"));
			}

			q.offer(new Item(1, nextMark + "/"));
		}

		System.out.println(-1);

	}

}
