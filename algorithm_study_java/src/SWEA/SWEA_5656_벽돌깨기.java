package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {

	static int N, W, H, min;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			init done

			min = Integer.MAX_VALUE;
			go(map, 0);

			sb.append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

//	구슬 던지기 게임
	static boolean go(int[][] map, int cnt) { // map : 직전구슬까지 던진 상태의 배열

		int result = getRemain(map);
		if (result == 0) {////////////////////////////////////////////////////////////////
			min = result;
			return true;
		}

		if (cnt == N) {
//			남은 벽돌 수 카운트 최소값 갱신
			if (min > result)
				min = result;
			return false;
		}

//		구슬 던지기 (중복 순열)
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {

//			구슬에 맞는 시작 벽 찾기
			int r = 0;
			while (r < H && map[r][c] == 0)
				r++;
			if (r == H) { // 맞는 시작벽돌이 없는 상태
				continue; /////////////////////////////////////////////////////////////////
			} else { // 맞는 시작벽돌이 있는 상태

				copy(map, newMap);

//				제거될 벽돌 연쇄 처리
				boom(newMap, r, c);

//				벽돌 중력 처리
				down(newMap);

//				다음 구슬 던지기
				if (go(newMap, cnt + 1))
					return true;////////////////////////////////////////////////////////////////////
			}

		}
		return false;

	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	private static void boom(int[][] map, int r, int c) { // BFS
		Queue<Point> q = new LinkedList<>();

//		벽돌이 있던 자리를 0으로 변경 : 빈칸으로 만들어서 방문처리
		if (map[r][c] > 1) {
			q.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0; // 방문처리

		while (!q.isEmpty()) {
			Point p = q.poll(); // 주변에 영향주는 벽돌 정보

			// 벽돌의 크기-1만큼 주변 벽돌(4방) 연쇄 처리
			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == 0)
						continue;
					if (map[nr][nc] > 1) {
						q.offer(new Point(nr, nc, map[nr][nc]));
					}
					map[nr][nc] = 0; // 방문처리
				}
			}
		}
	}

//	private static void down(int[][] map) {
//		for (int c = 0; c < W; c++) {
//			int r = H - 1;
//			while (r > 0) {
//				if (map[r][c] == 0) { // 빈칸이면 내릴 벽돌 찾기
//					int nr = r - 1;
//					while (nr > 0 && map[nr][c] == 0)
//						nr--;
//					map[r][c] = map[nr][c];
//					map[nr][c] = 0;
//				}
//				r--;
//			}
//		}
//	}

	static Stack<Integer> stack = new Stack<>();

	private static void down(int[][] map) {

		for (int c = 0; c < W; c++) {
//			윗 행부터 남은 벽돌 스택에 넣기
			for (int r = 0; r < H; r++) {
				if (map[r][c] > 0) {
					stack.push(map[r][c]);
					map[r][c] = 0;
				}
			}
			int nr = H - 1;
			while (!stack.isEmpty()) {
				map[nr--][c] = stack.pop();
			}
		}
	}

	private static int getRemain(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					cnt++;
			}
		}
		return cnt;
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}
}
