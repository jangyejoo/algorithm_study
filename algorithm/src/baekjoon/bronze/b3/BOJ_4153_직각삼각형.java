package baekjoon.bronze.b3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4153_직각삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] length = new int[3];
			length[0] = Integer.parseInt(st.nextToken());
			length[1] = Integer.parseInt(st.nextToken());
			length[2] = Integer.parseInt(st.nextToken());

			int maxIdx = -1;
			int max = 0;
			boolean isDone = true;
			for (int i = 0; i < 3; i++) {
				if (length[i] != 0) {
					isDone = false;
				}
				if (max < length[i]) {
					max = length[i];
					maxIdx = i;
				}
			}

			if (isDone) {
				break;
			} else {
				int result = 0;
				for (int i = 0; i < 3; i++) {
					if (i == maxIdx)
						continue;
					result += length[i] * length[i];
				}

				if (result == max * max) {
					sb.append("right\n");
				} else {
					sb.append("wrong\n");
				}
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
