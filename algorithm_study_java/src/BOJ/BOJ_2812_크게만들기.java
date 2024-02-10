package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] number = new int[n];
		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			number[i] = input.charAt(i) - '0';
		}

//		init done

		Stack<Integer> s = new Stack<>();
		s.push(number[0]);

		for (int i = 1; i < n; i++) {
			int num = number[i];

//			1. 스택이 empty가 되면 멈춤
//			2. num보다 top이 크면 멈춤
//			3. 스택에 넣은 숫자 개수 + 남은 숫자 개수가 딱 맞으면 멈춤

//			그니까 결국엔 (n-k)자리의 숫자를 완성시키는 조건도 만족하면서
//			가장 큰 숫자를 앞자리에 넣기 위해서 pop을 반복함
			while (!s.isEmpty() && s.peek() < num && s.size() + k - i > 0) {
				s.pop();
			}

//			숫자를 더 추가해도 되면 push
			if (s.size() < n - k)
				s.push(num);
		}

		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb.reverse());

	}

}
