/*
 * ¼û¹Ù²ÀÁú
 * https://www.acmicpc.net/problem/1697
 */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList();
		q.add(N);
		int[] visited = new int[100001];
		int second = 0;
		while (true) {
			int size = q.size();
			for (int i = 1; i <= size; i++) {
				int X = q.poll();
				visited[X] = 1;

				if (X == K) {
					System.out.print(second);
					return;
				}

				if (checkRange(X + 1) && visited[X + 1] == 0)
					q.add(X + 1);
				if (checkRange(X - 1) && visited[X - 1] == 0)
					q.add(X - 1);
				if (checkRange(2 * X) && visited[2 * X] == 0)
					q.add(2 * X);
			}
			second++;
		}
	}

	public static boolean checkRange(int X) {
		return X >= 0 && X <= 100000;
	}
}
