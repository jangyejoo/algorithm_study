package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1085_직사각형에서탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int X = Math.min(x, w - x);
		int Y = Math.min(y, h - y);

		System.out.println(Math.min(X, Y));

	}

}
