package BOJ;

import java.io.*;

public class BOJ_3040_백설공주와일곱난쟁이 {

	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int[] nums = new int[9];
		int[] result = new int[7];
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		combination(result, nums, 0, 0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void combination(int[] result, int[] nums, int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int i = 0; i < result.length; i++) {
					sb.append(result[i]).append("\n");
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			result[cnt] = nums[i];
			combination(result, nums, cnt + 1, i + 1, sum + result[cnt]);
		}
	}

}
