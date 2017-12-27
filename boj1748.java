/*
 * 수 이어 쓰기 1
 * https://www.acmicpc.net/problem/1748
 */

package boj;

import java.util.Scanner;

public class boj1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int length = String.valueOf(N).length() + 1;
		int sum = 0;
		while (length-- > 0) {
			int n = (int) (N - Math.pow(10, length - 1) + 1);
			sum += length * n;
			N -= n;
		}
		System.out.print(sum);
	}
}
