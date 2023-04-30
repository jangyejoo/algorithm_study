package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
	private int x;
	private int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

public class BOJ_2493_탑 {
	
	static int N;
	static Stack<Pair> tower;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tower = new Stack<Pair>();
		
		N = Integer.parseInt(br.readLine());
		tower.add(new Pair(100000001 , 0));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			while (tower.peek().getX() < height) {
				tower.pop();
			}
			sb.append(tower.peek().getY()).append(" ");
			tower.add(new Pair(height, i));
		}
		
		System.out.println(sb);
	}
}
