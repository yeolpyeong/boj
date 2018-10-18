/*
 * Z
 * https://www.acmicpc.net/problem/1074
 */

package boj;

import java.util.Scanner;

public class boj1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int count = 0;
		double size = Math.pow(2, N);
		while (size > 2) {
			if (r >= size / 2) {
				count += size * size / 2;
				r -= size / 2;
			}
			if (c >= size / 2) {
				count += size * size / 4;
				c -= size / 2;
			}
			size /= 2;
		}
		count += 2 * r + c;
		System.out.print(count);
	}
}
