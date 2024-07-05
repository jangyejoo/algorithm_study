package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken()); // 사람의 수
		int m = Integer.parseInt(st.nextToken()); // 파티의 수

		st = new StringTokenizer(br.readLine().trim());
		int k = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		boolean[] trueman = new boolean[n + 1];
		for (int i = 0; i < k; i++) {
			int manNumber = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 번호
			trueman[manNumber] = true;
		}

		boolean[] trueParty = new boolean[m];
		int[] parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		int[][] party = new int[m][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int partyPeople = Integer.parseInt(st.nextToken()); // 파티에 오는 사람의 수

			int pre = -1;
			for (int j = 0; j < partyPeople; j++) {
				int manNumber = Integer.parseInt(st.nextToken()); // 파티에 오는 사람의 번호
				party[i][manNumber] = 1;

				if (trueman[manNumber])
					trueParty[i] = true;

				if (pre != -1) {
					union(parents, pre, manNumber);

					if (trueman[pre])
						trueman[manNumber] = true;

					if (trueman[manNumber])
						trueman[pre] = true;
				}

				pre = manNumber;
			}

		}

		for (int r = 0; r < m; r++) {
			for (int i = 0; i < m; i++) {
				int pre = -1;
				for (int j = 1; j <= n; j++) {
					if (party[i][j] == 0)
						continue;

					if (trueman[j])
						trueParty[i] = true;

					if (pre != -1) {
						union(parents, pre, j);
						if (trueman[pre])
							trueman[j] = true;

						if (trueman[j])
							trueman[pre] = true;
					}

					pre = j;
				}

			}
		}

		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (!trueParty[i])
				cnt++;
		}
		System.out.println(cnt);

	}

	private static void union(int[] parents, int a, int b) {
		int aRoot = find(parents, a);
		int bRoot = find(parents, b);
		if (aRoot != bRoot) {
			parents[aRoot] = bRoot;
		}
	}

	private static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents, parents[a]);
	}

}
