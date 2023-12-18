package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19539_사과나무 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int one = 0;
		int two = 0;
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			one += (num % 2);
			two += (num / 2);
		}

		// init done

		if (one > two) {
			System.out.println("NO");
		} else if (one == two) {
			System.out.println("YES");
		} else {
			// 만약 two가 one보다 많으면 two 한 개를 one 두 개로 쪼갤 수 있음
			// 예시) two가 4 one이 1이면 two 3, one 3으로 맞출 수 있음
			// TWO - y == ONE + 2y
			// TWO - ONE == 3y
			// 근데 y는 정수이므로 TWO - ONE은 3의 배수
			if ((two - one) % 3 == 0)
				System.out.println("YES");
			else

				System.out.println("NO");
		}

	}

}
