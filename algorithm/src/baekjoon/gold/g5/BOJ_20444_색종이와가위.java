package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20444_색종이와가위 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

//		init done

//		x + y = n
//		(x + 1) * (n - x + 1) = k

		long left = 0;
		long right = n / 2;
		while (left <= right) {
			long mid = (left + right) / 2;
			long temp = (mid + 1) * (n - mid + 1);

			if (temp == k) {
				System.out.println("YES");
				return;
			}

			if (temp < k)
				left = mid + 1;
			else
				right = mid - 1;

		}

		System.out.println("NO");

//		ver2. 근의 공식 이용
//		double temp = (n * n) - 4 * (k - n - 1);
//		if (temp < 0) {
//			System.out.println("NO");
//			return;
//		}
//
//		temp = Math.sqrt(temp);
//		if (Math.floor(temp) != temp) {
//			System.out.println("NO");
//			return;
//		}
//
//		double root1 = (n + temp) / 2.0;
//		double root2 = (n - temp) / 2.0;
//
//		if (isAnswer(root1, n) && isAnswer(root2, n))
//			System.out.println("YES");
//		else
//			System.out.println("NO");

	}

//	private static boolean isAnswer(double number, long n) {
//		if (Math.floor(number) == number && number >= 0 && number <= n)
//			return true;
//		else
//			return false;
//	}

}
