package swea;

import java.io.*;
import java.util.*;

public class SWEA_1247_최적경로 {

	static int[] company, home;
	static List<int[]> customers;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			ans = Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			int[] numbers = new int[n];
			boolean[] visited = new boolean[n];
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			company = new int[2];
			home = new int[2];
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			customers = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) {
				int c[] = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				customers.add(c);
			}

//			init done

			shuffle(visited, numbers, 0, n);

			sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void shuffle(boolean[] visited, int[] numbers, int cnt, int n) {
		if (cnt == n) {
			int total = 0;
			int curX = company[0];
			int curY = company[1];
			for (int i = 0, size = numbers.length; i < size; i++) {
				int nxtX = customers.get(numbers[i])[0];
				int nxtY = customers.get(numbers[i])[1];
				total += distance(curX, curY, nxtX, nxtY);
				curX = nxtX;
				curY = nxtY;
			}
			total += distance(curX, curY, home[0], home[1]);
			ans = total < ans ? total : ans;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			numbers[cnt] = i;
			shuffle(visited, numbers, cnt + 1, n);
			visited[i] = false;
		}
	}

	private static int distance(int curX, int curY, int i, int j) {
		return Math.abs(curX - i) + Math.abs(curY - j);
	}

}
