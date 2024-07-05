package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21758_꿀따기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int max = 0;
		int maxIdx = -1;
		int[] honey = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			if (i > 0 && i < n - 1) {
				if (honey[i] > max) {
					max = honey[i];
					maxIdx = i;
				}
			}
		}

		// init done

		int[] hap = new int[n];
		hap[0] = honey[0];
		for (int i = 1; i < n; i++) {
			hap[i] = hap[i - 1] + honey[i];
		}

		int ans = 0;

		// 벌이 왼쪽끝이나 오른쪽끝 중 하나에는 무조건 있음
		// 벌벌꿀 => 왼쪽끝이 벌이고 오른쪽끝이 꿀
		for (int i = 1; i < n; i++) {
			int temp = 0;
			temp += hap[i - 1] - hap[0];
			temp += (hap[n - 1] - hap[i]) * 2;
			ans = Math.max(ans, temp);
		}

		// 꿀벌벌 => 왼쪽끝이 꿀이고 오른쪽끝이 벌
		for (int i = n - 2; i > 0; i--) {
			int temp = 0;
			temp += hap[n - 2] - hap[i];
			temp += hap[i - 1] * 2;
			ans = Math.max(ans, temp);
		}

		// 벌꿀벌 => 양쪽끝이 벌이고 가장 꿀이 많은 곳이 꿀
		int temp = 0;
		temp += hap[n - 2] - hap[0];
		temp += honey[maxIdx];
		ans = Math.max(ans, temp);

		System.out.println(ans);

	}

}
