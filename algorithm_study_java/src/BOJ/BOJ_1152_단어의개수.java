package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1152_단어의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		System.out.println(st.countTokens());
	}
	
}
