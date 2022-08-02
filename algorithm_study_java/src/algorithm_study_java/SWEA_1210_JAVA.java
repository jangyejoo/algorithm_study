package algorithm_study_java;
import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1210_JAVA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int T = 0; T < 10; T++) {
			int[][] ladder = new int[100][100];
			int tc = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			int x = 0;
			int y = 0;
			for (int i = 0; i < 100; i++) {
				String l = br.readLine();
				StringTokenizer st = new StringTokenizer(l);
				for (int j = 0; j < ladder.length; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 0; k < 100; k++) {
				if (ladder[99][k] == 2) {
					x = 99;
					y = k;
				}
			}

			while (x > 0) {
				if (y - 1 >= 0 && ladder[x][y - 1] == 1) {
					while (y - 1 >= 0 && ladder[x][y - 1] == 1) {
						y--;
					}
					if (ladder[x - 1][y] == 1)
						x--;

				} else if (y + 1 < 100 && ladder[x][y + 1] == 1) {
					while (y + 1 < 100 && ladder[x][y + 1] == 1) {
						y++;
					}
					if (ladder[x - 1][y] == 1)
						x--;
				} else {
					x--;
				}
			}
			sb.append("#").append(tc).append(" ").append(y);
			System.out.println(sb);
		}
	}
}
