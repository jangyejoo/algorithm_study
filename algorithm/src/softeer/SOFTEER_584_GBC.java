package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SOFTEER_584_GBC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] limit = new int[n + 1][2];
		int[][] test = new int[m + 1][2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			limit[i][0] = limit[i - 1][0] + Integer.parseInt(st.nextToken());
			limit[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			test[i][0] = test[i - 1][0] + Integer.parseInt(st.nextToken());
			test[i][1] = Integer.parseInt(st.nextToken());
		}

		// init done

		int ans = 0;
		int limitSectionIndex = 1;
		int testSectionIndex = 1;
		for (int cur = 1; cur <= 100; cur++) {
			if (cur > limit[limitSectionIndex][0])
				limitSectionIndex++;
			if (cur > test[testSectionIndex][0])
				testSectionIndex++;

			if (test[testSectionIndex][1] > limit[limitSectionIndex][1])
				ans = Math.max(ans, test[testSectionIndex][1] - limit[limitSectionIndex][1]);
		}

		System.out.println(ans);

	}

}
