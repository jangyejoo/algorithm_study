package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5543_상근날드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int burger = 2000;
		int drink = 2000;

		for (int i = 0; i < 3; i++) {
			burger = Math.min(burger, Integer.parseInt(br.readLine()));
		}

		for (int i = 0; i < 2; i++) {
			drink = Math.min(drink, Integer.parseInt(br.readLine()));
		}

		System.out.println(burger + drink - 50);

	}

}
