package baekjoon.gold.g4;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		PriorityQueue<Integer> decks = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			decks.add(Integer.parseInt(br.readLine()));
		}
		
		while(decks.size()>1) {
			int A = decks.poll();
			int B = decks.poll();
			ans += A+B;
			if (!decks.isEmpty()) 
				decks.add(A+B);
		}

		System.out.println(ans);

	}
}
