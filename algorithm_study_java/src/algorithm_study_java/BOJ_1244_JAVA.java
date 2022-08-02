package algorithm_study_java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_JAVA {

	static int n;
	static int[] s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		s = new int[n + 1];

		String str1 = in.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		for (int i = 1; i <= n; i++) {
			s[i] = Integer.parseInt(st1.nextToken());
		}

		int students = Integer.parseInt(in.readLine());

		for (int i = 0; i < students; i++) {
			String str2 = in.readLine();
			StringTokenizer st2 = new StringTokenizer(str2);
			int g = Integer.parseInt(st2.nextToken());
			if (g == 1) {
				// 남자일 때
				int idx = Integer.parseInt(st2.nextToken());
				m(idx, idx);
			} else {
				// 여자일 때
				int idx = Integer.parseInt(st2.nextToken());
				toggle(idx);
				w(idx, 1);
			}

		}

		for (int i = 1; i <= n; i++) {
			System.out.print(s[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	}

	private static void toggle(int idx) {
		if (s[idx] == 1)
			s[idx] = 0;
		else
			s[idx] = 1;
	}

	private static void m(int idx, int plus) {
		if (idx > n) {
			return;
		}
		toggle(idx);
		m(idx + plus, plus);
	}

	private static void w(int idx, int pm) {
		if (idx + pm > n || idx - pm < 1) {
			return;
		}
		if (s[idx - pm] == s[idx + pm]) {
			toggle(idx - pm);
			toggle(idx + pm);
		} else {
			// 다르면 그냥 끝내
			return;
		}
		w(idx, pm + 1);
	}

}