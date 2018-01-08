/*
 * 3n+1 수열
 * https://www.acmicpc.net/problem/14920
 */

package boj;

import java.util.Scanner;

public class boj14920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int n = 1;
		while (C != 1) {
			if (C % 2 == 0) {
				C /= 2;
			} else {
				C = 3 * C + 1;
			}
			n++;
		}
		System.out.print(n);
	}
}
