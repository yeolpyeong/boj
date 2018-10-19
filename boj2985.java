/*
 * ¼¼ ¼ö
 * https://www.acmicpc.net/problem/2985
 */

package boj;

import java.util.Scanner;

public class boj2985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (a + b == c) {
			System.out.print(a + "+" + b + "=" + c);
		} else if (a == b + c) {
			System.out.print(a + "=" + b + "+" + c);
		} else if (a - b == c) {
			System.out.print(a + "-" + b + "=" + c);
		} else if (a == b - c) {
			System.out.print(a + "=" + b + "-" + c);
		} else if (a * b == c) {
			System.out.print(a + "*" + b + "=" + c);
		} else if (a == b * c) {
			System.out.print(a + "=" + b + "*" + c);
		} else if (a / b == c) {
			System.out.print(a + "/" + b + "=" + c);
		} else {
			System.out.print(a + "=" + b + "/" + c);
		}
	}
}
