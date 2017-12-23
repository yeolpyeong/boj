/*
 * ¾Þ±×¸® Ã¢¿µ
 * https://www.acmicpc.net/problem/3034
 */

package boj;

import java.util.Scanner;

public class boj3034 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		while (N-- > 0) {
			int M = sc.nextInt();
			System.out.println(M * M <= W * W + H * H ? "DA" : "NE");
		}
	}
}
