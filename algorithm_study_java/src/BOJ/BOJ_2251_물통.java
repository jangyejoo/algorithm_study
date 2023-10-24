package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// init done

		boolean[][][] bottles = new boolean[a + 1][b + 1][c + 1];
		bottles[0][0][c] = true;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, c });

		boolean[] answer = new boolean[c + 1];
		answer[c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int waterA = cur[0];
			int waterB = cur[1];
			int waterC = cur[2];

			int nextA = waterA;
			int nextB = waterB;
			int nextC = waterC;

			// c -> a
			if (waterC + waterA <= a) {
				// 다 부을 수 있음
				nextA = waterC + waterA;
				nextC = 0;
			} else {
				// 다 못 부음
				nextA = a;
				nextC = waterC - (a - waterA);
			}

			if (!bottles[nextA][waterB][nextC]) {
				if (nextA == 0)
					answer[nextC] = true;

				bottles[nextA][waterB][nextC] = true;
				q.offer(new int[] { nextA, waterB, nextC });
			}

			nextA = waterA;
			nextC = waterC;

			// c -> b
			if (waterC + waterB <= b) {
				// 다 부을 수 있음
				nextB = waterC + waterB;
				nextC = 0;
			} else {
				// 다 못 부음
				nextB = b;
				nextC = waterC - (b - waterB);
			}

			if (!bottles[waterA][nextB][nextC]) {
				if (nextA == 0)
					answer[nextC] = true;

				bottles[waterA][nextB][nextC] = true;
				q.offer(new int[] { waterA, nextB, nextC });
			}

			nextB = waterB;
			nextC = waterC;

			// a -> b
			if (waterA + waterB <= b) {
				// 다 부을 수 있음
				nextB = waterA + waterB;
				nextA = 0;
			} else {
				// 다 못 부음
				nextB = b;
				nextA = waterA - (b - waterB);
			}

			if (!bottles[nextA][nextB][waterC]) {
				if (nextA == 0)
					answer[nextC] = true;

				bottles[nextA][nextB][waterC] = true;
				q.offer(new int[] { nextA, nextB, waterC });
			}

			nextA = waterA;
			nextB = waterB;

			// a -> c
			if (waterA + waterC <= c) {
				// 다 부을 수 있음
				nextC = waterA + waterC;
				nextA = 0;
			} else {
				// 다 못 부음
				nextC = c;
				nextA = waterA - (c - waterC);
			}

			if (!bottles[nextA][waterB][nextC]) {
				if (nextA == 0)
					answer[nextC] = true;

				bottles[nextA][waterB][nextC] = true;
				q.offer(new int[] { nextA, waterB, nextC });
			}

			nextA = waterA;
			nextC = waterC;

			// b -> a
			if (waterB + waterA <= a) {
				// 다 부을 수 있음
				nextA = waterB + waterA;
				nextB = 0;
			} else {
				// 다 못 부음
				nextA = a;
				nextB = waterB - (a - waterA);
			}

			if (!bottles[nextA][nextB][waterC]) {
				if (nextA == 0)
					answer[nextC] = true;

				bottles[nextA][nextB][waterC] = true;
				q.offer(new int[] { nextA, nextB, waterC });
			}

			nextA = waterA;
			nextB = waterB;

			// b -> c
			if (waterB + waterC <= c) {
				// 다 부을 수 있음
				nextC = waterB + waterC;
				nextB = 0;
			} else {
				// 다 못 부음
				nextC = c;
				nextB = waterB - (c - waterC);
			}

			if (!bottles[waterA][nextB][nextC]) {
				if (waterA == 0)
					answer[nextC] = true;

				bottles[waterA][nextB][nextC] = true;
				q.offer(new int[] { waterA, nextB, nextC });
			}

		}

		for (int i = 0; i <= c; i++) {
			if (answer[i])
				System.out.print(i + " ");
		}

	}

}