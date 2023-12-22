package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2624_동전바꿔주기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		List<int[]> coins = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine().trim());

			coins.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

//		init done

//		정렬 - 안해도 무관, 생각하기 편해서 그냥 함
		Collections.sort(coins, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

//		dp[i][j] - i번째까지의 동전을 사용해서 j원을 만드는 경우의 수
		int[][] dp = new int[k + 1][t + 1];

//		dp 초기화 - 단순하게 한가지 동전으로 만들 수 있는 경우 체크
		for (int i = 0; i < k; i++) {
			int value = coins.get(i)[0];
			int amount = coins.get(i)[1];
			for (int j = 1; j <= amount; j++) {
				if (value * j > t)
					break;

				dp[i + 1][value * j] = 1;
			}
		}

//		i번째 동전을 j2개 사용할 때, dp 갱신
		for (int i = 1; i < k; i++) {
			int value = coins.get(i)[0];
			int amount = coins.get(i)[1];

			for (int j = 1; j <= t; j++) {
				for (int j2 = 0; j2 <= amount; j2++) {
					if (value * j2 > j)
						break;

					dp[i + 1][j] += dp[i][j - (value * j2)];
				}
			}
		}

		System.out.println(dp[k][t]);

	}

}
