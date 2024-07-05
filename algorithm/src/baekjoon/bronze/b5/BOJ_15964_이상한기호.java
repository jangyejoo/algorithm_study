package baekjoon.bronze.b5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15964_이상한기호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		System.out.println((a + b) * (a - b));
	}

}
