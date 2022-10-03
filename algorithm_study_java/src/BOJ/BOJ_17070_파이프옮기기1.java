package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][][] pipe = new int[n + 1][n + 1][4];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				pipe[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}

//		init done

		pipe[1][2][1] = 1;
		pipe[1][2][2] = 0;
		pipe[1][2][3] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 3; j <= n; j++) {
				if (pipe[i][j][0] == 1) {
					pipe[i][j][1] = 0;
					pipe[i][j][2] = 0;
					pipe[i][j][3] = 0;
					continue;
				}
				pipe[i][j][1] = pipe[i][j - 1][1] + pipe[i][j - 1][3];
				pipe[i][j][2] = pipe[i - 1][j][2] + pipe[i - 1][j][3];
				if (pipe[i][j][0] != 1 && pipe[i - 1][j][0] != 1 && pipe[i][j - 1][0] != 1
						&& pipe[i - 1][j - 1][0] != 1) {
					pipe[i][j][3] = pipe[i - 1][j - 1][1] + pipe[i - 1][j - 1][2] + pipe[i - 1][j - 1][3];
				}
			}
		}

//		pipe 출력 테스트
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(pipe[i][j][4] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(pipe[n][n][1] + pipe[n][n][2] + pipe[n][n][3]);

	}

}
