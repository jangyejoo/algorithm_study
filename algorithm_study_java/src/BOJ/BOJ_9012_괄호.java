package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		C: for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			Stack<Character> s = new Stack<>();
			for (char c : input) {
				if (c == '(') {
					s.push(c);
				} else {
					if (!s.empty())
						s.pop();
					else {
						System.out.println("NO");
						continue C;
					}
				}
			}

			if (s.empty())
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}

}
