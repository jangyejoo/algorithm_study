package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16724_피리부는사나이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j);
			}
		}

//		init done

		int ans = 0;
		int section = 0;

		int[][] visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] != 0)
					continue;

				Queue<int[]> q = new LinkedList<>();

				visited[i][j] = ++section;
				q.offer(new int[] { i, j });

				while (!q.isEmpty()) {
					int[] cur = q.poll();

//					피리 소리에 맞춰 이동
					int nx = cur[0];
					int ny = cur[1];
					switch (map[cur[0]][cur[1]]) {
					case 'U':
						nx--;
						break;
					case 'D':
						nx++;
						break;
					case 'L':
						ny--;
						break;
					case 'R':
						ny++;
						break;
					}

//					이미 이번 section에서 들렀던 곳 ==> 새로운 safe zone
					if (visited[nx][ny] == section) {
						ans++;
						break;
					}

//					이미 만든 safe zone으로 흘러가는 곳
					if (visited[nx][ny] != 0) {
						break;
					}

					visited[nx][ny] = section;
					q.offer(new int[] { nx, ny });
				}
			}
		}

		System.out.println(ans);

	}
}
