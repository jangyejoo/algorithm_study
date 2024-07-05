package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1091_카드섞기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] p = new int[n];
		int[] s = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			// 맨 처음 i번째 위치에 있던 카드를 P[i]에게 보내야 함
			p[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			// 카드를 섞는 규칙
			s[i] = Integer.parseInt(st.nextToken());
		}

		// init done

		int[] init = new int[n];
		for (int i = 0; i < n; i++) {
			init[i] = p[i];
		}

		int cnt = 0;
		while (true) {
			// 바르게 배치되었는지 확인
			boolean isComplete = true;
			for (int i = 0; i < n; i++) {
				if (p[i] != i % 3) {
					isComplete = false;
					break;
				}
			}
			if (isComplete) {
				break;
			}

			// 셔플을 아무리 돌고 돌아서 원래 모양으로 돌아왔는지 확인
			if (cnt > 0) {
				boolean isImpossible = true;
				for (int i = 0; i < n; i++) {
					if (p[i] != init[i]) {
						isImpossible = false;
						break;
					}
				}
				if (isImpossible) {
					System.out.println(-1);
					return;
				}
			}

			// 카드 셔플
			int[] cards = new int[n];
			for (int i = 0; i < n; i++) {
				cards[s[i]] = p[i];
			}
			for (int i = 0; i < n; i++) {
				p[i] = cards[i];
			}
			cnt++;
		}

		System.out.println(cnt);

	}

}
