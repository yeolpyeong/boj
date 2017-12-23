/*
 * 윷놀이
 * https://www.acmicpc.net/problem/2490
 */

package boj;

import java.util.Scanner;

public class boj2490 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			int sum = 0;
			for (int j = 1; j <= 4; j++) {
				sum += sc.nextInt();
			}
			String yut = "DCBAE";
			System.out.println(yut.charAt(sum));
		}
	}
}
