/*
 * 주차의 신
 * https://www.acmicpc.net/problem/5054
 */

package boj;

import java.util.Scanner;

public class boj5054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int min = 99;
			int max = 0;
			while (n-- > 0) {
				int x = sc.nextInt();
				min = Math.min(min, x);
				max = Math.max(max, x);
			}
			System.out.println(2 * (max - min));
		}
	}
}
