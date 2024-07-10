package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20366_같이눈사람만들래 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] snowballs = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			snowballs[i] = Integer.parseInt(st.nextToken());
		}

//		init done

//		눈덩이를 크기 순으로 정렬
		Arrays.sort(snowballs);

		int gap = Integer.MAX_VALUE;

//		엘자 눈사람을 기준으로
		for (int elsaH = 0; elsaH < n - 3; elsaH++) {
			for (int elsaB = elsaH + 3; elsaB < n; elsaB++) {
				int elsaSnowman = snowballs[elsaH] + snowballs[elsaB];

				int annaH = elsaH + 1;
				int annaB = elsaB - 1;

				while (annaH < annaB) {
					int annaSnowman = snowballs[annaH] + snowballs[annaB];

//					gap 갱신
					gap = Math.min(gap, Math.abs(annaSnowman - elsaSnowman));

//					최소최소최솟값
					if (annaSnowman == elsaSnowman) {
						System.out.println(0);
						return;
					}

//					엘자 눈사람이 더 크면
					if (annaSnowman < elsaSnowman) {
						annaH++;
						continue;
					}

					annaB--;
				}
			}
		}

		System.out.println(gap);

	}

}
