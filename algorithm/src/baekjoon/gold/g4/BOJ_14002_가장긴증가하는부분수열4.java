package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002_가장긴증가하는부분수열4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			input[i] = num;
		}

		int[] route = new int[n + 1];
		int[] length = new int[n + 1];
		length[1] = 1;

		// init done

		// 나보다 왼쪽에 있고 나보다 값이 작은데 length가 현재 가장 큰 친구

		int max = 1;
		int lastIdx = 1;
		for (int i = 2; i <= n; i++) {
			int num = input[i];

			// 나보다 왼쪽에 있고 나보다 값이 작은 친구가 있나
			int maxLength = 0;
			int maxLengthIdx = 0;
			for (int j = 1; j <= i - 1; j++) {
				if (input[j] < num) {
					if (maxLength < length[j]) {
						maxLength = length[j];
						maxLengthIdx = j;
					}
				}
			}

			if (maxLength > 0) {
				// 있으면
				route[i] = maxLengthIdx;
				length[i] = maxLength + 1;
				if (max < length[i]) {
					max = length[i];
					lastIdx = i;
				}
			} else {
				// 없으면
				length[i] = 1;
			}

		}

		sb.append(max).append("\n");

		Stack<Integer> s = new Stack<>();
		s.push(input[lastIdx]);
		while (true) {
			if (input[route[lastIdx]] == 0)
				break;
			s.push(input[route[lastIdx]]);
			lastIdx = route[lastIdx];
		}

		while (!s.isEmpty()) {
			sb.append(s.pop()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
