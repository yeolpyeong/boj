/*
 * 거스름돈
 * https://www.acmicpc.net/problem/5585
 */

package boj;

import java.util.Scanner;

public class boj5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int change = 1000 - sc.nextInt();
		int n = 0;
		while (change > 0) {
			n += change % 10 / 5 + change % 5;
			change /= 10;
		}
		System.out.print(n);
	}
}
