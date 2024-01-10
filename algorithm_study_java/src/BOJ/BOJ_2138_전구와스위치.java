package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138_전구와스위치 {

	static int n;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int[] bulbInit = new int[n];
		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			bulbInit[i] = (int) (input.charAt(i) - '0');
		}

		int[] result = new int[n];
		input = br.readLine();
		for (int i = 0; i < n; i++) {
			result[i] = (int) (input.charAt(i) - '0');
		}

		// init done

		// 순서 상관 없이 누르는 횟수가 중요함
		// 1번 스위치 안 누른 버전과 누른 버전 두 가지로 생각

		// 1번 스위치 안누름
		int[] bulbs = new int[n];
		for (int i = 0; i < n; i++) {
			bulbs[i] = bulbInit[i];
		}

		push(bulbs, result, 0);

		// 1번 스위치 누름
		for (int i = 0; i < n; i++) {
			if (i < 2)
				bulbs[i] = (bulbInit[i] + 1) % 2;
			else
				bulbs[i] = bulbInit[i];
		}

		push(bulbs, result, 1);

		if (ans == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(ans);

	}

	private static void push(int[] bulbs, int[] result, int cnt) {
		boolean isPossible = true;

		for (int i = 1; i < n; i++) {
			// 바로 앞에 전구가 목표와 다르면 버튼 누름
			if (bulbs[i - 1] != result[i - 1]) {
				bulbs[i - 1] = (bulbs[i - 1] + 1) % 2;
				bulbs[i] = (bulbs[i] + 1) % 2;

				if (i < n - 1)
					bulbs[i + 1] = (bulbs[i + 1] + 1) % 2;

				cnt++;
			}
		}

		for (int i = 0; i < n; i++) {
			if (bulbs[i] != result[i]) {
				isPossible = false;
				break;
			}
		}

		if (isPossible)
			ans = Math.min(ans, cnt);

		return;
	}

}
