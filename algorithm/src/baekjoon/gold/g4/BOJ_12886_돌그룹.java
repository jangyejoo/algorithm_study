package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12886_돌그룹 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// init done

		int size = a + b + c;

		if (size % 3 != 0) {
			System.out.println(0);
			return;
		}

		if (a == b && b == c) {
			System.out.println(1);
			return;
		}

		boolean[][] rocks = new boolean[size + 1][size + 1];
		rocks[a][b] = true;
		rocks[b][a] = true;
		rocks[a][c] = true;
		rocks[c][a] = true;
		rocks[b][c] = true;
		rocks[c][b] = true;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { a, b });

		boolean isPossible = false;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int A = cur[0];
			int B = cur[1];
			int C = size - A - B;

			int nextA = A;
			int nextB = B;
			int nextC = C;

			// a와 b
			if (A > B) {
				nextA = A - B;
				nextB = 2 * B;
			} else if (A < B) {
				nextB = B - A;
				nextA = 2 * A;
			}

			if (!rocks[nextA][nextB] && !rocks[nextA][nextC] && !rocks[nextB][nextC]) {
				rocks[nextA][nextB] = true;
				rocks[nextB][nextA] = true;
				rocks[nextB][nextC] = true;
				rocks[nextC][nextB] = true;
				rocks[nextA][nextC] = true;
				rocks[nextC][nextA] = true;

				if (nextA == nextB && nextB == nextC) {
					isPossible = true;
					break;
				}

				q.offer(new int[] { nextA, nextB });
			}

			nextA = A;
			nextB = B;
			nextC = C;

			// b와 c
			if (B > C) {
				nextB = B - C;
				nextC = 2 * C;
			} else if (B < C) {
				nextC = C - B;
				nextB = 2 * B;
			}

			if (!rocks[nextB][nextC] && !rocks[nextA][nextC] && !rocks[nextA][nextB]) {
				rocks[nextA][nextB] = true;
				rocks[nextB][nextA] = true;
				rocks[nextB][nextC] = true;
				rocks[nextC][nextB] = true;
				rocks[nextA][nextC] = true;
				rocks[nextC][nextA] = true;

				if (nextA == nextB && nextB == nextC) {
					isPossible = true;
					break;
				}

				q.offer(new int[] { nextB, nextC });
			}

			nextA = A;
			nextB = B;
			nextC = C;

			// a와 c
			if (A > C) {
				nextA = A - C;
				nextC = 2 * C;
			} else if (A < C) {
				nextC = C - A;
				nextA = 2 * A;
			}

			if (!rocks[nextA][nextC] && !rocks[nextA][nextB] && !rocks[nextB][nextC]) {
				rocks[nextA][nextB] = true;
				rocks[nextB][nextA] = true;
				rocks[nextB][nextC] = true;
				rocks[nextC][nextB] = true;
				rocks[nextA][nextC] = true;
				rocks[nextC][nextA] = true;

				if (nextA == nextB && nextB == nextC) {
					isPossible = true;
					break;
				}

				q.offer(new int[] { nextA, nextC });
			}
		}

		System.out.println(isPossible ? 1 : 0);

	}

}
