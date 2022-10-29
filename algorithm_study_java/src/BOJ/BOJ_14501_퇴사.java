package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {

	static int ans = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n + 1];
		int[] P = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

//		init done

		meeting(T, P, n, 1, 0);

		System.out.println(ans);
	}

	private static void meeting(int[] t, int[] p, int n, int start, int sum) {
		if (start > n) {
			ans = Math.max(sum, ans);
			return;
		}
		if (start + t[start] > n + 1) {
			meeting(t, p, n, start + 1, sum);
		} else {
			meeting(t, p, n, start + t[start], sum + p[start]);
			meeting(t, p, n, start + 1, sum);
		}
	}

}
