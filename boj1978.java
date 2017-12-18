/*
 * 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */

package boj;

import java.util.Scanner;

public class boj1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		while (N-- > 0) {
			if (boj1978(sc.nextInt()))
				count++;
		}
		System.out.print(count);
	}

	public static boolean boj1978(int n) {
		if (n == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
