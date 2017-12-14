/*
 * 
 * https://www.acmicpc.net/problem/1002
 */

package boj;

import java.util.Scanner;

public class boj1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();

			double D = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			int R1 = r1 + r2;
			int R2 = Math.abs(r1 - r2);
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);
			} else {
				if (D < R1 && D > R2) {
					System.out.println(2);
				} else if (D == R1 || D == R2) {
					System.out.println(1);
				} else if (D > R1 || D < R2) {
					System.out.println(0);
				}
			}
		}
	}
}
