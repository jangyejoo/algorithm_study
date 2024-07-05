package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {

	static int[] comb;
	static List<char[]> words;
	static int max = 0;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		words = new ArrayList<>();
		int[] letter = new int[26];
		for (int i = 0; i < n; i++) {
			char[] full = br.readLine().toCharArray();
			for (int j = 0; j < full.length; j++) {
				if (full[j] == 'a' || full[j] == 'c' || full[j] == 'i' || full[j] == 'n' || full[j] == 't')
					continue;
				letter[full[j] - 97]++;
			}
			words.add(full);
		}

//		init done
		
		int ans = 0;
		// 가르칠 수 있는 글자 수가 5보다 작으면
		// 무조건 답은 0
		if (k < 5) {
			System.out.println(ans);
			return;
		}

		comb = new int[k - 5];
		combination(letter, 0, 0, k - 5);

		System.out.println(max);
	}

	private static void combination(int[] letter, int cnt, int start, int N) {
		if (cnt == N) {
			int read = 0;
			C1: for (int i = 0; i < n; i++) {
				char[] word = words.get(i);
				C2: for (int j = 4; j < word.length - 4; j++) {
					if (word[j] != 'a' && word[j] != 'c' && word[j] != 'n' && word[j] != 't' && word[j] != 'i') {
						for (int j2 = 0; j2 < comb.length; j2++) {
							if (word[j] - 'a' == comb[j2]) {
								// 읽을 수 있음, 다음 철자로 넘어감
								continue C2;
							}
						}
						// 읽을 수 없음, 다음 단어로 넘어감
						continue C1;
					}
				}
				read++;
			}
			if (max < read)
				max = read;
			return;
		}
		for (int i = start; i < 26; i++) {
			// 배울 필요가 없는 글자는 넘어감
			if (letter[i] == 0)
				continue;
			comb[cnt] = i;
			combination(letter, cnt + 1, i + 1, N);
		}
		
		// 가르칠 수 있는 글자 수가 배워야 하는 글자 수보다 클 때
		// cnt == N에 걸리지 않는 경우를 처리하기 위함
		
		/*2 25
		antatica
		antaztica*/
		
		if (max == 0) {
			int read = 0;
			C1: for (int i = 0; i < n; i++) {
				char[] word = words.get(i);
				C2: for (int j = 4; j < word.length - 4; j++) {
					if (word[j] != 'a' && word[j] != 'c' && word[j] != 'n' && word[j] != 't' && word[j] != 'i') {
						for (int j2 = 0; j2 < comb.length; j2++) {
							if (word[j] - 'a' == comb[j2]) {
								// 읽을 수 있음, 다음 철자로 넘어감
								continue C2;
							}
						}
						// 읽을 수 없음, 다음 단어로 넘어감
						continue C1;
					}
				}
				read++;
			}
			if (max < read)
				max = read;
			return;
		}
	}

}
