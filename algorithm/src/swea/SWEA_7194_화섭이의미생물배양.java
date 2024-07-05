package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_7194_화섭이의미생물배양 {

	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int s, t, a, b;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken()); // 먹이를 주면 +a
			b = Integer.parseInt(st.nextToken()); // 배양액을 주면 *b
			ans = Integer.MAX_VALUE;

//			init done

			if (b == 1) { // b가 1일 때는 먹이를 주는 선택지밖에 없음
				if ((t - s) % a == 0) {
					ans = (t - s) / a;
				}
			} else {
				calc(s, t, a, b, 0);
			}

			if (ans == Integer.MAX_VALUE)
				sb.append(-1).append("\n");
			else
				sb.append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void calc(int s, int t, int a, int b, int cnt) {
		if (cnt > ans || t < s)
			return;

		if (t == s) {
			if (cnt < ans)
				ans = cnt;
			return;
		}


		if (t % b == 0 && t / b >= s) {
			calc(s, t / b, a, b, cnt + 1);
		} else {
			calc(s, t - a, a, b, cnt + 1);
		}
	}

}
