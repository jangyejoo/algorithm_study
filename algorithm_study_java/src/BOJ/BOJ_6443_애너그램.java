package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_6443_애너그램 {

	static char[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String input = br.readLine();

			int size = input.length();
			int[] alphabet = new int[26];
			for (int j = 0; j < size; j++) {
				alphabet[input.charAt(j) - 'a']++;
			}

			// 순열
			selected = new char[size];
			play(alphabet, 0);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void play(int[] alphabet, int cnt) {
		if (cnt == selected.length) {
			for (int i = 0, size = selected.length; i < size; i++) {
				sb.append(selected[i]);
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (alphabet[i] == 0)
				continue;

			selected[cnt] = (char) (i + 'a');
			alphabet[i]--;

			play(alphabet, cnt + 1);
			alphabet[i]++;
		}
	}

}
