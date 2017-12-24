/*
 * 알람 시계
 * https://www.acmicpc.net/problem/2884
 */

package boj;

import java.util.Scanner;

public class boj2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		int N = (60 * H + M + 24 * 60 - 45) % (24 * 60);
		System.out.print(N / 60 + " " + N % 60);
	}
}
