package baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27889_특별한학교이름 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		switch (input) {
		case "NLCS":
			System.out.println("North London Collegiate School");
			break;
		case "BHA":
			System.out.println("Branksome Hall Asia");
			break;
		case "KIS":
			System.out.println("Korea International School");
			break;
		case "SJA":
			System.out.println("St. Johnsbury Academy");
			break;
		}
	}

}
