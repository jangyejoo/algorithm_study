package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] obstacleA = new int[h + 1];
		int[] obstacleB = new int[h + 1];

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (i % 2 == 0) {
				obstacleA[num]++;
				continue;
			}

			obstacleB[h - num + 1]++;
		}

		int[] destroyedA = new int[h + 1];
		int[] destroyedB = new int[h + 1];

		destroyedA[h] = obstacleA[h];
		destroyedB[1] = obstacleB[1];

//		석순
		for (int i = h - 1; i >= 1; i--) {
			destroyedA[i] = destroyedA[i + 1] + obstacleA[i];
		}

//		종유석
		for (int i = 2; i <= h; i++) {
			destroyedB[i] = destroyedB[i - 1] + obstacleB[i];
		}

		int cnt = 0;
		int min = Integer.MAX_VALUE;
		int[] result = new int[h + 1];
		for (int i = 1; i <= h; i++) {
			result[i] = destroyedA[i] + destroyedB[i];

			if (min > result[i]) {
				cnt = 1;
				min = result[i];
				continue;
			}

			if (min == result[i]) {
				cnt++;
				continue;
			}
		}

		System.out.println(min + " " + cnt);

	}

}
