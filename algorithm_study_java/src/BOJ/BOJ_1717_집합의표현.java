package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int aRoot = find(parents, a);
			int bRoot = find(parents, b);
			if (command == 0) {
				parents[bRoot] = aRoot;
			} else {
				if (aRoot == bRoot)
					sb.append("yes").append("\n");
				else
					sb.append("no").append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents, parents[a]);
	}

}
