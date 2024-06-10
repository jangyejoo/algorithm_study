package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1958_LCS3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		int lengthA = a.length();
		int lengthB = b.length();
		int lengthC = c.length();

		int[][][] lcs = new int[lengthA + 1][lengthB + 1][lengthC + 1];
		for (int i = 1; i <= lengthA; i++) {
			for (int j = 1; j <= lengthB; j++) {
				for (int k = 1; k <= lengthC; k++) {
					if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1)) {
						lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;

						continue;
					}

					lcs[i][j][k] = Math.max(Math.max(lcs[i - 1][j][k], lcs[i][j - 1][k]), lcs[i][j][k - 1]);
				}
			}
		}

		System.out.println(lcs[lengthA][lengthB][lengthC]);

	}

}
