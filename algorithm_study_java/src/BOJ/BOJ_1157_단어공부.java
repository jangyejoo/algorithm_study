package BOJ;

import java.io.*;

public class BOJ_1157_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toUpperCase().toCharArray();
		int[] cnt = new int[91];
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			cnt[(int) input[i]]++;
			if (cnt[max] < cnt[(int) input[i]]) max = (int) input[i];
		}

		Boolean isQM = false;
		for (int i = 65; i < 91; i++) {
			if (cnt[i] == cnt[max] && i!=max) isQM = true;
		}

		System.out.println(isQM ? "?" : (char)max);
	
	}

}
