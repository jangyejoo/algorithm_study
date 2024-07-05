package jungol;

import java.io.*;
import java.util.*;

public class JUNGOL_1828_냉장고 {

	static class Chemicals implements Comparable<Chemicals> {

		int minT, maxT;

		public Chemicals(int start, int end) {
			super();
			this.minT = start;
			this.maxT = end;
		}

		@Override
		public int compareTo(Chemicals o) {
			if (this.maxT == o.maxT) {
				return this.minT - o.minT;
			}
			return this.maxT - o.maxT;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Chemicals> list = new ArrayList<Chemicals>();
		Chemicals[] c = new Chemicals[n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			c[i] = new Chemicals(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 정렬
		Arrays.sort(c);

		int ans = 1;
		int rfT = c[0].maxT;
		for (int i = 1, size = c.length; i < size; i++) {
			if (rfT < c[i].minT) {
				rfT = c[i].maxT;
				ans++;
			}
		}

		System.out.println(ans);

	}

}
