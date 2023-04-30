package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[] numbers = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

//			init done

//			DP
//			int ans = -1;
//
//			int[] LIS = new int[n];
//			for (int i = 0; i < n; i++) {
//				LIS[i] = 1;
//				for (int j = 0; j < n - 1; j++) {
//					if (numbers[i] > numbers[j] && LIS[i] < LIS[j] + 1)
//						LIS[i] = LIS[j] + 1;
//				}
//				if (ans < LIS[i])
//					ans = LIS[i];
//			}
//			sb.append(ans).append("\n");

			
//			이진탐색
			int[] C = new int[n];
			int size = 0;

			for (int i = 0; i < n; i++) {
				int pos = Arrays.binarySearch(C, 0, size, numbers[i]);
				if (pos >= 0)
					continue;
				int insertPos = Math.abs(pos) - 1;
				C[insertPos] = numbers[i];
				if (insertPos == size)
					size++;
			}

			sb.append(size).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
