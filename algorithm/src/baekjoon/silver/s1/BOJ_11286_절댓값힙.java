package baekjoon.silver.s1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Heap {
	public ArrayList<Integer> heap;

	public Heap() {
		super();
		heap = new ArrayList<Integer>();
		heap.add(0);
	}

	public int compare(int a, int b) {
		if (Math.abs(a) == Math.abs(b)) {
			// 절댓값 같으면
			return a - b;
		}
		return Math.abs(a) - Math.abs(b);

	}

	// 삽입
	public void insert(int number) {
		heap.add(number);
		int p = heap.size() - 1;
		while (compare(heap.get(p / 2), heap.get(p)) > 0) {
			// 부모가 자식보다 절댓값이 크면 진행!
			int tmp = heap.get(p / 2);
			heap.set(p / 2, number);
			heap.set(p, tmp);
			p /= 2;
		}
	}

	// 삭제
	public int delete() {
		if (heap.size() - 1 < 1)
			return 0;

		// 삭제할 노드
		int deleteitem = heap.get(1);

		// 마지막 노드 옮기고 삭제
		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int p = 1;
		// 왼쪽 자식 인덱스가 사이즈보다 크다는 것은 삽입 위치를 벗어났다
		while (p * 2 < heap.size()) {
			int min = heap.get(p * 2);
			int minp = p * 2;

			// 오른쪽 자식의 인덱스가 사이즈보다 작고 왼쪽 보다 더 작을 때 오른쪽 자식을 부모와 바꿔줄 자식으로 지정
			if (((p * 2 + 1) < heap.size()) && compare(min, heap.get(p * 2 + 1)) > 0) {
				min = heap.get(p * 2 + 1);
				minp = p * 2 + 1;
			}

			if (compare(min, heap.get(p)) > 0)
				break;

			int tmp = heap.get(p);
			heap.set(p, heap.get(minp));
			heap.set(minp, tmp);
			p = minp;
		}
		return deleteitem;
	}

}

public class BOJ_11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Heap h = new Heap();
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number != 0) {
				// 입력
				h.insert(number);
			} else {
				// 출력
				sb.append(h.delete()).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
