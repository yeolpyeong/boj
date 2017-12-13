/*
 * 별찍기 - 7
 * https://www.acmicpc.net/problem/2444
 */

package boj;

import java.util.Scanner;

public class boj2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i = 1;
		boolean flag = false;
		while (i >= 1) {
			for (int j = 1; j <= N - i; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print('*');
			}
			System.out.println();

			if (i < N && flag == false) {
				i++;
				if (i >= N)
					flag = true;
			} else {
				i--;
			}
		}
	}
}
