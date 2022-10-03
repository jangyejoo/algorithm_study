package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_5644_무선충전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			String ma = br.readLine();
			StringTokenizer st = new StringTokenizer(ma);
			int m = Integer.parseInt(st.nextToken()); // 총 이동 시간
			int a = Integer.parseInt(st.nextToken()); // BC의 개수

			int[] moveA = new int[m + 1]; // A의 이동 경로
			int[] moveB = new int[m + 1]; // B의 이동 경로

			String inputA = br.readLine();
			st = new StringTokenizer(inputA);
			for (int i = 1; i <= m; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			String inputB = br.readLine();
			st = new StringTokenizer(inputB);
			for (int i = 1; i <= m; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			int[][] bc = new int[a + 1][4]; // BC의 정보
			int[][][] map = new int[11][11][1]; // 전체 맵

			int dx[] = { 1, 0, -1, 0 };
			int dy[] = { 0, 1, 0, -1 };

			for (int i = 1; i <= a; i++) {
				String inputBC = br.readLine();
				st = new StringTokenizer(inputBC);
				bc[i][0] = Integer.parseInt(st.nextToken()); // BC의 x 좌표
				bc[i][1] = Integer.parseInt(st.nextToken()); // BC의 y 좌표
				bc[i][2] = Integer.parseInt(st.nextToken()); // BC의 충전 범위
				bc[i][3] = Integer.parseInt(st.nextToken()); // BC의 처리량

				Queue<int[]> q = new LinkedList<int[]>();
				q.offer(bc[i]);
				while (!q.isEmpty()) {
					int x = q.peek()[0];
					int y = q.peek()[1];
					map[x][y][0] = map[x][y][0] | (1 << i);
					q.poll();
					for (int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if (nx < 1 || ny < 1 || nx > 10 || ny > 10)
							continue; // 맵을 초과하면 넘겨
						if (Math.abs(nx - bc[i][0]) + Math.abs(ny - bc[i][1]) > bc[i][2])
							continue; // 범위를 초과하면 넘겨
						if ((map[nx][ny][0] & (1 << i)) != 0)
							continue; // 이미 지나간 곳이면 넘겨
						int[] next = { nx, ny };
						q.offer(next);
					}
				}
			}

//			init done

			int[] curA = { 1, 1 }; // A의 현재 위치
			int[] curB = { 10, 10 }; // B의 현재 위치
			int chargeA = 0; // A의 충전량
			int chargeB = 0; // B의 충전량
			for (int i = 0; i <= m; i++) {
				switch (moveA[i]) {
				case 4: // 상
					curA[0] = curA[0] > 1 ? curA[0] - 1 : curA[0];
					break;
				case 3: // 우
					curA[1] = curA[1] < 10 ? curA[1] + 1 : curA[1];
					break;
				case 2: // 하
					curA[0] = curA[0] < 10 ? curA[0] + 1 : curA[0];
					break;
				case 1: // 좌
					curA[1] = curA[1] > 1 ? curA[1] - 1 : curA[1];
					break;
				default:
					break;
				}
				switch (moveB[i]) {
				case 4: // 상
					curB[0] = curB[0] > 1 ? curB[0] - 1 : curB[0];
					break;
				case 3: // 우
					curB[1] = curB[1] < 10 ? curB[1] + 1 : curB[1];
					break;
				case 2: // 하
					curB[0] = curB[0] < 10 ? curB[0] + 1 : curB[0];
					break;
				case 1: // 좌
					curB[1] = curB[1] > 1 ? curB[1] - 1 : curB[1];
					break;
				default:
					break;
				}

				int sectionA = map[curA[0]][curA[1]][0];
				int sectionB = map[curB[0]][curB[1]][0];

				List<Integer> chargeSpotA = new ArrayList<Integer>();
				List<Integer> chargeSpotB = new ArrayList<Integer>();
				chargeSpotA.add(0);
				if (sectionA != 0) {
					for (int j = 1; j <= a; j++) {
						if ((sectionA & (1 << j)) != 0) {
							chargeSpotA.add(j);
						}
					}
				}
				if (sectionB != 0) {
					for (int j = 1; j <= a; j++) {
						if ((sectionB & (1 << j)) != 0) {
							chargeSpotB.add(j);
						}
					}
				}
				int maxA = 0;
				int maxB = 0;
				for (int j = 0, size = chargeSpotA.size(); j < size; j++) {
					int size2 = chargeSpotB.size();
					int bcJ = bc[chargeSpotA.get(j)][3];
					if (size2 == 0) {
						maxA = maxA < bcJ ? bcJ : maxA;
						continue;
					}
					for (int j2 = 0; j2 < size2; j2++) {
						int bcJ2 = bc[chargeSpotB.get(j2)][3];
						if (chargeSpotA.get(j) == chargeSpotB.get(j2)) {
							int charging = bcJ / 2;
							if (maxA + maxB < charging * 2) {
								maxA = charging;
								maxB = charging;
							}
						} else {
							if (maxA + maxB < bcJ + bcJ2) {
								maxA = bcJ;
								maxB = bcJ2;
							}
						}
					}
				}

				chargeA += maxA;
				chargeB += maxB;

			}
			sb.append(chargeA + chargeB).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
