package baekjoon.bronze.b5;

import java.io.*;

public class BOJ_2753_윤년 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());

		System.out.println(((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? "1" : "0");
	}

}
