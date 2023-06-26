package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int number = 0;
		int cnt = 0;
		while (true) {
			if ((number + "").contains("666"))
				cnt++;
			if (cnt == n)
				break;
			number++;
		}
		System.out.println(number);
	}

}
