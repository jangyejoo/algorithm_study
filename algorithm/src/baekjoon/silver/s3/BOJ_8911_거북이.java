package baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8911_거북이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			// 현재 위치와 방향
			int curPosX = 0;
			int curPosY = 0;

			// 북동남서 0123
			int curDirection = 0;

			// x축 최대, 최소
			// y축 최대, 최소
			int maxX = 0;
			int minX = 0;
			int maxY = 0;
			int minY = 0;
			char[] input = br.readLine().toCharArray();
			for (int j = 0, size = input.length; j < size; j++) {
				switch (input[j]) {
				case 'F':
					if (curDirection == 1) {
						curPosX++;
						if (curPosX > maxX)
							maxX = curPosX;
					} else if (curDirection == 3) {
						curPosX--;
						if (curPosX < minX)
							minX = curPosX;
					} else if (curDirection == 2) {
						curPosY--;
						if (curPosY < minY)
							minY = curPosY;
					} else {
						curPosY++;
						if (curPosY > maxY)
							maxY = curPosY;
					}
					break;
				case 'B':
					if (curDirection == 1) {
						curPosX--;
						if (curPosX < minX)
							minX = curPosX;
					} else if (curDirection == 3) {
						curPosX++;
						if (curPosX > maxX)
							maxX = curPosX;
					} else if (curDirection == 2) {
						curPosY++;
						if (curPosY > maxY)
							maxY = curPosY;
					} else {
						curPosY--;
						if (curPosY < minY)
							minY = curPosY;
					}
					break;
				case 'L':
					curDirection = curDirection == 0 ? 3 : curDirection - 1;
					break;
				case 'R':
					curDirection = (curDirection + 1) % 4;
					break;
				}
			}
			sb.append(Math.abs(maxX - minX) * Math.abs(maxY - minY)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
