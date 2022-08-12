package algorithm_study_java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int sum;
    static int ans;
    static int[][] ing;
    static int[] check;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            ing = new int[n][n];
            for (int i = 0; i < n; i++) {
                String row = br.readLine();
                StringTokenizer st = new StringTokenizer(row);
                for (int j = 0; j < n; j++) {
                    ing[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
//          이것은 순열 + 조합 버전
            int[] nums = new int[n / 2];
            ans = Integer.MAX_VALUE;
            check = new int[n / 2];
            combination(nums, 0, 0, n, n / 2);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
 
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
 
    private static boolean combination(int[] nums, int cnt, int start, int n, int m) {
        if (cnt == m) {
            // 조합 완성
            int[] nums2 = new int[n / 2];
            for (int i = 0, idx = 0; i < n; i++) {
                boolean isthereI = false;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == i) {
                        isthereI = true;
                        break;
                    }
                }
                if (!isthereI)
                    nums2[idx++] = i;
            }
            boolean done = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == check[i])
                    done = true;
                else
                    done = false;
            }
 
            if (done)
                return true;
 
            check = nums2.clone();
//          System.out.print("57 >>> " + Arrays.toString(nums));
//          System.out.println(" " + Arrays.toString(nums2));
            boolean[] isS = new boolean[n / 2];
            int[] resultArr = new int[2];
            sum = 0;
            shuffle(resultArr, nums, isS, 0, n / 2, 2);
            int sum1 = sum;
            sum = 0;
            isS = new boolean[n / 2];
            resultArr = new int[2];
            shuffle(resultArr, nums2, isS, 0, n / 2, 2);
            int result = Math.abs(sum - sum1);
            ans = ans > result ? result : ans;
            return false;
        }
        for (int i = start; i < n; i++) {
            nums[cnt] = i;
            if (combination(nums, cnt + 1, i + 1, n, m))
                break;
        }
        return false;
    }
 
    private static void shuffle(int[] result, int[] nums, boolean[] isS, int cnt, int n, int m) {
        if (cnt == m) {
            // 순열 완성
            sum += ing[result[0]][result[1]];
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isS[i])
                continue;
            result[cnt] = nums[i];
            isS[i] = true;
            shuffle(result, nums, isS, cnt + 1, n, 2);
            isS[i] = false;
        }
        return;
 
    }
 
}