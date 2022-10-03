package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10869_사칙연산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println(A + B);
		System.out.println(A - B);
		System.out.println(A * B);
		System.out.println(A / B);
		System.out.println(A % B);
	}
}
