/*
 * 최소, 최대
 * https://www.acmicpc.net/problem/10818
 */

package boj;

import java.util.Scanner;

public class boj10818 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int n = sc.nextInt();
			min = Math.min(min, n);
			max = Math.max(max, n);
		}
		System.out.print(min + " " + max);
	}
}
