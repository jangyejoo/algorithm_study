package baekjoon.gold.g4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21939_문제추천시스템Version1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] probLevel = new int[100002];
		TreeSet[] probByLevel = new TreeSet[102];
		for (int i = 0; i <= 100; i++) {
			probByLevel[i] = new TreeSet<Integer>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			probLevel[p] = l;
			probByLevel[l].add(p);
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String command = st.nextToken();
			if ("add".equals(command)) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				probLevel[p] = l;
				probByLevel[l].add(p);
			} else if ("recommend".equals(command)) {
				int option = Integer.parseInt(st.nextToken());

				if (option == 1) {
					for (int j = 100; j >= 0; j--) {
						if (probByLevel[j].isEmpty())
							continue;

						sb.append(probByLevel[j].last()).append("\n");
						break;
					}
				} else {
					for (int j = 0; j <= 100; j++) {
						if (probByLevel[j].isEmpty())
							continue;

						sb.append(probByLevel[j].first()).append("\n");
						break;
					}
				}
			} else {
				// solved
				int p = Integer.parseInt(st.nextToken());

				probByLevel[probLevel[p]].remove(p);
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
