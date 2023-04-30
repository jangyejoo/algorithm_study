package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		List<int []> input = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input.add(new int [] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		
//		init done
		
		int ans = Integer.MAX_VALUE;
		int [] cost = new int [3];
		cost[0] = input.get(0)[0];
		cost[1] = input.get(0)[1];
		cost[2] = input.get(0)[2];
		
		for (int i = 1; i <= n-1; i++) {
			int red = cost[0];
			int green = cost[1];
			int blue = cost[2];
			cost[0] = Math.min(input.get(i)[0] + green, input.get(i)[0] + blue);
			cost[1] = Math.min(input.get(i)[1] + red, input.get(i)[1] + blue);
			cost[2] = Math.min(input.get(i)[2] + red, input.get(i)[2] + green);
		}
		
		System.out.println(Math.min(Math.min(cost[0], cost[1]), cost[2]));
		
	}
}
