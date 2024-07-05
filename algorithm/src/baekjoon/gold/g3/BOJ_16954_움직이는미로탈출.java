package baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16954_움직이는미로탈출 {

	static boolean isPossible = false;

	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		char[][] map = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String row = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = row.charAt(j);

				if (map[i][j] == '#')
					cnt++;
			}
		}

//		init done

//		처음 시작 위치 (7, 0)
//		도착 위치 (0, 7)

		play(map, 7, 0, cnt);

		System.out.println(isPossible ? 1 : 0);

	}

	private static boolean play(char[][] map, int x, int y, int wall) {
//		벽이 다 사라질 때까지 버티면 도착할 수 있음
		if (wall == 0) {
			return isPossible = true;
		}

//		욱제가 이동한 뒤 변화할 맵의 모습 저장
		char[][] temp = new char[8][8];

//		맨 위칸은 빈 공간
		Arrays.fill(temp[0], '.');

//		다른 것들은 한칸씩 내림
		int cnt = 0;
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				temp[i][j] = map[i - 1][j];

				if (temp[i][j] == '#')
					cnt++;
			}
		}

		for (int d = 0; d < 9; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8)
				continue;

			if (map[nx][ny] != '.')
				continue;

//			만약, 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없음
			if (temp[nx][ny] != '.')
				continue;

//			욱제 이동
			play(temp, nx, ny, cnt);
		}

		return false;

	}

}
