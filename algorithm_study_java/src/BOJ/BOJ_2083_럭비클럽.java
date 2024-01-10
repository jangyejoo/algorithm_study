package BOJ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2083_럭비클럽 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine().trim());

			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if ("#".equals(name) && age == 0 && weight == 0)
				break;

			sb.append(name);

			if (age > 17 || weight >= 80)
				sb.append(" Senior\n");
			else
				sb.append(" Junior\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
