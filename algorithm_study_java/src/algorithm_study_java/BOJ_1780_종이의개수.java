package algorithm_study_java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

	static int[][] p;
	static int zero = 0;
	static int one = 0;
	static int _one = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		p = new int[N][N];
		for (int i = 0; i < N; i++) {
			String l = br.readLine();
			StringTokenizer st = new StringTokenizer(l);
			for (int j = 0; j < N; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/*
		 * 일정 범위에 있는 p가 다르면 9개로 쪼갠다.
		 */

		recursion(0, 0, N);

		System.out.println(_one);
		System.out.println(zero);
		System.out.println(one);

	}

	static public void recursion(int i, int j, int size) {
		boolean isPaper = true;
		for (int k = i; k < i + size; k++) {
			for (int k2 = j; k2 < j + size; k2++) {
				if (p[i][j] != p[k][k2])
					isPaper = false;
			}
		}
		if (isPaper) {
			if (p[i][j] == 1) {
				one++;
			} else if (p[i][j] == 0) {
				zero++;
			} else {
				_one++;
			}
			return;
		}

		int num = size / 3;
		for (int k = 0; k < 3; k++) {
			for (int k2 = 0; k2 < 3; k2++) {
				recursion(i + num * k, j + num * k2, size / 3);
			}
		}
	}

}
