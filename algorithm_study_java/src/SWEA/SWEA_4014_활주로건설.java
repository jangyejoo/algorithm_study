package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	static int N, X, map[][], map2[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			map2 = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append(process()).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int process() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (makeRoad(map[i]))
				cnt++;
			if (makeRoad(map2[i]))
				cnt++;
		}
		return cnt;
	}

	// 해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false 리턴
	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size = 0;
		int j = 0;
		while (j < N) {
			if (beforeHeight == road[j]) { // 동일 높이
				size++;
				j++;
			} else if (beforeHeight + 1 == road[j]) { // 이전 높이보다 1 높음 : 오르막 경사로 설치 체크
				if (size < X)
					return false;
				beforeHeight++;
				size = 1;
				j++;
			} else if (beforeHeight - 1 == road[j]) { // 이전 높이보다 1 낮음 : 내리막 경사로 설치 체크
				int cnt = 0;
				for (int k = j; k < N; k++) {
					if (road[k] != beforeHeight - 1)
						return false;
					if (++cnt == X)
						break;
				}
				if (cnt < X)
					return false;
				beforeHeight--;
				j += X;
				size = 0;
			} else { // 높이가 2이상 차이
				return false;
			}
		}
		return true;
	}
}
