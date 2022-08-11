package algorithm_study_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1008_AdivB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		double a = Integer.parseInt(st.nextToken());
		double b = Integer.parseInt(st.nextToken());

		System.out.println(a / b);
	}

}
