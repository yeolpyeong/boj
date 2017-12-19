/*
 * 학점계산
 * https://www.acmicpc.net/problem/2754
 */

package boj;

import java.util.Scanner;

public class boj2754 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String G = sc.next();
		double grade = 0;

		if (G.charAt(0) == 'A') {
			grade = 4;
		} else if (G.charAt(0) == 'B') {
			grade = 3;
		} else if (G.charAt(0) == 'C') {
			grade = 2;
		} else if (G.charAt(0) == 'D') {
			grade = 1;
		} else if (G.charAt(0) == 'F') {
			System.out.print(grade);
			return;
		}

		if (G.charAt(1) == '+') {
			grade += 0.3;
		} else if (G.charAt(1) == '-') {
			grade -= 0.3;
		}
		System.out.print(grade);
	}
}
