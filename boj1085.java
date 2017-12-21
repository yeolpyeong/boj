/*
 * 직사각형에서 탈출
 * https://www.acmicpc.net/problem/1085
 */

package boj;

import java.util.Scanner;

public class boj1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		System.out.print(Math.min(Math.min(x, w - x), Math.min(y, h - y)));
	}
}
