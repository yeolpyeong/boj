/*
 * гу
 * https://www.acmicpc.net/problem/8393
 */

package boj;

import java.util.Scanner;

public class boj8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(n * (n + 1) / 2);
	}
}
