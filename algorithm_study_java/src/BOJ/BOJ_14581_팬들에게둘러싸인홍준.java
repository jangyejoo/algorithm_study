package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14581_팬들에게둘러싸인홍준 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		System.out.println(":fan::fan::fan:");
		System.out.println(":fan::" + input + "::fan:");
		System.out.println(":fan::fan::fan:");
	}

}
