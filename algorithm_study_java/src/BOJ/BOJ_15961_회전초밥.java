package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 회전초밥벨트
		int d = Integer.parseInt(st.nextToken()); // 초밥종류
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] sushiBelt = new int[N];
		for (int i = 0; i < N; i++) {
			sushiBelt[i] = Integer.parseInt(br.readLine());
		}

//		init done

		int ans = -1;
		int start = 0;
		int[] sushi = new int[d + 1];

		int cnt = 0;
		while (true) {
			if (start == 0) {
				for (int i = 0; i < k; i++) {
					sushi[sushiBelt[(start + i) % N]]++;
				}
				for (int i = 1; i <= d; i++) {
					if (sushi[i] > 0)
						cnt++;
				}

			} else {
				if (--sushi[sushiBelt[start - 1]] == 0)
					cnt--;
				if (sushi[sushiBelt[(start + k - 1) % N]]++ == 0)
					cnt++;
			}

			if (sushi[c] == 0) {
				if (ans < cnt + 1)
					ans = cnt + 1;
			} else {
				if (ans < cnt)
					ans = cnt;
			}

			if (++start == N)
				break;
		}

		System.out.println(ans);
	}

}
