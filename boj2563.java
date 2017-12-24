/*
 * 색종이
 * https://www.acmicpc.net/problem/2563
 */

package boj;

import java.util.Scanner;

public class boj2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] drawingPaper = new int[100][100];
		int area = 0;
		while (n-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (drawingPaper[i][j] == 0)
						drawingPaper[i][j] = ++area;
				}
			}
		}
		System.out.print(area);
	}
}
