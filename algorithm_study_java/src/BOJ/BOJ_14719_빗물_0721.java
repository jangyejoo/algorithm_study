package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물_0721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[h + 1][w + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= w; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int j = h; j > h - num; j--) {
				map[j][i] = true;
			}
		}

		// init done

		int hap = 0;
		for (int i = 1; i <= h; i++) {
			int start = -1;
			for (int j = 1; j <= w; j++) {
				if (!map[i][j])
					continue;
				if (start == -1) {
					start = j;
				} else {
					hap += j - start - 1;
					start = j;
				}
			}
		}

		System.out.println(hap);
	}

}
