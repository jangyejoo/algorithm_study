package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11758_CCW {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] input = new int[3][2];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine().trim());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

//		init done

		int a = input[0][0] * input[1][1] + input[1][0] * input[2][1] + input[2][0] * input[0][1];
		int b = input[0][1] * input[1][0] + input[1][1] * input[2][0] + input[2][1] * input[0][0];

		if (a - b > 0) {
			System.out.println(1);
		} else if (a == b) {
			System.out.println(0);
		} else {
			System.out.println(-1);
		}

	}

}
