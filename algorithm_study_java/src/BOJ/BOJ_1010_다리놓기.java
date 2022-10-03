package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			String nm = br.readLine();
			StringTokenizer st = new StringTokenizer(nm);
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int rArr[] = new int[n + 1];
			int nrArr[] = new int[n + 1];
			
			check(rArr, 1, r);
			check(nrArr, n - r + 1, n);
			
			for (int i = 1; i <= n; i++) {
				if (rArr[i] != 0)
					nrArr[i] -= rArr[i];
			}

			int ans = 1;
			for (int i = 1; i <= n; i++) {
				if (nrArr[i] >= 1) {
					for (int j = 0; j < nrArr[i]; j++) {
						ans *= i;
					}
				}
			}

			sb.append(ans).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void check(int[] arr, int start, int end) {
		for (int i = start; i <= end; i++) {
			check2(arr, i);
		}
	}

	private static void check2(int[] arr, int i) {
		while (true) {
			if (i == 1)
				return;
			if (i % 2 == 0) {
				arr[2]++;
				i /= 2;
			}
			if (i % 3 == 0) {
				arr[3]++;
				i /= 3;
			}
			if (i % 5 == 0) {
				arr[5]++;
				i /= 5;
			}
			if (i % 7 == 0) {
				arr[7]++;
				i /= 7;
			}
			if (i % 11 == 0) {
				arr[11]++;
				i /= 11;
			}
			if (i % 13 == 0) {
				arr[13]++;
				i /= 13;
			}
			if (i % 17 == 0) {
				arr[17]++;
				i /= 17;
			}
			if (i % 19 == 0) {
				arr[19]++;
				i /= 19;
			}
			if (i % 23 == 0) {
				arr[23]++;
				i /= 23;
			}
			if (i % 29 == 0) {
				arr[29]++;
				i /= 29;
			}

		}

	}

}
