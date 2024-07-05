package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2981_검문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		// init done

		// 정렬
		Arrays.sort(input);

		int min = Integer.MAX_VALUE;
		int[] gap = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			gap[i] = Math.abs(input[i] - input[i + 1]);
			min = Math.min(min, gap[i]);
		}

		// gap들의 공약수 구하기
		C: for (int i = 2; i <= min; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (gap[j] % i != 0) {
					continue C;
				}
			}
			sb.append(i).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
