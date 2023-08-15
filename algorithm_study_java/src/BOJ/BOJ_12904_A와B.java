package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {

	static boolean isPossible = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		// init done

		play(t, s);

		if (isPossible) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	private static void play(String t, String s) {
		int lastIdx = t.length() - 1;

		if (lastIdx == -1)
			return;

		if (t.equals(s)) {
			isPossible = true;
			return;
		}

		if (t.charAt(lastIdx) == 'A') {
			// 맨뒤에 A를 뺌
			String a = "";
			for (int i = 0; i < lastIdx; i++) {
				a += t.charAt(i);
			}
			play(a, s);
		} else if (t.charAt(lastIdx) == 'B') {
			// 맨뒤에 B를 빼고 reverse
			String b = "";
			for (int i = lastIdx - 1; i >= 0; i--) {
				b += t.charAt(i);
			}
			play(b, s);
		} else {
			return;
		}
	}

}
