/*
 * 최소 힙
 * https://www.acmicpc.net/problem/1927
 */

package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
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
