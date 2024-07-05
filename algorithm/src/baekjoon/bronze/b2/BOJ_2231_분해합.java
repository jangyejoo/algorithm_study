package baekjoon.bronze.b2;

import java.io.*;

public class BOJ_2231_분해합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int number = i;
			int result = number;
			do {
				result += number % 10;
				number/=10;
			} while(number >= 1);
			if (result == n) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		
	}
	
}
