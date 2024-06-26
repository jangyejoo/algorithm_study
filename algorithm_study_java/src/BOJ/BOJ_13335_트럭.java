package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		Queue<Integer> trucks = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}

// 		init done

//		다리 상태
		List<Integer> timeline = new ArrayList<>();

		int first = trucks.poll();
		timeline.add(first);
		int weightSum = first;

		while (!trucks.isEmpty()) {
			int truck = trucks.peek();

// 			트럭 도착
			int idx = timeline.size() - w;
			if (idx >= 0)
				weightSum -= timeline.get(idx);

//			다음 트럭 이동 가능
			if (truck + weightSum <= l) {
				timeline.add(truck);
				trucks.poll();

//				트럭 건너기 시작
				weightSum += truck;

				continue;
			}

			timeline.add(0);
		}

//		마지막 트럭이 지나가는 데 걸리는 시간 w를 더한 최종값
		System.out.println(timeline.size() + w);

	}

}
