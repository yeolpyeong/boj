/*
 * 동물원
 * https://www.acmicpc.net/problem/1309
 */

package boj;

import java.util.Scanner;

public class boj1309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] zoo = new int[100001];
		zoo[1] = 3;
		zoo[2] = 7;
		for (int i = 3; i <= N; i++) {
			zoo[i] = (2 * zoo[i - 1] + zoo[i - 2]) % 9901;
		}
		System.out.print(zoo[N]);
	}
}
