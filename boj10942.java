/*
 * 팰린드롬? 
 * https://www.acmicpc.net/problem/10942
 */

package boj;

import java.util.Scanner;

public class boj10942 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] seq = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			seq[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		while (M-- > 0) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			System.out.println(checkPalindrome(seq, S, E));
		}
	}

	public static int checkPalindrome(int[] seq, int S, int E) {
		for (int i = 0; i <= E - S; i++) {
			if (seq[S + i] != seq[E - i])
				return 0;
		}
		return 1;
	}
}
