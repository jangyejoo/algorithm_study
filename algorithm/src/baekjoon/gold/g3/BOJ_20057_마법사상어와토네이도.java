package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도 {

	static int n;
	static int ans = 0;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		int d = 0;
		int length = 1;
		int twoCnt = 0;
		int lengthCnt = 0;

		int x = n / 2;
		int y = n / 2;
		map[x][y] = 1;

		while (x != 0 || y != 0) {
//			방향 전환
			if (lengthCnt == length) {
				twoCnt++;
				lengthCnt = 0;
				d = (d + 1) % 4;
				continue;
			}

//			길이 조절
			if (twoCnt == 2) {
				length++;
				twoCnt = 0;
				continue;
			}

			int nx = x + dx[d];
			int ny = y + dy[d];

//			방향 전환을 안하면 그대로 진행
			spread(map, nx, ny, d);
			lengthCnt++;

//			방문 표시
			x = nx;
			y = ny;

		}

		System.out.println(ans);

	}

	private static void spread(int[][] map, int x, int y, int d) {
		int hap = 0;
		int sand = map[x][y];
		map[x][y] = 0;

		switch (d) {
		case 0:
//			동 -> 서

//			10%
			if (x - 1 < 0 || y - 1 < 0)
				ans += sand * 10 / 100;
			else
				map[x - 1][y - 1] += sand * 10 / 100;
			if (x + 1 >= n || y - 1 < 0)
				ans += sand * 10 / 100;
			else
				map[x + 1][y - 1] += sand * 10 / 100;

//			7%
			if (x - 1 < 0)
				ans += sand * 7 / 100;
			else
				map[x - 1][y] += sand * 7 / 100;
			if (x + 1 >= n)
				ans += sand * 7 / 100;
			else
				map[x + 1][y] += sand * 7 / 100;

//			2%
			if (x - 2 < 0)
				ans += sand * 2 / 100;
			else
				map[x - 2][y] += sand * 2 / 100;
			if (x + 2 >= n)
				ans += sand * 2 / 100;
			else
				map[x + 2][y] += sand * 2 / 100;

//			5%
			if (y - 2 < 0)
				ans += sand * 5 / 100;
			else
				map[x][y - 2] += sand * 5 / 100;

//			1%
			if (x - 1 < 0 || y + 1 >= n)
				ans += sand * 1 / 100;
			else
				map[x - 1][y + 1] += sand * 1 / 100;
			if (x + 1 >= n || y + 1 >= n)
				ans += sand * 1 / 100;
			else
				map[x + 1][y + 1] += sand * 1 / 100;

//			남은거
			hap += sand * 10 / 100;
			hap += sand * 10 / 100;
			hap += sand * 7 / 100;
			hap += sand * 7 / 100;
			hap += sand * 5 / 100;
			hap += sand * 2 / 100;
			hap += sand * 2 / 100;
			hap += sand * 1 / 100;
			hap += sand * 1 / 100;

			if (y - 1 < 0)
				ans += sand - hap;
			else
				map[x][y - 1] += sand - hap;

			break;

		case 1:
//			북 -> 남

//			10%
			if (x + 1 >= n || y - 1 < 0)
				ans += sand * 10 / 100;
			else
				map[x + 1][y - 1] += sand * 10 / 100;
			if (x + 1 >= n || y + 1 >= n)
				ans += sand * 10 / 100;
			else
				map[x + 1][y + 1] += sand * 10 / 100;

//			7%
			if (y - 1 < 0)
				ans += sand * 7 / 100;
			else
				map[x][y - 1] += sand * 7 / 100;
			if (y + 1 >= n)
				ans += sand * 7 / 100;
			else
				map[x][y + 1] += sand * 7 / 100;

//			2%
			if (y - 2 < 0)
				ans += sand * 2 / 100;
			else
				map[x][y - 2] += sand * 2 / 100;
			if (y + 2 >= n)
				ans += sand * 2 / 100;
			else
				map[x][y + 2] += sand * 2 / 100;

//			5%
			if (x + 2 >= n)
				ans += sand * 5 / 100;
			else
				map[x + 2][y] += sand * 5 / 100;

//			1%
			if (x - 1 < 0 || y - 1 < 0)
				ans += sand * 1 / 100;
			else
				map[x - 1][y - 1] += sand * 1 / 100;
			if (x - 1 < 0 || y + 1 >= n)
				ans += sand * 1 / 100;
			else
				map[x - 1][y + 1] += sand * 1 / 100;

//			남은거
			hap += sand * 10 / 100;
			hap += sand * 10 / 100;
			hap += sand * 7 / 100;
			hap += sand * 7 / 100;
			hap += sand * 5 / 100;
			hap += sand * 2 / 100;
			hap += sand * 2 / 100;
			hap += sand * 1 / 100;
			hap += sand * 1 / 100;

			if (x + 1 >= n)
				ans += sand - hap;
			else
				map[x + 1][y] += sand - hap;

			break;

		case 2:
//			서 -> 동

//			10%
			if (x - 1 < 0 || y + 1 >= n)
				ans += sand * 10 / 100;
			else
				map[x - 1][y + 1] += sand * 10 / 100;
			if (x + 1 >= n || y + 1 >= n)
				ans += sand * 10 / 100;
			else
				map[x + 1][y + 1] += sand * 10 / 100;

//			7%
			if (x - 1 < 0)
				ans += sand * 7 / 100;
			else
				map[x - 1][y] += sand * 7 / 100;
			if (x + 1 >= n)
				ans += sand * 7 / 100;
			else
				map[x + 1][y] += sand * 7 / 100;

//			2%
			if (x - 2 < 0)
				ans += sand * 2 / 100;
			else
				map[x - 2][y] += sand * 2 / 100;
			if (x + 2 >= n)
				ans += sand * 2 / 100;
			else
				map[x + 2][y] += sand * 2 / 100;

//			5%
			if (y + 2 >= n)
				ans += sand * 5 / 100;
			else
				map[x][y + 2] += sand * 5 / 100;

//			1%
			if (x - 1 < 0 || y - 1 < 0)
				ans += sand * 1 / 100;
			else
				map[x - 1][y - 1] += sand * 1 / 100;
			if (x + 1 >= n || y - 1 < 0)
				ans += sand * 1 / 100;
			else
				map[x + 1][y - 1] += sand * 1 / 100;

//			남은거
			hap += sand * 10 / 100;
			hap += sand * 10 / 100;
			hap += sand * 7 / 100;
			hap += sand * 7 / 100;
			hap += sand * 5 / 100;
			hap += sand * 2 / 100;
			hap += sand * 2 / 100;
			hap += sand * 1 / 100;
			hap += sand * 1 / 100;

			if (y + 1 >= n)
				ans += sand - hap;
			else
				map[x][y + 1] += sand - hap;

			break;

		case 3:
//			남 -> 북

//			10%
			if (x - 1 < 0 || y - 1 < 0)
				ans += sand * 10 / 100;
			else
				map[x - 1][y - 1] += sand * 10 / 100;
			if (x - 1 < 0 || y + 1 >= n)
				ans += sand * 10 / 100;
			else
				map[x - 1][y + 1] += sand * 10 / 100;

//			7%
			if (y - 1 < 0)
				ans += sand * 7 / 100;
			else
				map[x][y - 1] += sand * 7 / 100;
			if (y + 1 >= n)
				ans += sand * 7 / 100;
			else
				map[x][y + 1] += sand * 7 / 100;

//			2%
			if (y - 2 < 0)
				ans += sand * 2 / 100;
			else
				map[x][y - 2] += sand * 2 / 100;
			if (y + 2 >= n)
				ans += sand * 2 / 100;
			else
				map[x][y + 2] += sand * 2 / 100;

//			5%
			if (x - 2 < 0)
				ans += sand * 5 / 100;
			else
				map[x - 2][y] += sand * 5 / 100;

//			1%
			if (x + 1 >= n || y - 1 < 0)
				ans += sand * 1 / 100;
			else
				map[x + 1][y - 1] += sand * 1 / 100;
			if (x + 1 >= n || y + 1 >= n)
				ans += sand * 1 / 100;
			else
				map[x + 1][y + 1] += sand * 1 / 100;

//			남은거
			hap += sand * 10 / 100;
			hap += sand * 10 / 100;
			hap += sand * 7 / 100;
			hap += sand * 7 / 100;
			hap += sand * 5 / 100;
			hap += sand * 2 / 100;
			hap += sand * 2 / 100;
			hap += sand * 1 / 100;
			hap += sand * 1 / 100;

			if (x - 1 < 0)
				ans += sand - hap;
			else
				map[x - 1][y] += sand - hap;

			break;
		}

	}

}
