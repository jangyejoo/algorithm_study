package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int section = (int) Math.pow(2, 2 * n - 2);
		int half = (int) Math.pow(2, n - 1);
		int end = half * 2;

		while (section > 0) {
			half = (int) Math.sqrt(section);
			end = half * 2;
//			구간을 4개로 나눔
			if ((r >= 0 && r < half) && (c >= 0 && c < half)) {
				// 1 구간
				section /= 4;
				continue;
			}
			if ((r >= 0 && r < half) && (c >= half && c < end)) {
				// 2 구간
				ans += section;
				c -= half;
				section /= 4;
				continue;
			}
			if ((r >= half && r < end) && (c >= 0 && c < half)) {
				// 3 구간
				ans += section * 2;
				r -= half;
				section /= 4;
				continue;
			}
			if ((r >= half && r < end) && (c >= half && c < end)) {
				// 4 구간
				ans += section * 3;
				r -= half;
				c -= half;
				section /= 4;
				continue;
			}
		}
		System.out.println(ans);

	}
}
