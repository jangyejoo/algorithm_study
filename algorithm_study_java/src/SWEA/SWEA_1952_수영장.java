package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[] cost = new int[4]; // 1일, 1달, 3달, 1년
		int[] plan = new int[13]; // 1년을 1-index로 관리
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

//			init done

//			dp 테이블
			int[][] table = new int[3][13];
			
//			1일권 사용 고려
			for (int i = 1; i <= 12; i++) {
				table[0][i] = table[0][i - 1] + plan[i] * cost[0];
			}

//			1달권 사용 고려
			for (int i = 1; i <= 12; i++) {
				table[1][i] = Math.min(table[1][i - 1] + table[0][i] - table[0][i - 1], table[1][i - 1] + cost[1]);
			}

//			3달권 사용 고려
			int idx = 3;
			table[2][1] = table[1][1];
			table[2][2] = table[1][2];
			while (idx <= 12) {
				table[2][idx] = Math.min(table[2][idx - 1] + table[1][idx] - table[1][idx - 1],
						table[2][idx - 3] + cost[2]);
				idx++;
			}

//			1년권 사용 고려
			if (table[2][12] < cost[3])
				sb.append(table[2][12]);
			else
				sb.append(cost[3]);

			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
