package algorithm_study_java;
import java.io.*;
import java.util.*;

public class BOJ_18111_마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String nmb = br.readLine();
		StringTokenizer st = new StringTokenizer(nmb);

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] b = new int[N][M];
		int maxHeight = -1;
		int minHeight = 256;

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			StringTokenizer st2 = new StringTokenizer(row);
			for (int j = 0; j < M; j++) {
				b[i][j] = Integer.parseInt(st2.nextToken());
				maxHeight = maxHeight < b[i][j] ? b[i][j] : maxHeight;
				minHeight = minHeight > b[i][j] ? b[i][j] : minHeight;
			}
		}

		int minTime = Integer.MAX_VALUE;
		int height = 0;

		for (int H = maxHeight; H >= minHeight; H--) {
			int destroyCnt = 0;
			int stackCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (b[i][j] > H) {
						destroyCnt += b[i][j] - H;
					}
					if (b[i][j] < H) {
						stackCnt += H - b[i][j];
					}
				}
			}
			if (B + destroyCnt >= stackCnt) {
				if (minTime > destroyCnt * 2 + stackCnt) {
					minTime = destroyCnt * 2 + stackCnt;
					height = H;
				}
			}
			
		}

		sb.append(minTime).append(" ").append(height);
		System.out.println(sb);
	}

}
