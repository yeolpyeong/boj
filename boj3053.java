/*
 * 택시 기하학
 * https://www.acmicpc.net/problem/3053
 */

package boj;

import java.util.Scanner;

public class boj3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		System.out.print(String.format("%.6f", Math.PI * R * R) + "\n" + String.format("%.6f", (double) 2 * R * R));
	}
}
