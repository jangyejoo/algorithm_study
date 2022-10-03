package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_No1_낚시터자리잡기 {

	static int n, ans;
	static int[][] openGate;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			openGate = new int[3][2];
			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				openGate[i][0] = Integer.parseInt(st.nextToken());
				openGate[i][1] = Integer.parseInt(st.nextToken());
			}

			int[] numbers = new int[3];
			boolean[] visited = new boolean[3];
			ans = Integer.MAX_VALUE;
			shuffle(numbers, visited, 0);
			sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void shuffle(int[] numbers, boolean[] visited, int cnt) {
		if (cnt == 3) {
			int[] fishingSpot = new int[n + 1];
			Arrays.fill(fishingSpot, 0);
			enter(fishingSpot, numbers, 0, 0);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (visited[i])
				continue;
			numbers[cnt] = i;
			visited[i] = true;
			shuffle(numbers, visited, cnt + 1);
			visited[i] = false;
		}
	}

	private static void enter(int[] fishingSpot, int[] numbers, int idx, int result) {
		if (result > ans)
			return;
		if (idx == 3) {
//			끝나는거?
			ans = ans > result ? result : ans;
			return;
		}
		int start = openGate[numbers[idx]][0];
		int waitingMen = openGate[numbers[idx]][1];

		if (waitingMen % 2 == 0) {
//			짝수일 때
			int[] dx = { -1, 1 };
			int[] copy = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				copy[i] = fishingSpot[i];
			}
			int plus = bfs(fishingSpot, start, waitingMen, dx);
			enter(fishingSpot, numbers, idx + 1, result + plus);

			int[] dX = { 1, -1 };
			plus = bfs(copy, start, waitingMen, dX);
			enter(copy, numbers, idx + 1, result + plus);

		} else {
//			홀수일 때
			int[] dx = { -1, 1 };
			int plus = bfs(fishingSpot, start, waitingMen, dx);
			enter(fishingSpot, numbers, idx + 1, result + plus);
		}

	}

	private static int bfs(int[] fishingSpot, int start, int waitingMen, int[] dx) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[n + 1];
		int result = 0;
		int cnt = 0;
		if (fishingSpot[start] == 0) {
			fishingSpot[start] = 1;
			visited[start] = true;
			cnt++;
			result++;
		}
		q.offer(start);
		Break: while (cnt < waitingMen) {
			int cur = q.poll();
			for (int d = 0; d < 2; d++) {
				int nxt = cur + dx[d];
				if (nxt < 1 || nxt > n)
					continue;
				if (visited[nxt])
					continue;
				visited[nxt] = true;
				q.offer(nxt);
				if (fishingSpot[nxt] == 0) {
					fishingSpot[nxt] = Math.abs(start - nxt) + 1;
					result += fishingSpot[nxt];
					if (++cnt == waitingMen) {
						break Break;
					}
				}
			}
		}
		return result;
	}

}
