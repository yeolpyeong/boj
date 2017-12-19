/*
 * À±³â
 * https://www.acmicpc.net/problem/2753
 */

package boj;

import java.util.Scanner;

public class boj2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Y = sc.nextInt();
		int leapYear = 0;
		if (Y%4 == 0)
			leapYear = 1;
		if (Y%100 == 0)
			leapYear = 0;
		if (Y%400 == 0 )
			leapYear = 1;
		System.out.print(leapYear);
	}
}
