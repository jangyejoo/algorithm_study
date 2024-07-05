package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16434_드래곤앤던전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int atk = Integer.parseInt(st.nextToken());

		long[][] input = new long[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			input[i][0] = t;
			input[i][1] = a;
			input[i][2] = h;
		}

		long left = 0;
		long right = ((long) 2 << 62) - 1;
		C: while (left <= right) {
			long mid = (left + right) / 2;
			long curHp = mid;
			long curAtk = atk;

			for (int i = 0; i < n; i++) {
				if (input[i][0] == 1) {
					// 몬스터
					if (input[i][2] % curAtk == 0)
						curHp -= ((input[i][2] / curAtk) - 1) * input[i][1];
					else
						curHp -= (input[i][2] / curAtk) * input[i][1];

					if (curHp <= 0) {
						// 죽음
						left = mid + 1;
						continue C;
					}
				} else {
					// 포션
					curAtk += input[i][1];
					if (mid - curHp <= input[i][2])
						curHp = mid;
					else
						curHp += input[i][2];
				}

			}

			right = mid - 1;
		}

		System.out.println(left);
	}

}
