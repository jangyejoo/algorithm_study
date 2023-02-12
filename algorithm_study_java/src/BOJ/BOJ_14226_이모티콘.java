package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226_이모티콘 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<int[]> q = new LinkedList<>();
		int[][] dist = new int[1001][1001];
		q.add(new int[] { 1, 0 }); // monitor, clipboard
		dist[1][0] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int monitor = cur[0];
			int clipboard = cur[1];

			if (monitor == n)
				break;

			// 1. 복사
			if (dist[monitor][monitor] == 0) {
				q.offer(new int[] { monitor, monitor });
				dist[monitor][monitor] = dist[monitor][clipboard] + 1;
			}

			// 2. 붙여넣기
			if (clipboard != 0 && dist[monitor + clipboard][clipboard] == 0 && monitor + clipboard < 1001) {
				q.offer(new int[] { monitor + clipboard, clipboard });
				dist[monitor + clipboard][clipboard] = dist[monitor][clipboard] + 1;
			}

			// 3. 삭제
			if (monitor > 2 && dist[monitor - 1][clipboard] == 0) {
				q.offer(new int[] { monitor - 1, clipboard });
				dist[monitor - 1][clipboard] = dist[monitor][clipboard] + 1;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 1001; i++) {
			if (dist[n][i] != 0)
				min = Math.min(min, dist[n][i] - 1);
		}

		System.out.println(min);
	}

}