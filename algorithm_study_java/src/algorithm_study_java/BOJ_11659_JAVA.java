package algorithm_study_java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11659_JAVA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String i1 = br.readLine();
		StringTokenizer st = new StringTokenizer(i1);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] num = new int[N + 1];
		int[] s = new int[N + 1];
		String numArr = br.readLine();
		StringTokenizer st2 = new StringTokenizer(numArr);
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st2.nextToken());
			if (i == 0) {
				s[i] = num[i];
			} else {
				s[i] = s[i - 1] + num[i];
			}
		}
		for (int i = 0; i < M; i++) {
			String sten = br.readLine();
			StringTokenizer st3 = new StringTokenizer(sten);
			int stt = Integer.parseInt(st3.nextToken());
			int end = Integer.parseInt(st3.nextToken());

			sb.append(s[end] - s[stt - 1]).append("\n");
		}
		System.out.print(sb);

	}

}
