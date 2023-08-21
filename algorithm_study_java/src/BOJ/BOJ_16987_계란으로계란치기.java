package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_계란으로계란치기 {

	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] eggs = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			eggs[i][0] = durability;
			eggs[i][1] = weight;
		}

		// init done

		play(eggs, 0, n, 0);

		System.out.println(ans);

	}

	private static void play(int[][] eggs, int idx, int n, int broken) {
		// 계란을 더 이상 깰 수 없을 때, 깰만큼 깼다!
		if (broken >= n - 1)
			return;

		// 가장 최근에 들었던 계란이 제일 오른쪽에 있던 계란이면 ans 갱신 후 return
		if (idx == n) {
			ans = Math.max(ans, broken);
			return;
		}

		// 이제 손에 들 계란이 이미 깨진 계란이면 다음 계란을 들자!
		if (eggs[idx][0] <= 0) {
			play(eggs, idx + 1, n, broken);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (eggs[i][0] <= 0 || i == idx) {
				continue;
			}

			eggs[idx][0] -= eggs[i][1];
			eggs[i][0] -= eggs[idx][1];

			int cnt = 0;
			if (eggs[idx][0] <= 0)
				cnt++;
			if (eggs[i][0] <= 0)
				cnt++;

			// 깨진 달걀 개수 갱신
			ans = Math.max(ans, (broken + cnt));
			play(eggs, idx + 1, n, broken + cnt);

			eggs[idx][0] += eggs[i][1];
			eggs[i][0] += eggs[idx][1];

		}

	}

}
