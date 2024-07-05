package baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] students = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int b = Integer.parseInt(st.nextToken()); // 총감독관 한명이 감시할 수 있는 학생 수
		int c = Integer.parseInt(st.nextToken()); // 부감독관 한명이 감시할 수 있는 학생 수

//		init done

		long ans = n;
		for (int i = 0; i < n; i++) {
			int mid = students[i] - b > 0 ? students[i] - b : 0;
			ans += (long) Math.ceil(mid / (double) c);
		}

		System.out.println(ans);
	}
}
