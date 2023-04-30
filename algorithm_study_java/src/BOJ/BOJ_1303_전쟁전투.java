package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁전투 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[m][n];

		for (int i = 0; i < m; i++) {
			map[i] = br.readLine().toCharArray();
		}

//		init done

		int w = 0;
		int b = 0;
		int cnt = 0;
		boolean bw = false; // b면 true, w면 false

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != '0') {
					if (map[i][j] == 'B')
						bw = true;
					else
						bw = false;
					q.add(new int[] { i, j });
					map[i][j] = '0';
					cnt = 1;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = cur[0] + dx[k];
							int ny = cur[1] + dy[k];
							if (nx < 0 || ny < 0 || nx >= m || ny >= n)
								continue;
							if (map[nx][ny] == '0')
								continue;
							if ((bw && map[nx][ny] == 'W') || (!bw && map[nx][ny] == 'B'))
								continue;
							q.add(new int[] { nx, ny });
							map[nx][ny] = '0';
							cnt++;
						}
					}

					if (!bw)
						w += cnt * cnt;
					if (bw)
						b += cnt * cnt;

				}
			}
		}

		System.out.println(w + " " + b);

	}

}
