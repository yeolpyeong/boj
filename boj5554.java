/*
 * 심부름 가는 길
 * https://www.acmicpc.net/problem/5554
 */

package boj;

import java.util.Scanner;

public class boj5554 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
		System.out.print(t / 60 + "\n" + t % 60);
	}
}
