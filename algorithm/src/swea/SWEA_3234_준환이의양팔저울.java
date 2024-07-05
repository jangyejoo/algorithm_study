package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {

	static int ans, totalW, numbers[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] w = new int[n];
			String weight = br.readLine();
			StringTokenizer st = new StringTokenizer(weight);
			totalW = 0;
			for (int i = 0; i < n; i++) {
				w[i] = Integer.parseInt(st.nextToken());
				totalW += w[i];
			}

			ans = 0;
			numbers = new int[n];
			boolean[] visited = new boolean[n];
			shuffle(visited, w, 0);
//			방문 배열, 무게추 배열, 왼쪽 총합, 오른쪽 총합, 고른 개수
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void shuffle(boolean[] visited, int[] w, int cnt) {
		int n = w.length;
		if (cnt == n) {
			check(w, numbers, 0, 0, 0);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			numbers[cnt] = i;
			visited[i] = true;
			shuffle(visited, w, cnt + 1);
			visited[i] = false;
		}
	}

	private static void check(int[] w, int[] numbers, int leftW, int rightW, int cnt) {
		int n = w.length;
		if (cnt == n) {
			ans++;
			return;
		}
//		왼쪽에 넣는 경우
		check(w, numbers, leftW + w[numbers[cnt]], rightW, cnt + 1);
//		오른쪽에 넣는 경우
		if (leftW >= rightW + w[numbers[cnt]]) {
			check(w, numbers, leftW, rightW + w[numbers[cnt]], cnt + 1);
		}
	}

}
