package baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25304_영수증 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int total = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		int hap = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int money = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			hap += (money * cnt);
		}

		if (total == hap)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
