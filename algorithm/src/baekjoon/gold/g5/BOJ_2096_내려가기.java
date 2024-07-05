package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] input = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}

		// init done

		int[] max = new int[3];
		int[] min = new int[3];

		for (int i = 0; i < n; i++) {
			int a = max[0];
			int b = max[1];
			int c = max[2];

			max[0] = Math.max(a + input[i][0], b + input[i][0]);
			max[1] = Math.max(a + input[i][1], b + input[i][1]);
			max[1] = Math.max(max[1], c + input[i][1]);
			max[2] = Math.max(b + input[i][2], c + input[i][2]);

			a = min[0];
			b = min[1];
			c = min[2];

			min[0] = Math.min(a + input[i][0], b + input[i][0]);
			min[1] = Math.min(a + input[i][1], b + input[i][1]);
			min[1] = Math.min(min[1], c + input[i][1]);
			min[2] = Math.min(b + input[i][2], c + input[i][2]);
		}

		System.out.print(Math.max(Math.max(max[0], max[1]), max[2]) + " ");
		System.out.println(Math.min(Math.min(min[0], min[1]), min[2]));

	}

}
