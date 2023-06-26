package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829_Hashing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[] input = new char[n];
		input = br.readLine().toCharArray();

		// init done

		long ans = 0;
		for (int i = 0; i < input.length; i++) {
			int num = input[i] - 'a' + 1;
			ans += (num * calcPow(i)) % 1234567891;
		}
		System.out.println(ans % 1234567891);
	}

	private static long calcPow(int cnt) {
		long num = 1;
		for (int j = 0; j < cnt; j++) {
			num *= 31;
			num %= 1234567891;
		}
		return num;
	}

}
