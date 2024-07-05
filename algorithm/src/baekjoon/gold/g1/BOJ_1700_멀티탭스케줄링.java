package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1700_멀티탭스케줄링 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] multitap = new int[n];
		int[] plug = new int[k + 1];
		st = new StringTokenizer(br.readLine().trim());

		for (int i = 1; i <= k; i++) {
			plug[i] = Integer.parseInt(st.nextToken());
		}

//		init done

		int cnt = 0;

		C: for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if (multitap[j] == 0 || multitap[j] == plug[i]) {
					multitap[j] = plug[i];
					continue C;
				}
			}
//			만약에 멀티탭에 자리가 없으면 하나를 빼자
			multitap[findNotUsing(multitap, plug, i)] = plug[i];
			cnt++;
		}
		System.out.println(cnt);
	}

	private static int findNotUsing(int[] multitap, int[] input, int idx) {
		int max = -1;
		int selected = -1;
		C :for (int i = 0; i < multitap.length; i++) {
			for (int j = idx; j < input.length; j++) {
				if (input[j] == multitap[i]) {
					if (max < j) {
						max = j;
						selected = i;
					}
					continue C;
				}
			}
//			만약 또 다시 쓸 일이 없다면
			return i;
		}
		return selected;
	}

}
