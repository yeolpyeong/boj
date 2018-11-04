/*
 * 지능형 기차
 * https://www.acmicpc.net/problem/2455
 */

package boj;

import java.util.Scanner;

public class boj2455 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		while (sc.hasNext()) {
			int temp = sc.nextInt() - sc.nextInt();
			max = Math.max(max, max - temp);
		}
		System.out.print(max);
	}
}
