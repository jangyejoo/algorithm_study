package algorithm_study_java;

import java.io.*;
import java.util.*;

public class BOJ_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken()); // 수빈
		int k = Integer.parseInt(st.nextToken()); // 동생

		int[] result = new int[100001];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		result[n] = 0;
		q.add(n);
		while (result[k] == -1) {
			int cur = q.peek();
			q.poll();
			int[] dx = { cur - 1, cur + 1, 2 * cur };
			for (int nxt : dx) {
				if (nxt < 0 || nxt > 100000)
					continue;
				if (result[nxt] != -1)
					continue;
				result[nxt] = result[cur] + 1;
				q.add(nxt);
			}
		}
		System.out.println(result[k]);
	}
}
