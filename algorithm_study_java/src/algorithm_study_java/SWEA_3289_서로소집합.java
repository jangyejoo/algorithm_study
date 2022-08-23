package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			String nm = br.readLine();
			StringTokenizer st = new StringTokenizer(nm);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] list = new int[n + 1];
			for (int i = 1; i <= n; i++) {
//				list에 부모 인덱스
				list[i] = i;
			}
			for (int i = 0; i < m; i++) {
				String input = br.readLine();
				st = new StringTokenizer(input);
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (command == 0) {
//					a와 b를 합친다
					if (findSet(list, a) != findSet(list, b)) {
//						다른 집합일 때
						list[findSet(list, b)] = findSet(list, a);
					}
				}
				if (command == 1) {
//					a와 b가 같은 집합에 포함되어 있는지 확인
					if (findSet(list, a) != findSet(list, b)) {
//						다른 집합일 때
						sb.append(0);
					} else {
						sb.append(1);
					}
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int findSet(int[] list, int cur) {
		if (cur == list[cur]) {
			return cur;
		}
		return list[cur] = findSet(list, list[cur]);
	}

}
