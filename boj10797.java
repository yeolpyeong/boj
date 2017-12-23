/*
 * 10부제
 * https://www.acmicpc.net/problem/10797
 */

package boj;

import java.util.Scanner;

public class boj10797 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int c = 0;
		for (int i = 1; i <= 5; i++) {
			int n = sc.nextInt();
			if (d == n)
				c++;
		}
		System.out.print(c);
	}
}
