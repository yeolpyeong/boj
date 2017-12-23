/*
 * 내 학점을 구해줘
 * https://www.acmicpc.net/problem/10984
 */

package boj;

import java.util.Scanner;

public class boj10984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int credit = 0;
			double GPA = 0;
			while (N-- > 0) {
				int C = sc.nextInt();
				double G = sc.nextDouble();
				credit += C;
				GPA += C * G;
			}
			System.out.println(credit + " " + String.format("%.1f", GPA / credit));
		}
	}
}
