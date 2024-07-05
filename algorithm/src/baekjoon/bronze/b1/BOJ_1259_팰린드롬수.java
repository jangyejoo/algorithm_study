package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = br.readLine();
			if ("0".equals(input))
				break;

			String reverse = new StringBuffer(input).reverse().toString();

			if (input.equals(reverse))
				System.out.println("yes");
			else
				System.out.println("no");

		}
	}

}
