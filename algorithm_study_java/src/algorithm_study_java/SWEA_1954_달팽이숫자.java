package algorithm_study_java;
import java.io.*;

public class SWEA_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] b = new int[n + 1][n + 1];
			int x = 0;
			int y = 0;

			int dx[] = { 0, 1, 0, -1 };
			int dy[] = { 1, 0, -1, 0 };
			int d = 0;

			for (int j = 1; j <= n * n; j++) {
				// x나 y가 n-1 보다 커지거나
				// 이미 숫자가 쓰여진 곳을 만나면 방향을 꺾는다.
				b[x][y] = j;
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx > n - 1 || ny > n - 1 || nx < 0 || ny < 0 || b[nx][ny] != 0) {
					d = (d + 1) % 4;
				}
				x += dx[d];
				y += dy[d];
			}

			System.out.println("#" + i);
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					System.out.print(b[j][j2] + " ");
				}
				System.out.println();
			}
		}
	}

}
