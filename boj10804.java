/*
 * 카드 역배치
 * https://www.acmicpc.net/problem/10804
 */

package boj;

import java.util.Scanner;

public class boj10804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cards = new int[21];
		for (int i = 1; i < cards.length; i++) {
			cards[i] = i;
		}
		for (int i = 1; i <= 10; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			swap(cards, a, b);
		}
		for (int i = 1; i < cards.length; i++) {
			System.out.print(cards[i] + " ");
		}
	}

	public static void swap(int[] cards, int a, int b) {
		for (int i = 0; i <= (b - a) / 2; i++) {
			int temp = cards[a + i];
			cards[a + i] = cards[b - i];
			cards[b - i] = temp;
		}
	}
}
