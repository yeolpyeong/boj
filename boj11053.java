/*
 * 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053 
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] seq = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			seq[i] = sc.nextInt();
		}
		System.out.print(boj11053(seq, N));
	}

	public static int boj11053(int[] seq, int n) {
		int[] dp = new int[n + 1];
		int length = 0;
		for (int i = 1; i <= n; i++) {
			if (seq[i] < dp[1]) {
				dp[1] = seq[i];
			} else if (seq[i] > dp[length]) {
				dp[length + 1] = seq[i];
				length++;
			} else {
				int index = Arrays.binarySearch(dp, 1, length + 1, seq[i]);
				index = index < 0 ? -index - 1 : index;
				dp[index] = seq[i];
			}
		}
		return length;
	}
}
