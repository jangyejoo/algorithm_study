package BOJ;

import java.io.*;

public class BOJ_2562_최댓값 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int idx = 0;
		int [] nums = new int[9];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			
			if (nums[i] > max) {
				max = nums[i];
				idx = i;
			}
		}
		sb.append(max).append("\n").append(idx+1);
		System.out.println(sb);
	}
	
}
