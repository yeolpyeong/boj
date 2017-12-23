/*
 * 이게 분수?
 * https://www.acmicpc.net/problem/2863
 */

package boj;

import java.util.Scanner;

public class boj2863 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextInt();
		double B = sc.nextInt();
		double C = sc.nextInt();
		double D = sc.nextInt();
		double[] table = { A, C, D, B };

		double max = 0;
		int index = 0;
		for (int i = 0; i < 4; i++) {
			double res = table[(0 + i) % 4] / table[(1 + i) % 4] + table[(3 + i) % 4] / table[(2 + i) % 4];
			if (res > max) {
				max = res;
				index = i;
			}
		}
		System.out.print(index);
	}
}
