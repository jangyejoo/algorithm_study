package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] depth = new int[w];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < w; i++) {
			depth[i] = Integer.parseInt(st.nextToken());
		}

//		init done

		int cnt = 0;
		for (int i = 1; i < w - 1; i++) {
			int left = findLeft(depth, w, i); 	// 왼쪽 기둥 찾기
			int right = findRight(depth, w, i); // 오른쪽 기둥 찾기 
			if (left == 0 || right == 0)		// 기둥이 하나라도 없으면 넘어가
				continue;
			int water = Math.min(left, right);	// 둘 중 더 작은 기둥높이만큼 물 채우기
			cnt += (water - depth[i]);
		}
		System.out.println(cnt);
	}

	// 현재 위치보다 왼쪽에 있고 높이가 높은 기둥들 중 최대찾기
	private static int findLeft(int[] depth, int w, int pos) {
		int max = 0;
		int left = pos - 1;
		while (left >= 0) {
			if (depth[pos] < depth[left])
				max = Math.max(max, depth[left]);
			left--;
		}
		return max;
	}
	
	// 현재 위치보다 오른쪽에 있고 높이가 높은 기둥들 중 최대찾기
	private static int findRight(int[] depth, int w, int pos) {
		int max = 0;
		int right = pos + 1;
		while (right < w) {
			if (depth[pos] < depth[right])
				max = Math.max(max, depth[right]);
			right++;
		}
		return max;
	}

}
