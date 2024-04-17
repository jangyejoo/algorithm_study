package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1069_집으로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

//		init done

		double dist = Math.sqrt(x * x + y * y);

//		만약 뛰는 것보다 걷는 게 이득이면
		if (d <= t) {
			System.out.println(dist);
			return;
		}

//		점프가 더 빠르니까 최대한 많이 점프!
		double jump = Math.floor(dist / d);

//		남은 거리
		double rest = Math.abs(dist - jump * d);

//		걸어가거나 한 번 뛰고 걸어가거나
		double addWalk = Math.min(rest, t + Math.abs(d - rest));

//		점프로만 가는 경우 (최소 2번은 뛰어야 함)
		double onlyJump = Math.max(Math.ceil(dist / d), 2) * t;

		System.out.println(Math.min(jump * t + addWalk, onlyJump));

	}

}
