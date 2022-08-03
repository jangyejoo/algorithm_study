package algorithm_study_java;

import java.io.*;
import java.util.HashSet;

public class BOJ_3052_JAVA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> arr = new HashSet<Integer>();

		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			arr.add(num % 42);
		}
		
		System.out.println(arr.size());
	}

}
