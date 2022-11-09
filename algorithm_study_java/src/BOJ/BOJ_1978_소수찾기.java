package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int cnt = n;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				cnt--;
				continue;
			}
			for (int j = 2; j * j <= num; j++) {
				if (num % j == 0) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
