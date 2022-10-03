package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2908_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		char[] r_A = new char[A.length];
		char[] r_B = new char[B.length];
		for (int i = 0; i < r_A.length; i++) {
			r_A[i] = A[A.length - 1 - i];
		}
		for (int i = 0; i < r_A.length; i++) {
			r_B[i] = B[B.length - 1 - i];
		}

		int n_A = Integer.parseInt(new String(r_A));
		int n_B = Integer.parseInt(new String(r_B));
		System.out.println(n_A <= n_B ? n_B : n_A);
	}

}
