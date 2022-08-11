package algorithm_study_java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> cards = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			cards.add(i + 1);
		}

		int cnt = 1;
		while (cards.size() != 1) {
			// 맨 위 카드를 버린다
			if (cnt % 2 != 0) {
				cards.remove();
			}
			// 맨 위 카드를 맨 아래로 올긴다
			else {
				cards.offer(cards.poll());
			}
			cnt++;
		}

		System.out.println(cards.poll());

	}

}
