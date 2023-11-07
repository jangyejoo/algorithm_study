package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		int max = 0;
		int[] T = new int[n];
		for (int i = 0; i < n; i++) {
			T[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, T[i]);
		}

		// init done

		Arrays.sort(T);

		long ans = m * max;

		long left = 0;
		long right = m * max;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for (long item : T) {
				long cnt = mid / item;
				if (sum >= m)
					break;
				sum += cnt;
			}

			if (sum >= m) {
				right = mid - 1;
				ans = Math.min(ans, mid);
			} else {
				left = mid + 1;
			}

		}

		System.out.println(ans);

	}

}
