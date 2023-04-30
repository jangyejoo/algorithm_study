package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2501_약수구하기{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
				if (++cnt == k) {
					System.out.println(list.get(cnt-1));
					return;
				}
			}
		}
		System.out.println(0);
	}

}
