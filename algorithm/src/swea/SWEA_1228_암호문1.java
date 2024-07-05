package swea;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			int[] copy = new int[N];
			String inputCode = br.readLine();
			StringTokenizer st = new StringTokenizer(inputCode);
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			int C = Integer.parseInt(br.readLine());
			String command = br.readLine();
			StringTokenizer st2 = new StringTokenizer(command);
			for (int i = 0; i < C; i++) {
				if (st2.nextToken().equals("I")) {
					int x = Integer.parseInt(st2.nextToken());
					int y = Integer.parseInt(st2.nextToken());
					int idx = 0;
					for (int j = 0; j < x; j++) {
						if (idx > N - 1)
							break;
						copy[idx++] = nums[j];
					}
					for (int j = 0; j < y; j++) {
						int addCode = Integer.parseInt(st2.nextToken());
						if (idx > N - 1) {
						} else {
							copy[idx++] = addCode;
						}
					}
					for (int j = idx; j < N; j++) {
						copy[j] = nums[x++];
					}
//					System.out.println(Arrays.toString(copy));
					nums = Arrays.copyOf(copy, copy.length);
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(copy[i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
