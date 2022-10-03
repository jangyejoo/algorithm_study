package algorithm_study_java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static StringBuilder sb;
	static char[] ans, chArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String lc = br.readLine();
		StringTokenizer st = new StringTokenizer(lc);
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		ans = new char[l];
		chArr = new char[c];
		String input = br.readLine();
		st = new StringTokenizer(input);
		for (int i = 0; i < c; i++) {
			chArr[i] = st.nextToken().toCharArray()[0];
		}

//		오름차순 정렬
		Arrays.sort(chArr);

//		정답 문자열, 알파벳 배열, 선택된 수들의 개수, 모음의 개수, 자음의 개수
		generate(0, 0, 0, 0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void generate(int cnt, int start, int vowel, int consonant) {
		if (cnt == ans.length) {
			if (vowel >= 1 && consonant >= 2) {
				for (int i = 0; i < cnt; i++) {
					sb.append(ans[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start, size = chArr.length; i < size; i++) {
			ans[cnt] = chArr[i];
			if (chArr[i] == 'a' || chArr[i] == 'e' || chArr[i] == 'i' || chArr[i] == 'o' || chArr[i] == 'u') {
				generate(cnt + 1, i + 1, vowel + 1, consonant);
			} else {
				generate(cnt + 1, i + 1, vowel, consonant + 1);
			}
		}
	}

}
