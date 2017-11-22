/*
 * 캥거루 세마리
 * https://www.acmicpc.net/problem/2965
 */

package boj;

import java.util.Scanner;

public class boj2965 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int diffOfAB = B - A - 1;
		int diffOfBC = C - B - 1;

		System.out.print(diffOfAB > diffOfBC ? diffOfAB : diffOfBC);
	}
}
