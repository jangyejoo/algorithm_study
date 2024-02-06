package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391_종이조각 {

	static int n, m, ans;
	static int[][] paper;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		paper = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(row.charAt(j) + "");
			}
		}

//		init done

		ans = 0;

//		dfs
		dfs(0, 0, 0);

		System.out.println(ans);

	}

	private static void dfs(int depth, int num, int sum) {
		if (depth == n * m) {
			ans = Math.max(ans, sum);
			return;
		}

		int x = depth / m;
		int y = depth % m;

		if (visited[x][y]) {
			dfs(depth + 1, num, sum);
		} else {
			visited[x][y] = true;

//			나까지만 자르기
			num = num * 10 + paper[x][y];
			dfs(depth + 1, 0, sum + num);

//			세로로 자르기
			int i, temp = num;
			for (i = x + 1; i < n; i++) {
				if (visited[i][y])
					break;

				visited[i][y] = true;
				temp = temp * 10 + paper[i][y];
				dfs(depth + 1, 0, sum + temp);
			}

//			방문 처리 초기화
			for (int j = x + 1; j < i; j++) {
				visited[j][y] = false;
			}

//			가로로 자르기
			temp = num;
			for (i = y + 1; i < m; i++) {
				if (visited[x][i])
					break;

				visited[x][i] = true;
				temp = temp * 10 + paper[x][i];
				dfs(depth + i - y + 1, 0, sum + temp);
			}

//			방문 처리 초기화
			for (int j = y + 1; j < i; j++) {
				visited[x][j] = false;
			}

			visited[x][y] = false;
		}

	}

}
