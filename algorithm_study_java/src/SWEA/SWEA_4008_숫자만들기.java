package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {

	static int n, min, max, nums[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] input = new int[4]; // + - * /
		int[] last = new int[4];
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				last[i] = input[i];
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int[] pmmd = new int[n - 1];
			min = 100000000;
			max = -100000001;

//			init done

			permutation(input, last, pmmd, 0, n - 1);

			sb.append(Math.abs(max - min)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void permutation(int[] input, int[] last, int[] pmmd, int cnt, int size) {
		if (cnt == size) {
			int result = calc(pmmd);
			if (result > max)
				max = result;
			if (result < min)
				min = result;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (last[i] == 0)
				continue;
			pmmd[cnt] = i;
			last[i]--;
			permutation(input, last, pmmd, cnt + 1, size);
			last[i]++;
		}
	}

	private static int calc(int[] pmmd) {
		int result = nums[0];
		for (int i = 0; i < n - 1; i++) {
			switch (pmmd[i]) {
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
