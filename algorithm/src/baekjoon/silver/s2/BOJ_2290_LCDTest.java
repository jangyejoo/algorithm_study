package baekjoon.silver.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290_LCDTest {

	static char[][] answer;
	static char[] n;
	static int s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken());
		n = st.nextToken().toCharArray();
		int cnt = n.length;
		answer = new char[(2 * s + 3)][cnt * (s + 3)];
		for (int i = 0; i < 2 * s + 3; i++) {
			for (int j = 0; j < n.length * (s + 3); j++) {
				answer[i][j] = ' ';
			}
		}

//		init done

		for (int i = 0; i < cnt; i++) {
//			ver 1) 12,643 kb 144 ms
//			if (n[i] != '1' && n[i] != '4')
//				drawRow(i * (s + 3), "T");
//			if (n[i] != '1' && n[i] != '7' && n[i] != '0')
//				drawRow(i * (s + 3), "M");
//			if (n[i] != '1' && n[i] != '4' && n[i] != '7')
//				drawRow(i * (s + 3), "B");
//			if (n[i] != '5' && n[i] != '6')
//				drawColumn(i * (s + 3), "RT");
//			if (n[i] != '2')
//				drawColumn(i * (s + 3), "RB");
//			if (n[i] != '1' && n[i] != '2' && n[i] != '3' && n[i] != '7')
//				drawColumn(i * (s + 3), "LT");
//			if (n[i] == '0' || n[i] == '2' || n[i] == '6' || n[i] == '8')
//				drawColumn(i * (s + 3), "LB");

//			ver 2) 12,576 kb 136 ms
			switch (n[i]) {
			case '1':
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "RB");
				break;
			case '2':
				drawRow(i * (s + 3), "T");
				drawRow(i * (s + 3), "M");
				drawRow(i * (s + 3), "B");
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "LB");
				break;
			case '3':
				drawRow(i * (s + 3), "T");
				drawRow(i * (s + 3), "M");
				drawRow(i * (s + 3), "B");
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "RB");
				break;
			case '4':
				drawRow(i * (s + 3), "M");
				drawColumn(i * (s + 3), "LT");
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "RB");
				break;
			case '5':
				drawRow(i * (s + 3), "T");
				drawRow(i * (s + 3), "M");
				drawRow(i * (s + 3), "B");
				drawColumn(i * (s + 3), "LT");
				drawColumn(i * (s + 3), "RB");
				break;
			case '6':
				drawRow(i * (s + 3), "T");
				drawRow(i * (s + 3), "M");
				drawRow(i * (s + 3), "B");
				drawColumn(i * (s + 3), "LT");
				drawColumn(i * (s + 3), "LB");
				drawColumn(i * (s + 3), "RB");
				break;
			case '7':
				drawRow(i * (s + 3), "T");
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "RB");
				break;
			case '8':
				drawRow(i * (s + 3), "T");
				drawRow(i * (s + 3), "M");
				drawRow(i * (s + 3), "B");
				drawColumn(i * (s + 3), "LT");
				drawColumn(i * (s + 3), "LB");
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "RB");
				break;
			case '9':
				drawRow(i * (s + 3), "T");
				drawRow(i * (s + 3), "M");
				drawRow(i * (s + 3), "B");
				drawColumn(i * (s + 3), "LT");
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "RB");
				break;
			case '0':
				drawRow(i * (s + 3), "T");
				drawRow(i * (s + 3), "B");
				drawColumn(i * (s + 3), "LT");
				drawColumn(i * (s + 3), "LB");
				drawColumn(i * (s + 3), "RT");
				drawColumn(i * (s + 3), "RB");
				break;
			}
		}
		print(s);
	}

	private static void print(int s) {
		for (int i = 0; i < 2 * s + 3; i++) {
			for (int j = 0; j < n.length * (s + 3); j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}

	}

	private static void drawRow(int cur, String type) {
		int row = -1;
		switch (type) {
		case "T":
			row = 0;
			break;
		case "M":
			row = (2 * s + 3) / 2;
			break;
		case "B":
			row = 2 * s + 2;
			break;
		}
		for (int i = 1; i < s + 1; i++) {
			answer[row][cur + i] = '-';
		}

	}

	private static void drawColumn(int cur, String type) {
		int row = -1;
		int column = -1;
		switch (type) {
		case "LT":
			row = 0;
			column = cur;
			break;
		case "RT":
			row = 0;
			column = cur + s + 1;
			break;
		case "LB":
			row = (2 * s + 3) / 2;
			column = cur;
			break;
		case "RB":
			row = (2 * s + 3) / 2;
			column = cur + s + 1;
			break;
		}
		for (int i = 1; i < s + 1; i++) {
			answer[row + i][column] = '|';
		}
	}

}
