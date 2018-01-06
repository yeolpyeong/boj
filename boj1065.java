/*
 * 한수
 * https://www.acmicpc.net/problem/1065
 */

package boj;

import java.util.Scanner;

public class boj1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = N < 9 ? N : 9;
		for (int i = 1; i <= N; i++) {
			String S = String.valueOf(i);
			int M = 0;
			for (int j = 1; j < S.length(); j++) {
				int D = S.charAt(0) - S.charAt(1);
				int temp = S.charAt(j - 1) - S.charAt(j);
				if (temp == D)
					M++;
				if (M == S.length() - 1)
					C++;
			}
		}
		System.out.print(C);
	}
}
