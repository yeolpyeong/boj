/*
 * 영수증
 * https://www.acmicpc.net/problem/5565
 */

package boj;

import java.util.Scanner;

public class boj5565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt();
		for (int i = 1; i <= 9; i++) {
			price -= sc.nextInt();
		}
		System.out.print(price);
	}
}
