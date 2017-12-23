/*
 * 상근날드
 * https://www.acmicpc.net/problem/5543
 */

package boj;

import java.util.Scanner;

public class boj5543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min1, min2;
		min1 = min2 = 2000;
		for (int i = 1; i <= 3; i++) {
			int hamburger = sc.nextInt();
			min1 = Math.min(min1, hamburger);
		}
		for (int i = 1; i <= 2; i++) {
			int coke = sc.nextInt();
			min2 = Math.min(min2, coke);
		}
		System.out.print(min1 + min2 - 50);
	}
}
