/*
 * 완전제곱수
 * https://www.acmicpc.net/problem/1977
 */

package boj;

import java.util.Scanner;

public class boj1977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		M = (int) Math.ceil(Math.sqrt(M));
		N = (int) Math.floor(Math.sqrt(N));
		int sum = 0;
		for (int i = M; i <= N; i++) {
			sum += i * i;
		}
		System.out.print(sum > 0 ? sum + "\n" + M * M : -1);
	}
}
