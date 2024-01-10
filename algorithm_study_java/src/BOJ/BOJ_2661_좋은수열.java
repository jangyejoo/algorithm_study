package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_2661_좋은수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 가장 작은 좋은 수열 구하기
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int size1 = o1.length();
				int size2 = o2.length();
				return size2 - size1;
			}

		});

		pq.offer("1");
		pq.offer("2");
		pq.offer("3");

		while (true) {
			String item = pq.poll();
			int length = item.length();

			if (length == n) {
				System.out.println(item);
				return;
			}

			C2: for (int next = 1; next <= 3; next++) {
				String nextString = item + next;
				int nextLength = length + 1;

				// 좋은 수열인지 확인
				C1: for (int size = 1; size * 2 <= nextLength; size++) {
					int idx1 = nextLength - size;
					int idx2 = nextLength - size * 2;
					for (int j = 0; j < size; j++) {
						if (nextString.charAt(idx1) != nextString.charAt(idx2)) {
							// 다르면 좋은 수열일 가능성 아직 있음
							// 다음 사이즈로 검사
							continue C1;
						}
						idx1++;
						idx2++;
					}
					// 좋지 않은 수열임
					// 다음 넘버로 검사
					continue C2;
				}
				// 좋은 수열은 pq에 추가
				pq.offer(nextString);
			}

		}

	}

}
