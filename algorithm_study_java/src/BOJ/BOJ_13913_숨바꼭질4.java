package algorithm_study_java;

import java.io.*;
import java.util.*;

public class BOJ_13913_숨바꼭질4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int [100001][2];
		for (int i = 0; i < 100001; i++) {
			dist[i][0] = -1;
			dist[i][1] = -1;
		}
		Queue <Integer> q = new LinkedList<Integer>();
		dist[n][0] = 0;
		q.offer(n);
		
		while(!q.isEmpty()) {
			int cur = q.peek() ;
			q.poll();
			if (cur == k) break;
			for (int d : new int[] {-1,1,cur}) {
				int nxt = cur+d;
				if (nxt < 0 || nxt > 100000) continue;
				if (dist[nxt][0] != -1) continue;
				dist[nxt][0] = dist[cur][0]+1;
				dist[nxt][1] = cur;
				q.offer(nxt);
			}
		}
		
		sb.append(dist[k][0]).append("\n");
	
		List<Integer> ans = new ArrayList<Integer>();
		ans.add(k);
		while(dist[k][1] != -1) {
			ans.add(dist[k][1]);
			k = dist[k][1];
		}
		
		for (int i = ans.size()-1; i >= 0; i--) {
			sb.append(ans.get(i)).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}
