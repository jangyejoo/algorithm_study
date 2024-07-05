package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int beltSize = 2 * n;
		int[][] belt = new int[beltSize + 1][2];
		List<Integer> robot = new ArrayList<>();
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= beltSize; i++) {
			belt[i][0] = i; // 벨트의 위치!
			belt[i][1] = Integer.parseInt(st.nextToken()); // 벨트의 내구도
		}

		// init done

		int up = 1;
		int down = n;
		int zero = 0;
		int stage = 1;

		while (true) {
			// 벨트 회전
			for (int i = 1; i <= beltSize; i++) {
				belt[i][0] = (belt[i][0] + 1) % beltSize;
				if (belt[i][0] == 0)
					belt[i][0] = beltSize;
				if (belt[i][0] == 1)
					up = i;
				if (belt[i][0] == n)
					down = i;
			}

			// 내리는 위치에 로봇이 있으면 즉시 내려
			if (robot.indexOf(down) != -1) {
				robot.remove(robot.indexOf(down));
			}

			// 벨트 회전 방향으로 한 칸 더 움직일 수 있으면 이동
			for (int i = 0; i < robot.size(); i++) {
				int beltNum = robot.get(i);
				int nextBeltNum = (beltNum + 1) % beltSize;
				if (nextBeltNum == 0)
					nextBeltNum = beltSize;
				// 이동하려는 칸에 로봇이 있거나 내구도가 0이면 넘어가
				if (robot.indexOf(nextBeltNum) != -1 || belt[nextBeltNum][1] == 0)
					continue;
				// 로봇이 이동함
				robot.set(i, nextBeltNum);
				if (--belt[nextBeltNum][1] == 0)
					zero++;

			}

			// 내리는 위치에 로봇이 있으면 즉시 내려
			if (robot.indexOf(down) != -1) {
				robot.remove(robot.indexOf(down));
			}

			// 올리는 위치의 내구도가 0이 아니면 로봇을 올려
			if (belt[up][1] != 0) {
				if (--belt[up][1] == 0)
					zero++;
				robot.add(up);
			}

			// 내구도가 0인 칸의 개수가 k개 이상이면 종료
			if (zero >= k)
				break;

			// 단계 증가
			stage++;

		}

		System.out.println(stage);

	}

}
