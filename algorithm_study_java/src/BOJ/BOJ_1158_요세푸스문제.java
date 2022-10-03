package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int idx = K;

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(i, i + 1);
		}
		while (true) {
			sb.append(list.get(K - 1));
			if (list.size() != 1) {
				sb.append(", ");
			}
			list.remove(K - 1);
			if (list.size() == 0)
				break;
			for (int i = 0; i < idx - 1; i++) {
				K++;
			}
			K = K % list.size() == 0 ? list.size() : K % list.size();
		}
		sb.append(">");
		System.out.println(sb);
	}

}
