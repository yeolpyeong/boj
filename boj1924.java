/*
 * 2007³â
 * https://www.acmicpc.net/problem/1924
 */

package boj;

import java.util.Scanner;

public class boj1924 {
	static String[] DOW = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(boj1924(x, y));
	}

	public static String boj1924(int x, int y) {
		int n = 0;
		if (x == 1 || x == 10)
			n = y % 7;
		if (x == 5)
			n = (y + 1) % 7;
		if (x == 8)
			n = (y + 2) % 7;
		if (x == 2 || x == 3 || x == 11)
			n = (y + 3) % 7;
		if (x == 6)
			n = (y + 4) % 7;
		if (x == 9 || x == 12)
			n = (y + 5) % 7;
		if (x == 4 || x == 7)
			n = (y + 6) % 7;
		return DOW[n];
	}
}
