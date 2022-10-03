package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10818_최소최대 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		String strNum = br.readLine();
		StringTokenizer st = new StringTokenizer(strNum);
		int max = -1000000;
		int min = 1000000;
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (max < num[i])
				max = num[i];
			if (min > num[i])
				min = num[i];
		}
		System.out.println(min + " " + max);
	}

}
