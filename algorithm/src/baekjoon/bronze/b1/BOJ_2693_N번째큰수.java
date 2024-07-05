package baekjoon.bronze.b1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2693_N번째큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int[] nums = new int[10];
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			sb.append(nums[7]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
