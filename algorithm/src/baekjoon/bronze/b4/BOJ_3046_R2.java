package baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3046_R2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int r1 = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		System.out.println(s * 2 - r1);
	}

}
