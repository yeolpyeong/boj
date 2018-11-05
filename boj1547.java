/*
 * 공
 * https://www.acmicpc.net/problem/1547
 */

package boj;

import java.util.Scanner;

public class boj1547 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int ball = 1;
		while (M-- > 0) {
			int X = sc.nextInt();
			int Y = sc.nextInt();

			if (X == ball) {
				ball = Y;
			} else if (Y == ball) {
				ball = X;
			}
		}
		System.out.print(ball);
	}
}
