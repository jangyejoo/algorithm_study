package baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3460_이진수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			int compareNum = 1;
			int cnt = 0;
			while(num>=compareNum) {
				if ((num & compareNum) != 0) {
					sb.append(cnt).append(" ");
				}
				cnt++;
				compareNum *= 2;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}
