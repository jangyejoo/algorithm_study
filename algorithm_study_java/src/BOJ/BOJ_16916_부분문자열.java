package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916_부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String p = br.readLine();

		if(KMP(s, p))
			System.out.println(1);
		else 
			System.out.println(0);

	}

	private static boolean KMP(String s, String p) {
		int[] table = makePI(s);
		
		int sl = s.length();
		int pl = p.length();
		
		int idx = 0;
		for (int i = 0; i < sl; i++) {
			while(idx > 0 && s.charAt(i) != p.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(s.charAt(i)==p.charAt(idx)) {
				if (idx==pl-1) {
					return true;
				} else {
					idx++;
				}
			}
		}
		return false;
	}

	private static int[] makePI(String s) {
		int n = s.length();
		int[] table = new int[n];

		int idx = 0;
		for (int i = 1; i < n; i++) {
			while (idx > 0 && s.charAt(i) != s.charAt(idx)) {
				idx = table[idx - 1];
			}

			if (s.charAt(i) == s.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		return table;
	}
}
