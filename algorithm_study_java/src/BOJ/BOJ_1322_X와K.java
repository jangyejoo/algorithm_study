package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1322_X와K {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		long x = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		// init done

		String binaryStringX = Long.toBinaryString(x);
		String binaryStringK = Long.toBinaryString(k);

		// reverse
		StringBuffer sbX = new StringBuffer(binaryStringX);
		StringBuffer sbK = new StringBuffer(binaryStringK);

		String reverseX = sbX.reverse().toString();
		String reverseK = sbK.reverse().toString();

		int sizeX = reverseX.length();
		int sizeK = reverseK.length();

		int index = 0;
		int indexK = 0;

		StringBuilder sb = new StringBuilder();

		while (true) {
			if (index >= sizeX || reverseX.charAt(index) == '0') {
				sb.append(reverseK.charAt(indexK));

				if (++indexK == sizeK) {
					break;
				}
			} else {
				sb.append(0);
			}
			index++;
		}

		System.out.println(Long.parseLong(sb.reverse().toString(), 2));

	}

}
