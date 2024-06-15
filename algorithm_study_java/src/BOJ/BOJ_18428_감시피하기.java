package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18428_감시피하기 {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int n;
	static char[][] map;
	static List<int[]> empty;
	static List<int[]> students;
	static List<int[]> teachers;

	static int[] obstacles = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		empty = new ArrayList<>();
		students = new ArrayList<>();
		teachers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);

				if ('S' == map[i][j]) {
					students.add(new int[] { i, j });
					continue;
				}

				if ('T' == map[i][j]) {
					teachers.add(new int[] { i, j });
					continue;
				}

				empty.add(new int[] { i, j });
			}
		}

//		init done

//		조합
		if (combination(0, 0)) {
			System.out.println("YES");
			return;
		}

		System.out.println("NO");

	}

	private static boolean combination(int idx, int cnt) {
		if (cnt == 3) {
//			모든 학생들이 감시로부터 피해지는지 검사
			int[][] map = new int[n][n];

//			학생 1
			for (int[] student : students) {
				map[student[0]][student[1]] = 1;
			}

//			장애물 2
			for (int i = 0; i < 3; i++) {
				int pos = obstacles[i];
				map[pos / 10][pos % 10] = 2;
			}

//			선생님
			for (int[] teacher : teachers) {
//				상하좌우로 검색하며 무엇을 먼저 만나는지?
				for (int d = 0; d < 4; d++) {
					int x = teacher[0];
					int y = teacher[1];

					while (true) {
						int nx = x + dx[d];
						int ny = y + dy[d];

						if (nx < 0 || ny < 0 || nx >= n || ny >= n)
							break;

//						학생 먼저 만남
						if (map[nx][ny] == 1)
							return false;

//						장애물 먼저 만남
						if (map[nx][ny] == 2) {
							break;
						}

						x = nx;
						y = ny;
					}
				}
			}

//			여기까지 오면 장애물 3개로 숨기 가능!
			return true;
		}

		for (int i = idx, size = empty.size(); i < size; i++) {
			int[] pos = empty.get(i);
			obstacles[cnt] = pos[0] * 10 + pos[1];

			if (combination(i + 1, cnt + 1))
				return true;
		}

		return false;
	}

}
