/*
 * ACM-ICPC
 * https://www.acmicpc.net/problem/11946
 */

package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class boj11946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		int[][][] wrong = new int[n + 1][m + 1][2];
		int[][] score = new int[n + 1][2];
		while (q-- > 0) {
			int elapsedTime = sc.nextInt();
			int numberOfTeam = sc.nextInt();
			int numberOfProblem = sc.nextInt();
			String result = sc.next();

			if (!result.equals("AC") || wrong[numberOfTeam][numberOfProblem][1] != 0) {
				wrong[numberOfTeam][numberOfProblem][0]++;
			} else {
				wrong[numberOfTeam][numberOfProblem][1] = 1;
				score[numberOfTeam][0]++;
				score[numberOfTeam][1] += elapsedTime + 20 * wrong[numberOfTeam][numberOfProblem][0];
			}
		}

		class leaderBoard {
			int numberOfTeam;
			int numberOfSolvedProblems;
			int elapsedTime;

			public leaderBoard(int numberOfTeam, int numberOfSolvedProblems, int elapsedTime) {
				this.numberOfTeam = numberOfTeam;
				this.numberOfSolvedProblems = numberOfSolvedProblems;
				this.elapsedTime = elapsedTime;
			}
		}
		ArrayList<leaderBoard> leaderBoards = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			leaderBoards.add(new leaderBoard(i, score[i][0], score[i][1]));
		}
		Collections.sort(leaderBoards, new Comparator<leaderBoard>() {
			@Override
			public int compare(leaderBoard l1, leaderBoard l2) {
				if (l1.numberOfSolvedProblems > l2.numberOfSolvedProblems) {
					return -1;
				} else if (l1.numberOfSolvedProblems == l2.numberOfSolvedProblems) {
					if (l1.elapsedTime < l2.elapsedTime) {
						return -1;
					} else if (l1.elapsedTime > l2.elapsedTime) {
						return 1;
					} else {
						return 0;
					}
				} else {
					return 1;
				}
			}
		});
		
		for (leaderBoard l : leaderBoards) {
			System.out.println(l.numberOfTeam + " " + l.numberOfSolvedProblems + " " + l.elapsedTime);
		}
	}
}
