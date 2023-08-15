package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1339_단어수학 {

	static int[] priority = new int[26];

	static class Alphabet {
		Character alphabet;
		int value;

		Alphabet(Character alphabet, int value) {
			this.alphabet = alphabet;
			this.value = value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				priority[word.charAt(j) - 65] += Math.pow(10, word.length() - j - 1);
			}
		}

		// init done

		PriorityQueue<Alphabet> pq = new PriorityQueue<>(new Comparator<Alphabet>() {

			@Override
			public int compare(Alphabet o1, Alphabet o2) {
				return o2.value - o1.value;
			}

		});

		for (int i = 0; i < 26; i++) {
			pq.add(new Alphabet((char) (i + 65), priority[i]));
		}

		int hap = 0;
		int max = 9;
		while (!pq.isEmpty()) {
			Alphabet cur = pq.poll();
			int value = cur.value;

			hap += value * max;
			max--;
		}

		System.out.println(hap);

	}

}
