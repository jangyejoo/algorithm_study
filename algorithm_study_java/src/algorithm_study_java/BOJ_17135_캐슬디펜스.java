package algorithm_study_java;

import java.io.*;
import java.util.*;

public class BOJ_17135_캐슬디펜스 {

	static int[] result = new int[3];
	static int n, m, d, max = 0;
	static List<int[]> enemies;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String nmd = br.readLine();
		StringTokenizer st = new StringTokenizer(nmd);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		enemies = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			st = new StringTokenizer(row);
			for (int j = 0; j < m; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					int[] enemy = { i, j };
					enemies.add(enemy);
				}
			}
		}

		combination(0, 0, m);
		System.out.println(max);
	}

	private static void combination(int cnt, int start, int m) {
		if (cnt == 3) {
			int size = enemies.size();
			boolean remove[] = new boolean[size];
			List<int[]> copy = new ArrayList<int[]>();
			for (int i = 0; i < size; i++) {
				int copyInput[] = { enemies.get(i)[0], enemies.get(i)[1] };
				copy.add(copyInput);
			}
			check(result, remove, copy);
			return;
		}

		for (int i = start; i < m; i++) {
			result[cnt] = i;
			combination(cnt + 1, i + 1, m);
		}
	}

	private static void check(int[] result2, boolean[] remove, List<int[]> copy) {
//		map에 적이 없으면 끝!
		int kill = 0;
		int size = remove.length;
		while (true) {
			int removeList[] = { -1, -1, -1 };
			for (int j = 0; j < 3; j++) {
				int minI = -1;
				int minY = m;
				int minD = Integer.MAX_VALUE;
				int update = 0;
				for (int i = size - 1; i >= 0; i--) {
					if (remove[i])
						continue;
					int eX = copy.get(i)[0];
					int eY = copy.get(i)[1];
					int distance = dist(eX, eY, n, result2[j]);
					if (d >= distance) {
//						범위에 있고 가장 가까운거 하나
						if (distance == minD) {
							if (minY > eY) {
								minY = eY;
								minI = i;
								minD = distance;
								update++;
							}
						} else if (distance < minD) {
							minY = eY;
							minI = i;
							minD = distance;
							update++;
						}
						if (update > m) {
							break;
						}
					}
				}
				if (update != 0) {
					removeList[j] = minI;
				}
			}

			for (int i = 0; i < 3; i++) {
				if (removeList[i] == -1 || remove[removeList[i]])
					continue;
				remove[removeList[i]] = true;
				kill++;
			}

			boolean isBreak = true;
			for (int i = size - 1; i >= 0; i--) {
				if (remove[i])
					continue;
				int eX = copy.get(i)[0];
				if (eX + 1 >= n) {
					remove[i] = true;
				} else {
					copy.get(i)[0] = eX + 1;
					isBreak = false;
				}
			}

			if (isBreak) {
				max = kill > max ? kill : max;
				break;
			}
		}
		return;
	}

	private static int dist(int eX, int eY, int x, int y) {
		return Math.abs(eX - x) + Math.abs(eY - y);
	}

}
