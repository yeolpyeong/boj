/*
 * 타임 카드
 * https://www.acmicpc.net/problem/5575
 */

package boj;

import java.util.Scanner;

public class boj5575 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			int H1 = sc.nextInt();
			int M1 = sc.nextInt();
			int S1 = sc.nextInt();
			int H2 = sc.nextInt();
			int M2 = sc.nextInt();
			int S2 = sc.nextInt();
			int businessHours = 3600 * H2 + 60 * M2 + S2 - 3600 * H1 - 60 * M1 - S1;
			for (int j = 2; j >= 0; j--) {
				System.out.print((int) (businessHours / Math.pow(60, j)) + " ");
				businessHours %= Math.pow(60, j);
			}
			System.out.println();
		}
	}
}
