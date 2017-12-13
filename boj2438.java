/*
 * 별찍기 - 1
 * https://www.acmicpc.net/problem/2438
 */

package boj;

import java.util.Scanner;

public class boj2438 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String stars = "";
		for (int i = 1; i <= N; i++) {
			System.out.println(stars += '*');
		}
	}
}
