package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
//		i를 1로 만드는 연산 횟수의 최솟값 저장
		int [] commendCnt = new int [n+1];
		
//		1을 1로 만드는 경우 초기화
		commendCnt[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			int first = Integer.MAX_VALUE;
			int second = Integer.MAX_VALUE;
//			i가 3으로 나뉜다면
			if (i%3==0) {
				first = commendCnt[i/3] + 1;
			}
//			i가 2로 나뉜다면
			if (i%2==0) {
				second = commendCnt[i/2] + 1;
			}
			int third = commendCnt[i-1]+1;
			
			commendCnt[i] = Math.min(Math.min(first, second), third);
		}
		
		System.out.println(commendCnt[n]);
		
	}
	
}
