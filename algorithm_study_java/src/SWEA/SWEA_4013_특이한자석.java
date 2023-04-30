package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {

	static int[] m1 = new int[9];
	static int[] m2 = new int[9];
	static int[] m3 = new int[9];
	static int[] m4 = new int[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= 8; i++) {
				m1[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= 8; i++) {
				m2[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= 8; i++) {
				m3[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= 8; i++) {
				m4[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int mNum = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());

				switch (mNum) {
				case 1:
//					1번 자석 돌리기
					if (m1[3] != m2[7]) {
						if (m2[3] != m3[7]) {
							if (m3[3] != m4[7]) {
								rotate4(direction * -1);
							}
							rotate3(direction);
						}
						rotate2(direction * -1);
					}
					rotate1(direction);
					break;
				case 2:
//					2번 자석 돌리기
					if (m2[3] != m3[7]) {
						if (m3[3] != m4[7]) {
							rotate4(direction);
						}
						rotate3(direction * -1);
					}
					if (m2[7] != m1[3]) {
						rotate1(direction * -1);
					}
					rotate2(direction);
					break;
				case 3:
//					3번 자석 돌리기
					if (m3[3] != m4[7]) {
						rotate4(direction * -1);
					}
					if (m3[7] != m2[3]) {
						if (m2[7] != m1[3]) {
							rotate1(direction);
						}
						rotate2(direction * -1);
					}
					rotate3(direction);
					break;
				case 4:
//					4번 자석 돌리기
					if (m4[7] != m3[3]) {
						if (m3[7] != m2[3]) {
							if (m2[7] != m1[3]) {
								rotate1(direction * -1);
							}
							rotate2(direction);
						}
						rotate3(direction * -1);
					}
					rotate4(direction);
					break;

				}
			}

			int result = 0;
			if (m1[1] == 1)
				result += 1;
			if (m2[1] == 1)
				result += 2;
			if (m3[1] == 1)
				result += 4;
			if (m4[1] == 1)
				result += 8;
			sb.append("#").append(tc).append(" ").append(result).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void rotate4(int d) {
		if (d == 1) {
			int tmp = m4[8];
			for (int i = 7; i >= 1; i--) {
				m4[i + 1] = m4[i];
			}
			m4[1] = tmp;
		} else {
			int tmp = m4[1];
			for (int i = 2; i <= 8; i++) {
				m4[i - 1] = m4[i];
			}
			m4[8] = tmp;
		}
	}

	private static void rotate3(int d) {
		if (d == 1) {
			int tmp = m3[8];
			for (int i = 7; i >= 1; i--) {
				m3[i + 1] = m3[i];
			}
			m3[1] = tmp;
		} else {
			int tmp = m3[1];
			for (int i = 2; i <= 8; i++) {
				m3[i - 1] = m3[i];
			}
			m3[8] = tmp;
		}
	}

	private static void rotate2(int d) {
		if (d == 1) {
			int tmp = m2[8];
			for (int i = 7; i >= 1; i--) {
				m2[i + 1] = m2[i];
			}
			m2[1] = tmp;
		} else {
			int tmp = m2[1];
			for (int i = 2; i <= 8; i++) {
				m2[i - 1] = m2[i];
			}
			m2[8] = tmp;
		}
	}

	private static void rotate1(int d) {
		if (d == 1) {
			int tmp = m1[8];
			for (int i = 7; i >= 1; i--) {
				m1[i + 1] = m1[i];
			}
			m1[1] = tmp;
		} else {
			int tmp = m1[1];
			for (int i = 2; i <= 8; i++) {
				m1[i - 1] = m1[i];
			}
			m1[8] = tmp;
		}
	}

}
