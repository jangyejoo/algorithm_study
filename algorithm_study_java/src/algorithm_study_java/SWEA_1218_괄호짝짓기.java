package algorithm_study_java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int l = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			Stack<String> stack = new Stack<>();
			boolean isPossible = true;
			for (int i = 0; i < input.length; i++) {
				if (input[i] == '(' || input[i] == '[' || input[i] == '{' || input[i] == '<') {
					// 여는 괄호일 때
					stack.push(input[i] + "");
				} else {
					// 닫는 괄호일 때
					switch (input[i]) {
					case ')':
						if (stack.peek().equals("(")) {
							stack.pop();
						} else {
							isPossible = false;
						}
						break;
					case ']':
						if (stack.peek().equals("[")) {
							stack.pop();
						} else {
							isPossible = false;
						}
						break;
					case '}':
						if (stack.peek().equals("{")) {
							stack.pop();
						} else {
							isPossible = false;
						}
						break;
					case '>':
						if (stack.peek().equals("<")) {
							stack.pop();
						} else {
							isPossible = false;
						}
						break;

					}

				}
			}
			if (stack.size() > 0 && isPossible) {
				isPossible = false;
			}
			sb.append("#").append(t).append(" ").append(isPossible ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}

}
