/*
 * 수들의 합
 * https://www.acmicpc.net/problem/1789
 */

package boj;

import java.util.Scanner;

public class boj1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		System.out.print((int) Math.floor(-0.5 + Math.sqrt(2 * S + 0.25)));
	}
}
