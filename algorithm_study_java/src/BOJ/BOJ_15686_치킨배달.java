package algorithm_study_java;

import java.io.*;
import java.util.*;

public class BOJ_15686_치킨배달 {

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int ans;
	static List<int[]> house, store;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String nm = br.readLine();
		StringTokenizer st = new StringTokenizer(nm);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];
		store = new ArrayList<int[]>();
		house = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			st = new StringTokenizer(row);
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					int[] ij = { i, j };
					store.add(ij);
				}
				if (map[i][j] == 1) {
					int[] ij = { i, j };
					house.add(ij);
				}
			}
		}

		int nums[] = new int[m];
		ans = Integer.MAX_VALUE;
		combination(nums, m, 0, 0);

		System.out.println(ans);

	}

	private static void combination(int[] nums, int m, int cnt, int start) {
		if (cnt == m) {
			int result = 0;
			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < nums.length; j++) {
					int d = distance(store.get(nums[j]), house.get(i));
					min = min > d ? d : min;
				}
				result += min;
			}
			ans = ans > result ? result : ans;
			return;
		}

		for (int i = start; i < store.size(); i++) {
			nums[cnt] = i;
			combination(nums, m, cnt + 1, i + 1);
		}

	}

	private static int distance(int[] is, int[] is2) {
		return Math.abs(is[0] - is2[0]) + Math.abs(is[1] - is2[1]);
	}

}
