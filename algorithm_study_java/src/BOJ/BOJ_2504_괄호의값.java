package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504_괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] string = br.readLine().toCharArray();
		Stack<Character> st = new Stack<>();
		Stack<Character> nopop = new Stack<>();
		int ans = 0;
		int temp = 1;
		boolean possible = true;
		B: for (char c : string) {
			switch (c) {
			case '(':
				st.push(c);
				nopop.push(c);
				temp *= 2;
				break;
			case ')':
				if (st.isEmpty() || st.peek() != '(') {
					possible = false;
					break B;
				}
				if (nopop.peek() == '(') {
					nopop.push(c);
					ans += temp;
				}
				st.pop();
				temp /= 2;
				break;
			case '[':
				st.push(c);
				nopop.push(c);
				temp *= 3;
				break;
			case ']':
				if (st.isEmpty() || st.peek() != '[') {
					possible = false;
					break B;
				}
				if (nopop.peek() == '[') {
					nopop.push(c);
					ans += temp;
				}
				st.pop();
				temp /= 3;
				break;
			}
		}
		if (!st.isEmpty() || !possible) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}

	}

}
