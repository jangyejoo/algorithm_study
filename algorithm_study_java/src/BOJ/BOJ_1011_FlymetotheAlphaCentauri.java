package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1011_FlymetotheAlphaCentauri {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int diff = y - x;
			int sqrt = (int) Math.floor(Math.sqrt(diff));
			int sqrtsqrt = sqrt * sqrt;

			if (diff - sqrtsqrt == 0) {
				sb.append(2 * sqrt - 1).append("\n");
			} else if (diff - sqrtsqrt > sqrt) {
				sb.append(2 * sqrt + 1).append("\n");
			} else {
				sb.append(2 * sqrt).append("\n");
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
