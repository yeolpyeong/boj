/*
 * LCS
 * https://www.acmicpc.net/problem/9251
 */

package boj;

import java.util.Scanner;

public class boj9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String seq1 = sc.next();
		String seq2 = sc.next();
		int[][] lcs = new int[seq1.length() + 1][seq2.length() + 1];
		for (int i = 1; i <= seq1.length(); i++) {
			for (int j = 1; j <= seq2.length(); j++) {
				if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		System.out.print(lcs[seq1.length()][seq2.length()]);
	}
}
