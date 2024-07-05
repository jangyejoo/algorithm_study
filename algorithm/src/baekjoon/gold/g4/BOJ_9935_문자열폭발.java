package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935_문자열폭발 {

	static class StringStack {
		StringBuffer str;
		int size;

		public StringStack() {
			str = new StringBuffer();
			size = 0;
		}

		public String toString() {
			return str.toString();
		}

		public void push(char ch) {
			str.append(ch);
			size++;
		}

		public void pop() {
			str.deleteCharAt(size - 1);
			size--;
		}

		public boolean check(String bomb) {
			int idx = size - 1;
			for (int i = bomb.length() - 1; i >= 0; i--) {
				if (str.charAt(idx) != bomb.charAt(i)) {
					return false;
				}
				idx--;
			}
			return true;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String bomb = br.readLine();
		int size = input.length();
		int bombSize = bomb.length();

		// init done

		if (size < bombSize) {
			// input보다 폭발 문자열이 더 길때
			System.out.println(input);
			return;
		}

		StringStack ss = new StringStack();

		for (int i = 0; i < size; i++) {
			char ch = input.charAt(i);
			ss.push(ch);

			if (ss.size >= bombSize) {
				if (ss.check(bomb)) {
					for (int j = 0; j < bombSize; j++) {
						ss.pop();
					}
				}
			}
		}

		String ans = ss.toString();
		if (ans == "" || ans.length() == 0) {
			System.out.println("FRULA");
		} else
			System.out.println(ans);
	}

}
