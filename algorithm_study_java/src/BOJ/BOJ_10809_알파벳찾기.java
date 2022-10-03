package algorithm_study_java;

import java.io.*;

public class BOJ_10809_알파벳찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int[] result = new int[26];
		for (int i = 0; i < 26; i++) {
			result[i] = -1;
		}

		for (int i = 0; i < input.length(); i++) {
			if (result[input.charAt(i) - 'a'] == -1)
				result[input.charAt(i) - 'a'] = i;
		}

		for (int n : result) {
			System.out.print(n + " ");
		}

	}
}
