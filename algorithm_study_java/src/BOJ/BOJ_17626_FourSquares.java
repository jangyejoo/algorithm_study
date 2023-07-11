package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17626_FourSquares {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();
		int[] arr = new int[n + 1];
		Arrays.fill(arr, 4);
		for (int i = 1; i * i <= n; i++) {
			int next = i * i;
			arr[next] = 1;
			q.add(i * i);
		}

		// init done

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; cur + i * i <= n; i++) {
				int next = cur + i * i;
				if (arr[next] > arr[cur] + 1) {
					arr[next] = arr[cur] + 1;
					if (next == n) {
						break;
					}
					q.add(next);
				}
			}
		}
		System.out.println(arr[n]);
	}

}
