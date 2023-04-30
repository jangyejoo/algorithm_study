package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {

	static int n, nums[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		int[] input = new int[4];
		int[] last = new int[4];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 4; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			last[i] = input[i];
		}

//		init done

		int[] operator = new int[n - 1];
		permutation(input, last, operator, 0);

		sb.append(max).append("\n");
		sb.append(min).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void permutation(int[] input, int[] last, int[] operator, int cnt) {
		if (cnt == n - 1) {
			int result = calc(operator);
			if (result > max)
				max = result;
			if (result < min)
				min = result;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (last[i] == 0)
				continue;
			operator[cnt] = i;
			last[i]--;
			permutation(input, last, operator, cnt + 1);
			last[i]++;

		}
	}

	private static int calc(int[] operator) {
		int result = nums[0];
		for (int i = 0; i < operator.length; i++) {
			switch (operator[i]) {
			case 0:
				result += nums[i + 1];
				break;
			case 1:
				result -= nums[i + 1];
				break;
			case 2:
				result *= nums[i + 1];
				break;
			case 3:
				result /= nums[i + 1];
				break;
			}
		}
		return result;
	}
}
