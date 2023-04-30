package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1062_가르침_0113 {
	static int n, k, max;
	static List<char[]> words;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			words.add(br.readLine().toCharArray());
		}

//		init done

		if (k < 5) {
			System.out.println(0);
			return;
		}

		boolean[] alphabet = new boolean[26];
		alphabet[0] = true;
		alphabet[2] = true;
		alphabet[8] = true;
		alphabet[13] = true;
		alphabet[19] = true;

		comb(alphabet, 0, 1);

		System.out.println(max);

	}

	private static void comb(boolean[] alphabet, int cnt, int start) {
		if (cnt == k - 5) {
			int result = calc(alphabet);
			max = Math.max(result, max);
			return;
		}

		for (int i = start; i < 26; i++) {
			if (alphabet[i])
				continue;
			alphabet[i] = true;
			comb(alphabet, cnt + 1, i + 1);
			alphabet[i] = false;
		}
	}

	private static int calc(boolean[] alphabet) {
		int cnt = 0;
		C: for (int i = 0; i < n; i++) {
			int idx = 0;
			int size = words.get(i).length;
			while (true) {
				int a = words.get(i)[idx] - 97;
				if (!alphabet[a])
					continue C;
				if (++idx >= size)
					break;
			}
			cnt++;
		}
		return cnt;
	}
}
