package algorithm_study_java;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int dumpMax = Integer.parseInt(br.readLine());
			int[] box = new int[100];
			String boxH = br.readLine();
			StringTokenizer st = new StringTokenizer(boxH);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < box.length; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < dumpMax; i++) {
				Arrays.sort(box);
				box[99]--;
				box[0]++;
			}
			Arrays.sort(box);

			sb.append("#").append(t).append(" ").append(box[99] - box[0]);
			System.out.println(sb);
		}
	}

}
