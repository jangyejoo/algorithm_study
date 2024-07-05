package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이{

	static int[] dwarf = new int[7];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] h = new int[9];
		for (int i = 0; i < 9; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}

//		init done

		Arrays.sort(h);

		combination(h, 0, 0);

		for (int i = 0; i < 7; i++) {
			sb.append(h[dwarf[i]]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static boolean combination(int[] h, int cnt, int start) {
		if (cnt == 7) {
			int hap = 0;
			for (int i = 0; i < 7; i++) {
				hap += h[dwarf[i]];
			}
			if (hap == 100) {
				return true;
			}
			return false;
		}

		for (int i = start; i < 9; i++) {
			dwarf[cnt] = i;
			if (combination(h, cnt + 1, i + 1)) {
				return true;
			}
		}
		return false;

	}

}
