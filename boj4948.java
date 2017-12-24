/*
 * 베르트랑 공준
 * https://www.acmicpc.net/problem/4948
 */

package boj;

import java.util.Scanner;

public class boj4948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;

			int[] numbers = new int[2 * n + 1];
			for (int i = 2; i <= 2 * n; i++) {
				for (int j = 2; i * j <= 2 * n; j++) {
					numbers[i * j] = 1;
				}
			}

			int c = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (numbers[i] == 0)
					c++;
			}
			System.out.println(c);
		}
	}
}
