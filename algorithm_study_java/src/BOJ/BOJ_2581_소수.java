package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581_소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		// 에라토스테네스의 체
		int[] nums = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			nums[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (nums[i] == 0)
				continue;
			for (int j = 2 * i; j <= n; j += i) {
				nums[j] = 0;
			}
		}

		int min = 10001;
		int hap = 0;
		for (int i = m; i <= n; i++) {
			if (nums[i] != 0) {
				hap += nums[i];
				min = Math.min(nums[i], min);
			}
		}

		if (hap == 0) {
			System.out.println(-1);
		} else {
			System.out.println(hap);
			System.out.println(min);
		}

	}
}
