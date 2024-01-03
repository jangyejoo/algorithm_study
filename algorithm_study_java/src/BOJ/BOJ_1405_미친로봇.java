package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405_미친로봇 {

//	동서남북
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[] probability = new int[4];

	static int n;
	static double result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; i++) {
			probability[i] = Integer.parseInt(st.nextToken());
		}

//		init done

		boolean[][] visited = new boolean[30][30];
		visited[14][14] = true;

		for (int i = 0; i < 4; i++) {
			if (probability[i] == 0)
				continue;

			int nx = 14 + dx[i];
			int ny = 14 + dy[i];

			visited[nx][ny] = true;
			move(nx, ny, visited, 1, probability[i] / 100.0);
			visited[nx][ny] = false;
		}

		System.out.println(result);

	}

	private static void move(int x, int y, boolean[][] visited, int cnt, double prob) {
		if (cnt == n) {
			result += prob;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (probability[i] == 0)
				continue;

			int nx = x + dx[i];
			int ny = y + dy[i];

			if (visited[nx][ny])
				continue;

			visited[nx][ny] = true;
			move(nx, ny, visited, cnt + 1, prob * probability[i] / 100.0);
			visited[nx][ny] = false;
		}

	}

}
