package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12869_뮤탈리스크 {

	static int[] dx = { 1, 1, 3, 3, 9, 9 };
	static int[] dy = { 3, 9, 1, 9, 1, 3 };
	static int[] dz = { 9, 3, 9, 1, 3, 1 };
	static int[][][] memory = new int[61][61][61];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int SCV[] = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			SCV[i] = Integer.parseInt(st.nextToken());
		}

//		init done

		if (n == 1) {
			// 그냥 계속 -9
			if (SCV[1] % 9 == 0) {
				System.out.println(SCV[1] / 9);
			} else {
				System.out.println(SCV[1] / 9 + 1);
			}
		} else if (n == 2) {
			// 둘 중 남은 체력이 더 큰 쪽을 -9
			int result2 = calc2(SCV[1], SCV[2], 0);
			System.out.println(result2);
		} else {
			// 6가지의 경우가 있음
			calc3(SCV[1], SCV[2], SCV[3], 0);
			System.out.println(memory[0][0][0]);
		}
		return;
	}

	private static void calc3(int x, int y, int z, int cnt) {
		if (x == 0 && y == 0 && z == 0) {
			return;
		}

		for (int i = 0; i < 6; i++) {
			int nx = x - dx[i] < 0 ? 0 : x - dx[i];
			int ny = y - dy[i] < 0 ? 0 : y - dy[i];
			int nz = z - dz[i] < 0 ? 0 : z - dz[i];

			if (memory[nx][ny][nz] == 0 || memory[nx][ny][nz] > cnt + 1)
				memory[nx][ny][nz] = cnt + 1;
			else
				continue;

			calc3(nx, ny, nz, cnt + 1);
		}
	}

	private static int calc2(int x, int y, int cnt) {
		if (x == 0 && y == 0) {
			return cnt;
		}

		if (x >= y) {
			x = x - 9 < 0 ? 0 : x - 9;
			y = y - 3 < 0 ? 0 : y - 3;
		} else {
			x = x - 3 < 0 ? 0 : x - 3;
			y = y - 9 < 0 ? 0 : y - 9;
		}

		return calc2(x, y, cnt + 1);
	}

}
