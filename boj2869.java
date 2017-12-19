/*
 * 달팽이는 올라가고 싶다
 * https://www.acmicpc.net/problem/2869
 */

package boj;

import java.util.Scanner;

public class boj2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double V = sc.nextDouble();
		System.out.print((int) Math.ceil((V - A) / (A - B)) + 1);
	}
}
