package baekjoon.bronze.b4;

import java.io.*;

public class BOJ_11720_숫자의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		char [] numbers = br.readLine().toCharArray();
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i] -'0';
		}
		System.out.println(sum);
	}
	
}
