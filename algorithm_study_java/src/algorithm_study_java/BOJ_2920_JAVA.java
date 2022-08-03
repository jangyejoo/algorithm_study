package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2920_JAVA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int [] m = new int [8];
		boolean isAsc = true;
		boolean isDec = true;
		for (int i = 0; i < m.length; i++) {
			m[i] = Integer.parseInt(st.nextToken());
			if (i>0) {
				if (m[i] != m[i-1] + 1) isAsc = false;
				if (m[i] != m[i-1] - 1) isDec = false;
			}
		}
		if (isAsc) {
			sb.append("ascending");
		} else if (isDec) {
			sb.append("descending");
		} else {
			sb.append("mixed");
		}
		
		System.out.println(sb);
	}
	
}
