package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1239_차트 {

	static int max = 0;
	static int[] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] input = new int[51];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num > 50) {
				System.out.println(0);
				return;
			}

			input[num]++;
		}

//		init done

//		순열
		numbers = new int[n];
		permutation(input, n, 1);

		System.out.println(max);

	}

	private static void permutation(int[] input, int n, int cnt) {
		if (cnt == n) {
			int ans = 0;
			int[] array = new int[101];
			for (int i = 0; i < n; i++) {
				array[numbers[i]] = 1;
			}

			for (int i = 0; i <= 50; i++) {
				if (array[i] == 0)
					continue;

				if (array[i + 50] == 1)
					ans++;
			}

			max = Math.max(max, ans);
			return;
		}

		for (int i = 1; i <= 50; i++) {
			if (input[i] == 0)
				continue;

			numbers[cnt] = numbers[cnt - 1] + i;
			input[i]--;

			permutation(input, n, cnt + 1);
			input[i]++;
		}
	}

}
