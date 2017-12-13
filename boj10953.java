/*
 * A+B - 6
 * https://www.acmicpc.net/problem/10953
 */

package boj;

import java.util.Scanner;

public class boj10953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			String numbers = sc.next();
			int A = Integer.parseInt(numbers.split(",")[0]);
			int B = Integer.parseInt(numbers.split(",")[1]);
			System.out.println(A+B);
		}
	}
}
