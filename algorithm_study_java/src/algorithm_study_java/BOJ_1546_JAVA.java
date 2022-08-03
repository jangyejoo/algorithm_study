package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1546_JAVA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		double[] score = new double[N];
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int max = 0;
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if (max < score[i])
				max = (int) score[i];
		}
		double sum = 0;
		for (int i = 0; i < N; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		System.out.println(sum / (double) N);
	}

}
