package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2744_대소문자바꾸기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		String ans = "";
		for (int i = 0; i < input.length(); i++) {
			int a = input.charAt(i) + 0;
			if (a >= 97) {
				// 소문자
				ans += (input.charAt(i) + "").toUpperCase();
			} else {
				// 대문자
				ans += (input.charAt(i) + "").toLowerCase();
			}
		}
		System.out.println(ans);
	}

}
