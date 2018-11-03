/*
 * Farm
 * https://www.acmicpc.net/problem/16283
 */

package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj16283 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();

		ArrayList<Integer> l = new ArrayList();
		for (int i = 1; i < n; i++) {
			if (a * i + b * (n - i) == w) {
				l.add(i);
			}
		}
		System.out.print(l.size() == 1 ? l.get(0) + " " + (n - l.get(0)) : -1);
	}
}
