package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712_넴모넴모 {

	static int n, m, totalCnt = 0;
	static boolean[][] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// init done

		isSelected = new boolean[n][m];
		subset(0, 0);

		System.out.println(totalCnt);
	}

	private static void subset(int x, int y) {
		if (x == n) {
			totalCnt++;
			return;
		}

		int nx;
		int ny;
		if (y + 1 == m) {
			nx = x + 1;
			ny = 0;
		} else {
			ny = y + 1;
			nx = x;
		}

		// 선택 안함
		isSelected[x][y] = false;
		subset(nx, ny);

		// (x, y)에 넴모를 올려놓을 때 넴모넴모가 완성되면 안됨
		if (x - 1 >= 0 && y - 1 >= 0)
			if (isSelected[x - 1][y - 1] && isSelected[x][y - 1] && isSelected[x - 1][y]) {
				return;
			}

		// 선택
		isSelected[x][y] = true;
		subset(nx, ny);

	}

}
