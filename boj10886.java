/*
 * 0 = not cute / 1 = cute
 * https://www.acmicpc.net/problem/10886
 */

package boj;

import java.util.Scanner;

public class boj10886 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = 0;
		for (int i = 1; i <= N; i++) {
			int V = sc.nextInt();
			C += V;
		}
		System.out.print(C > N / 2 ? "Junhee is cute!" : "Junhee is not cute!");
	}
}
