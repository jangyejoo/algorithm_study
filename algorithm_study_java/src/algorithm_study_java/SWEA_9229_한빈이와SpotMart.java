package algorithm_study_java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String nm = br.readLine();
			StringTokenizer stNM = new StringTokenizer(nm);
			int N = Integer.parseInt(stNM.nextToken());
			int M = Integer.parseInt(stNM.nextToken());
			int [] snacks = new int [N];
			String W = br.readLine();
			StringTokenizer stW = new StringTokenizer(W);
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(stW.nextToken());
			}
			int max = -1;
			Arrays.sort(snacks);
			for (int i = N-1; i >= 0; i--) {
				int hap = snacks[i];
				if (hap > M) continue;
				for (int j = i-1; j >= 0; j--) {
					int mid = hap + snacks[j];
					if (mid <= M && max < mid) {
						max = mid;
						break;
					}
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
}
