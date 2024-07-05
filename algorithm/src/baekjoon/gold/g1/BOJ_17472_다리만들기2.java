package baekjoon.gold.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans = Integer.MAX_VALUE;
	static Edge[] bridgeList;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<int[]> lands = new ArrayList<>();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					lands.add(new int[] { i, j });
				}
			}
		}

//		init done

//		섬 넘버링
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		int landNum = 0;
		for (int i = 0; i < lands.size(); i++) {
			int[] land = lands.get(i);
			if (visited[land[0]][land[1]])
				continue;
			landNum++;
			q.offer(new int[] { land[0], land[1] });
			visited[land[0]][land[1]] = true;
			map[land[0]][land[1]] = landNum;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m)
						continue;
					if (visited[nx][ny])
						continue;
					if (map[nx][ny] == 0)
						continue;

					visited[nx][ny] = true;
					map[nx][ny] = landNum;
					q.offer(new int[] { nx, ny });

				}
			}
		}

//		넘버링 확인
//		printMap(map, n, m);

		int[][] bridge = new int[landNum + 1][landNum + 1];
		for (int i = 0; i < landNum + 1; i++) {
			Arrays.fill(bridge[i], Integer.MAX_VALUE);
		}

//		서로 다리를 연결할 때 최솟값 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					int len = 0;

					while (true) {
						if (nx < 0 || ny < 0 || nx >= n || ny >= m)
							break;
						if (map[nx][ny] == map[i][j]) // 같은 섬
							break;
						else if (map[nx][ny] == 0) { // 바다
							len++;
							nx += dx[d];
							ny += dy[d];
						} else { // 다른 섬 도착
							if (len > 1 && bridge[map[i][j]][map[nx][ny]] > len) {
								// 다리 길이 저장
								bridge[map[i][j]][map[nx][ny]] = len;
								bridge[map[nx][ny]][map[i][j]] = len;
							}
							break;
						}
					}
				}
			}
		}

//		다리 배열 확인
//		printBridge(bridge, landNum);

		int size = 0;
		for (int i = 1; i <= landNum; i++) {
			for (int j = i; j <= landNum; j++) {
				if (bridge[i][j] != Integer.MAX_VALUE) {
					size++;
				}
			}
		}

		if (size < landNum - 1) {
			System.out.println(-1);
			return;
		}

		bridgeList = new Edge[size];

		int idx = 0;
		for (int i = 1; i <= landNum; i++) {
			for (int j = i; j <= landNum; j++) {
				if (bridge[i][j] != Integer.MAX_VALUE) {
					bridgeList[idx++] = new Edge(i, j, bridge[i][j]);
				}
			}
		}

		Arrays.sort(bridgeList);

		int[] parents = new int[landNum + 1];
		for (int i = 1; i <= landNum; i++) {
			parents[i] = i;
		}

		int result = 0;
		int cnt = 0;
		for (Edge edge : bridgeList) {
			if (union(parents, edge.from, edge.to)) {
				result += edge.weight;
				if (++cnt == landNum - 1)
					break;
			}
		}

		if (cnt == landNum - 1)
			System.out.println(result);
		else
			System.out.println(-1);

	}

	static int find(int[] parents, int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents, parents[a]);
	}

	static boolean union(int[] parents, int a, int b) {
		int aRoot = find(parents, a);
		int bRoot = find(parents, b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static void printBridge(int[][] bridge, int landNum) {
		for (int i = 1; i <= landNum; i++) {
			for (int j = 1; j <= landNum; j++) {
				if (bridge[i][j] == Integer.MAX_VALUE)
					System.out.print(0 + " ");
				else
					System.out.print(bridge[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	private static void printMap(int[][] map, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------");
	}

}
