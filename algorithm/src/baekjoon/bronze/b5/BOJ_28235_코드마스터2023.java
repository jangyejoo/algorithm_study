package baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_28235_코드마스터2023 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		switch (input) {
		case "SONGDO":
			System.out.println("HIGHSCHOOL");
			break;
		case "CODE":
			System.out.println("MASTER");
			break;
		case "2023":
			System.out.println("0611");
			break;
		case "ALGORITHM":
			System.out.println("CONTEST");
			break;
		}
	}

}
