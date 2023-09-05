package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9466_텀프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());

			int[] students = new int[n + 1];
			int[] visit = new int[n + 1];

			st = new StringTokenizer(br.readLine().trim());
			for (int i = 1; i <= n; i++) {
				students[i] = Integer.parseInt(st.nextToken());

				if (i == students[i]) {
					// 나를 고른 학생은 이미 팀이 이루어짐
					visit[i] = 2;
				}
			}

			// init done

			for (int i = 1; i <= n; i++) {
				if (visit[i] == 2 || visit[i] == -1)
					continue;

				check(students, visit, n, i);
			}

			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if (visit[i] != 2)
					ans++;
			}
			sb.append(ans).append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static int check(int[] students, int[] visit, int n, int idx) {
		// 내가 선택한 학생
		int next = students[idx];

		if (visit[next] == 2 || visit[next] == -1) {
			// 이미 사이클이거나 노답인 친구
			visit[idx] = -1;
			return -1;
		}

		if (visit[next] == 1) {
			// 사이클 완성
			visit[idx] = 2;
			return next;
		}

		// 현재 노드 방문
		visit[idx] = 1;

		int start = check(students, visit, n, next);
		if (start > 0) {
			// 사이클 완성된 경우
			visit[idx] = 2;
			if (idx == start) {
				// 사이클의 끝까지 왔으면
				return -1;
			} else {
				return start;
			}
		} else {
			// 사이클이 완성되지 못한 경우
			visit[idx] = -1;
			return -1;
		}
	}

}
