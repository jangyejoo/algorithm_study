package baekjoon.gold.g4;

import java.io.*;
import java.util.*;

public class BOJ_3055_탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];

		Queue<int[]> water = new LinkedList<int[]>();
		Queue<int[]> curPos = new LinkedList<int[]>();
		int xD = 0;
		int yD = 0;
		for (int i = 0; i < R; i++) {
			char[] chArr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = chArr[j];
				if (map[i][j] == '*') {
					int[] input = { i, j };
					water.offer(input);
				} else if (map[i][j] == 'S') {
					int[] input = { i, j };
					curPos.offer(input);
				} else if (map[i][j] == 'D') {
					xD = i;
					yD = j;
				}
			}
		}

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };

//		일단 물 기준으로 bfs 돌리고 거리 표시
//		그 다음 고슴도치 이동 시키자

		int[][] distanceW = new int[R][C];
		int[][] distanceG = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					distanceW[i][j] = 0;
				} else if (map[i][j] == 'S') {
					distanceG[i][j] = 0;
					distanceW[i][j] = -1;
				} else {
					distanceW[i][j] = -1;
					distanceG[i][j] = -1;
				}
			}
		}

		while (!water.isEmpty()) {
			int x = water.peek()[0];
			int y = water.peek()[1];
			water.poll();
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue; // 맵을 벗어나면 넘어가
				if (map[nx][ny] == 'X' || map[nx][ny] == 'D')
					continue; // 돌이거나 비버의 굴이면 넘어가
				if (distanceW[nx][ny] != -1)
					continue; // 지나왔던 곳이면 넘어가
				distanceW[nx][ny] = distanceW[x][y] + 1;
				int[] nxt = { nx, ny };
				water.offer(nxt);
			}
		}

		while (!curPos.isEmpty()) {
			int x = curPos.peek()[0];
			int y = curPos.peek()[1];
			curPos.poll();
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue; // 맵을 벗어나면 넘어가
				if (map[nx][ny] == 'X')
					continue; // 돌이면 넘어가
				if (distanceG[nx][ny] != -1)
					continue; // 지나왔던 곳이면 넘어가
				if (distanceW[nx][ny] != -1 && distanceG[x][y] + 1 >= distanceW[nx][ny])
					continue; // 물이 찰 곳이면 넘어가
				distanceG[nx][ny] = distanceG[x][y] + 1;
				int[] nxt = { nx, ny };
				curPos.offer(nxt);
			}
		}

		int ans = distanceG[xD][yD];
		if (ans == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(ans);
		}
	}

}
