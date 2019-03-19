
/*
 * 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class boj1697 {
	static final int MAX = 100000;

	static boolean inRange(int X) {
		return X >= 0 && X <= MAX;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[MAX + 1];
		q.add(N);
		visited[N] = true;
		int second = -1;
		loop: while (true) {
			second++;
			int qs = q.size();
			while (qs-- > 0) {
				int X = q.poll();

				if (X == K) {
					break loop;
				}

				if (inRange(X - 1) && !visited[X - 1]) {
					q.add(X - 1);
					visited[X - 1] = true;
				}
				if (inRange(X + 1) && !visited[X + 1]) {
					q.add(X + 1);
					visited[X + 1] = true;
				}
				if (inRange(2 * X) && !visited[2 * X]) {
					q.add(2 * X);
					visited[2 * X] = true;
				}
			}
		}

		System.out.print(second);
	}
}
