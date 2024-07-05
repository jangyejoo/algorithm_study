package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21278_호석이두마리치킨 {

	static int one = 0;
	static int two = 0;
	static int ans = Integer.MAX_VALUE;

	static int n;
	static int[][] adjMatrix;
	static int[] arr = new int[2];

	public static void main(String[] args) throws IOException {
		// 만약 이러한 건물 조합이 여러 개라면,
		// 건물 번호 중 작은 게 더 작을수록,
		// 작은 번호가 같다면 큰 번호가 더 작을수록 좋은 건물 조합이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjMatrix = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j)
					adjMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}

		// init done

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (adjMatrix[i][k] != Integer.MAX_VALUE && adjMatrix[k][j] != Integer.MAX_VALUE) {
						adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
					}
				}
			}
		}

		// 플로이드 워샬 완료

		combination(0, 1);

		// 조합 완료

		System.out.println(one + " " + two + " " + ans);

	}

	private static void combination(int cnt, int idx) {
		if (cnt == 2) {
			// 조합 완성
			int hap = 0;
			for (int i = 1; i <= n; i++) {
				hap += Math.min(adjMatrix[i][arr[0]], adjMatrix[i][arr[1]]) * 2;
			}
			if (ans > hap) {
				ans = hap;
				one = arr[0];
				two = arr[1];
			}
			return;
		}

		for (int i = idx; i <= n; i++) {
			arr[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

}
