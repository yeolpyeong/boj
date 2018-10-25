/*
 * 프린터 큐
 * https://www.acmicpc.net/problem/1966
 */

package boj;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		Queue<Integer> q;
		while (testCase-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			q = new LinkedList();
			for (int i = 0; i < N; i++) {
				q.add(sc.nextInt());
			}

			int count = 0;
			while (true) {
				Iterator<Integer> it = q.iterator();
				boolean flag = false;
				while (it.hasNext()) {
					if (q.peek() < it.next()) {
						flag = true;
						break;
					}
				}

				if (flag) {
					q.add(q.poll());
					M = M == 0 ? q.size() - 1 : M - 1;
				} else {
					q.poll();
					count++;
					if (M == 0) {
						System.out.println(count);
						break;
					} else {
						M--;
					}
				}
			}
		}
	}
}
