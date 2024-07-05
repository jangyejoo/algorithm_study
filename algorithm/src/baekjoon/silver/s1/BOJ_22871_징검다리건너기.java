package baekjoon.silver.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22871_징검다리건너기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] rocks = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			rocks[i] = Integer.parseInt(st.nextToken());
		}

		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;

		// init done

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				long power = (long) (i - j) * (1 + Math.abs(rocks[i] - rocks[j]));
				dist[i] = Math.min(dist[i], Math.max(power, dist[j]));
			}
		}

		System.out.println(dist[n - 1]);
	}

}
