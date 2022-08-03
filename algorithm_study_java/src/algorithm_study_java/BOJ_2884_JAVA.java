package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2884_JAVA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String time = br.readLine();
		StringTokenizer st = new StringTokenizer(time);
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());

		if (min < 45) {
			if (hour == 0) hour = 23;
			else hour = (hour - 1) % 24;
		}

		min = ((min + 60) - 45) % 60;

		System.out.println(hour + " " + min);
	}

}
