package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

//		init done

		int gcd = 0;

		for (int i = 1; i <= x && i <= y; i++) {
			if (x % i == 0 && y % i == 0)
				gcd = i;
		}
		int lcm = x * y / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);

	}

}
