/*
 * Common Subsequence
 * https://www.acmicpc.net/problem/3793
 */

package boj;

import java.util.Scanner;

public class boj3793 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String S1 = sc.next();
			String S2 = sc.next();
			int[][] lcs = new int[S1.length() + 1][S2.length() + 1];
			for (int i = 1; i <= S1.length(); i++) {
				for (int j = 1; j <= S2.length(); j++) {
					lcs[i][j] = S1.charAt(i - 1) == S2.charAt(j - 1) ? lcs[i - 1][j - 1] + 1
							: Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
			System.out.println(lcs[S1.length()][S2.length()]);
		}
	}
}
