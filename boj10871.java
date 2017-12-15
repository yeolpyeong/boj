/*
 * X보다 작은 수
 * https://www.acmicpc.net/problem/10871
 */

package boj;

import java.util.Scanner;

public class boj10871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		while (N-- > 0) {
			int n = sc.nextInt();
			if (n < X)
				System.out.print(n + " ");
		}
	}
}
