/*
 * ÃÖ´ë Èü
 * https://www.acmicpc.net/problem/11279
 */

package boj;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x > 0) {
				heap.add(x);
			} else {
				System.out.println(heap.size() == 0 ? 0 : heap.poll());
			}
		}
	}
}
