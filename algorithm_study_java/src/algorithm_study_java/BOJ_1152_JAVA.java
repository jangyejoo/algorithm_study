package algorithm_study_java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1152_JAVA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		System.out.println(st.countTokens());
	}
	
}
