package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_5052_전화번호목록 {

	static class TrieNode {
		Map<Character, TrieNode> childNode = new HashMap<>();
		boolean isLast;

		TrieNode() {

		}

		public void insert(String word) {
			TrieNode trieNode = this;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				// 없으면 추가
				trieNode.childNode.putIfAbsent(c, new TrieNode());
				trieNode = trieNode.childNode.get(c);

				// 마지막 문자
				if (i == word.length() - 1) {
					trieNode.isLast = true;
					return;
				}
			}
		}

		public boolean contains(String word) {
			TrieNode trieNode = this;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode node = trieNode.childNode.get(c);

				if (node == null)
					return false;

				trieNode = node;
			}

			// 해당 단어로 종료하는 문자가 있을 경우
			if (trieNode.isLast) {
				if (trieNode.childNode.isEmpty()) {
					return false;
				}
			}
			return true;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			TrieNode trie = new TrieNode();
			boolean isPossible = true;

			List<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				trie.insert(input);
				list.add(input);
			}

			// init done

			for (String key : list) {
				if (trie.contains(key)) {
					isPossible = false;
					break;
				}
			}

			if (isPossible)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
