package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			Deque<Integer> nums = new ArrayDeque<>();
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int i = 0; i < 8; i++) {
				nums.addLast(Integer.parseInt(st.nextToken()));
			}

			// 반복문
			boolean isDone = false;
			while (!isDone) {
				for (int i = 1; i <= 5; i++) {
					int move = nums.getFirst() - i > 0 ? nums.getFirst() - i : 0;
					nums.removeFirst();
					nums.addLast(move);
					if (move == 0) {
						isDone = true;
						break;
					}
				}
			}

			sb.append("#").append(T).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(nums.getFirst()).append(" ");
				nums.removeFirst();
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}

}
