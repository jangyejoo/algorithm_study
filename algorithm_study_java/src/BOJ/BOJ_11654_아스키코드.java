package BOJ;

import java.io.*;

public class BOJ_11654_아스키코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int result = str.charAt(0);
		System.out.println(result);
	}

}
