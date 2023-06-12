package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_16113_시그널 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char[][] numbers = new char[5][n / 5];
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < n / 5; j++) {
				numbers[i][j] = input.charAt(cnt++);
			}
		}

//		init done

		cnt = 0;
		while (cnt < n / 5) {
			// 공백
			if (numbers[0][cnt] == '.' && numbers[1][cnt] == '.' && numbers[2][cnt] == '.' && numbers[3][cnt] == '.'
					&& numbers[4][cnt] == '.') {
				cnt++;
				continue;
			}

			// 마지막 1
			if (cnt == n / 5 - 1 && numbers[0][cnt] == '#' && numbers[1][cnt] == '#' && numbers[2][cnt] == '#'
					&& numbers[3][cnt] == '#' && numbers[4][cnt] == '#') {
				sb.append(1);
				break;
			}

			if (numbers[1][cnt] == '.' && numbers[3][cnt] == '#') {
				// 2
				sb.append(2);
				cnt += 4;
				continue;
			} else if (numbers[1][cnt] == '.' && numbers[3][cnt] == '.') {
				if (numbers[2][cnt + 1] == '#') {
					// 3
					sb.append(3);
					cnt += 4;
					continue;
				} else {
					// 7
					sb.append(7);
					cnt += 4;
					continue;
				}
			} else if (numbers[1][cnt] == '#' && numbers[3][cnt] == '.') {
				if (numbers[1][cnt + 2] == '.') {
					// 5
					sb.append(5);
					cnt += 4;
					continue;
				} else {
					if (numbers[0][cnt + 1] == '.') {
						// 4
						sb.append(4);
						cnt += 4;
						continue;
					} else {
						// 9
						sb.append(9);
						cnt += 4;
						continue;
					}
				}
			} else {
				if (numbers[2][cnt + 1] == '.') {
					if (numbers[4][cnt + 1] == '.') {
						// 1
						sb.append(1);
						cnt += 2;
						continue;
					} else {
						// 0
						sb.append(0);
						cnt += 4;
						continue;
					}
				} else {
					if (numbers[1][cnt + 2] == '.') {
						// 6
						sb.append(6);
						cnt += 4;
						continue;
					} else {
						// 8
						sb.append(8);
						cnt += 4;
						continue;
					}
				}
			}

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
