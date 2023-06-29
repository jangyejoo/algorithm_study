package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		char[] input = new char[m];
		if (m > 0) {
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < m; i++) {
				input[i] = st.nextToken().charAt(0);
			}
		}

		// init done

		int min = Math.abs(n - 100);
		for (int gap = 0; gap < min; gap++) {
			int[] next = { n + gap, n - gap };
			for (int number : next) {
				if (number >= 0 && isPossible(number, input))
					min = Math.min(min, Integer.toString(number).length() + gap);
			}

		}

		System.out.println(min);

	}

	private static boolean isPossible(int number, char[] input) {
		char[] check = (number + "").toCharArray();
		for (char c : check) {
			for (char d : input) {
				if (c == d) {
					return false;
				}
			}
		}
		return true;
	}

}
