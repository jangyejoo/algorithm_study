package BOJ;

import java.io.*;

public class BOJ_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int ans = 0;

		if (n % 5 == 0) {
			sb.append(n / 5);
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			return;
		}

		while (n > 0) {
			n -= 3;
			ans++;
			if (n % 5 == 0) {
				ans += n / 5;
				break;
			} else if (n == 1 || n == 2) {
				ans = -1;
				break;
			} else if (n == 0) {
				break;
			}

		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
