package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1034_램프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(br.readLine());

		// init done

		int ans = 0;

		for (int i = 0; i < n; i++) {
			// i번째 행이 다 켜진다고 가정
			int zeroCnt = 0;
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					zeroCnt++;
			}

			if (zeroCnt > k || (k - zeroCnt) % 2 != 0)
				continue;

			// 똑같은 행의 개수 cnt
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				boolean isSame = true;
				for (int j2 = 0; j2 < m; j2++) {
					if (map[j][j2] != map[i][j2]) {
						isSame = false;
						break;
					}
				}
				if (isSame)
					cnt++;
			}

			ans = Math.max(ans, cnt);

		}
		System.out.println(ans);

	}

}
