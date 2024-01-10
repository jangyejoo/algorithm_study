package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2420_사파리월드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		System.out.println(Math.abs(n - m));
	}

}
