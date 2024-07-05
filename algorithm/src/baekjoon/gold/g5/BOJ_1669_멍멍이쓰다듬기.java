package baekjoon.gold.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1669_멍멍이쓰다듬기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int monkey = Integer.parseInt(st.nextToken());
		int dog = Integer.parseInt(st.nextToken());

		// init done

		if (monkey == dog) {
			System.out.println(0);
			return;
		}

		int diff = dog - monkey;
		double root = Math.sqrt(diff);
		int floor = (int) Math.floor(root);

		if (root == floor)
			System.out.println(2 * floor - 1);
		else if (diff <= floor * (floor + 1))
			System.out.println(2 * floor);
		else
			System.out.println(2 * floor + 1);
	}

}
