package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1092_배 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] crane = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		int[] boxes = new int[m];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		PriorityQueue<int[]>[] pqList = new PriorityQueue[n];
		for (int i = 0; i < n; i++) {
			pqList[i] = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0] - o1[0];
				}

			});
		}

		Arrays.sort(crane);

		for (int i = 0; i < n; i++) {
			int capacity = crane[i];
			for (int j = 0; j < m; j++) {
				if (capacity >= boxes[j])
					pqList[i].offer(new int[] { boxes[j], j });
			}
		}

		boolean[] isLoaded = new boolean[m];

		int ans = 0;
		int cnt = 0;
		while (true) {
			boolean isPossible = false;
			for (int i = n - 1; i >= 0; i--) {
				while (!pqList[i].isEmpty()) {
					int[] cur = pqList[i].poll();

					if (isLoaded[cur[1]])
						continue;

					isPossible = true;
					isLoaded[cur[1]] = true;
					cnt++;
					break;
				}
			}

			if (!isPossible) {
				break;
			}
			ans++;
		}

		if (cnt == m)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

}
