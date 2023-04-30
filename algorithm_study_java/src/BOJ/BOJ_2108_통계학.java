package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2108_통계학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

//		init done

		sb.append(getAverage(numbers, n)).append("\n");
		sb.append(getMedian(numbers, n)).append("\n");
		sb.append(getMode(numbers, n)).append("\n");
		sb.append(getRange(numbers, n)).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int getRange(int[] numbers, int n) {
		int max = -4001;
		int min = 4001;
		for (int i = 0; i < n; i++) {
			if (max < numbers[i])
				max = numbers[i];
			if (min > numbers[i])
				min = numbers[i];
		}
		return max - min;
	}

	private static int getMode(int[] numbers, int n) {
		// -4000 ~ 4000
		int numCnt[] = new int[8001];
		for (int i = 0; i < n; i++) {
			numCnt[numbers[i] + 4000]++;
		}
		int max = -1;
		int num = -1;
		boolean secondMin = false;
		for (int i = 0; i < 8001; i++) {
			if (numCnt[i] == 0)
				continue;
			if (max < numCnt[i]) {
				max = numCnt[i];
				num = i;
				secondMin = false;
			} else if (max == numCnt[i]) {
				if (!secondMin) {
					max = numCnt[i];
					num = i;
					secondMin = true;
				}
			}
		}
		return num - 4000;
	}

	private static int getMedian(int[] numbers, int n) {
		int[] copy = Arrays.copyOf(numbers, n);
		Arrays.sort(copy);
		return copy[n / 2];
	}

	private static int getAverage(int[] numbers, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += numbers[i];
		}
		return (int) Math.round(sum / (double) n);
	}

}
