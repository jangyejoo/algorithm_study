package algorithm_study_java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11660_JAVA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String i1 = br.readLine();
		StringTokenizer st = new StringTokenizer(i1);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] s = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String row = br.readLine();
			StringTokenizer st1 = new StringTokenizer(row);
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += Integer.parseInt(st1.nextToken());
				s[i][j] = sum;
			}
		}

		for (int i = 0; i < M; i++) {
			String command = br.readLine();
			StringTokenizer st2 = new StringTokenizer(command);
			int x1 = Integer.parseInt(st2.nextToken());
			int y1 = Integer.parseInt(st2.nextToken());
			int x2 = Integer.parseInt(st2.nextToken());
			int y2 = Integer.parseInt(st2.nextToken());

			int ans = 0;

			for (int r = x1; r <= x2; r++) {
				ans += s[r][y2] - s[r][y1 - 1];
			}
			sb.append(ans).append("\n");

		}

		System.out.print(sb);

	}

}
