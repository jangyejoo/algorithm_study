package baekjoon.silver.s5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16506_CPU {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String opcode = st.nextToken();
			int rD = Integer.parseInt(st.nextToken());
			int rA = Integer.parseInt(st.nextToken());
			int rBsharpC = Integer.parseInt(st.nextToken());

			String result = translate(opcode, rD, rA, rBsharpC);
			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static String translate(String opcode, int rD, int rA, int rBsharpC) {
		String result = "";

//		opcode 처리
		if (opcode.contains("ADD")) {
			result += "0000";
		} else if (opcode.contains("SUB")) {
			result += "0001";
		} else if (opcode.contains("MOV")) {
			result += "0010";
		} else if (opcode.contains("AND")) {
			result += "0011";
		} else if (opcode.contains("OR")) {
			result += "0100";
		} else if (opcode.contains("MUL")) {
			result += "0110";
		} else if (opcode.contains("LSFTL")) {
			result += "0111";
		} else if (opcode.contains("LSFTR")) {
			result += "1000";
		} else if (opcode.contains("ASFTR")) {
			result += "1001";
		} else if (opcode.contains("RL")) {
			result += "1010";
		} else if (opcode.contains("RR")) {
			result += "1011";
		} else if (opcode.contains("NOT")) {
			result += "0101";
		}

		if (opcode.contains("C")) {
			result += "10";
		} else {
			result += "00";
		}

//		rD 처리
		result += binary(rD, 3);

//		rA 처리
		if ("NOT".equals(opcode)) {
			result += "000";
		} else {
			result += binary(rA, 3);
		}

//		rBsharpC 처리
		if (!opcode.contains("C")) {
			result += binary(rBsharpC, 3);
			result += "0";
		} else {
			result += binary(rBsharpC, 4);
		}

		return result;
	}

	private static String binary(int number, int size) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < size; i++) {
			result.append(number % 2);
			number = number / 2;
		}

		return result.reverse().toString();
	}

}
