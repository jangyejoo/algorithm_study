package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16472_고냥이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();

		int size = input.length();

//		알파벳 큐 배열
		Queue<Integer>[] alphabet = new Queue[26];
		for (int i = 0; i < 26; i++) {
			alphabet[i] = new LinkedList<>();
		}

//		알파벳이 바뀌는 지점을 저장한 배열
		Queue<Integer> changePoint = new LinkedList<>();

//		배열 초기화
		int cnt = 1;
		changePoint.offer(0);
		alphabet[input.charAt(0) - 'a'].offer(1);
		for (int i = 1; i < size; i++) {
			if (input.charAt(i - 1) != input.charAt(i)) {
				changePoint.offer(i);
				alphabet[input.charAt(i) - 'a'].offer(++cnt);
			}
		}

		int ans = 0;
		int cur = 0;
		while (cur < size) {
			char curLetter = input.charAt(cur);
			char startLetter = input.charAt(changePoint.peek());

			if (alphabet[curLetter - 'a'].peek() - alphabet[startLetter - 'a'].peek() < n) {
				cur++;
			} else {
//				여기서부터 딱 못 읽을 때
//				큐 갱신
				changePoint.poll();
				alphabet[startLetter - 'a'].poll();
			}

//			정답 갱신
			ans = Math.max(ans, cur - changePoint.peek());

		}

		ans = Math.max(ans, size - changePoint.peek());
		System.out.println(ans);
//
//		int start = 0;
//		int end = 0;
//		int cnt = 1;
//		int ans = 1;
//
//		int[] alphabet = new int[26];
//		alphabet[input.charAt(0) - 'a']++;
//
//		while (end < size - 1) {
//			end++;
//
//			if (alphabet[input.charAt(end) - 'a']++ == 0)
//				cnt++;
//
//			while (cnt > n && start < end) {
//				if (--alphabet[input.charAt(start++) - 'a'] == 0)
//					cnt--;
//			}
//
//			ans = Math.max(ans, end - start + 1);
//		}
//
//		System.out.println(ans);

	}

}
