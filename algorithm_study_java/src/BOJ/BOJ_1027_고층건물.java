package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027_고층건물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] height = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		int max = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;

				int start = Math.min(i, j) + 1;
				int end = Math.max(i, j) - 1;

				int high = -1;
				int low = -1;
				if (height[i] < height[j]) {
					high = j;
					low = i;
				} else {
					high = i;
					low = j;
				}

				boolean isPossible = true;
				double temp = (double) (height[high] - height[low]) / Math.abs(i - j);
				for (int mid = start; mid <= end; mid++) {
					double maxHeight = temp * Math.abs(low - mid) + height[low];
					if (height[mid] >= maxHeight) {
						isPossible = false;
						break;
					}
				}

				if (isPossible) {
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}

}
