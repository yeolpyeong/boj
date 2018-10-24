/*
 * 가위바위보
 * https://www.acmicpc.net/problem/2930
 */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj2930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		char[] sanggeun = new char[R];
		String temp = sc.next();
		for (int i = 0; i < R; i++) {
			sanggeun[i] = temp.charAt(i);
		}
		int N = sc.nextInt();
		char[][] friends = new char[N][R];
		for (int i = 0; i < N; i++) {
			temp = sc.next();
			for (int j = 0; j < R; j++) {
				friends[i][j] = temp.charAt(j);
			}
		}

		int score = 0;
		int[] scoreByRound;
		int maximumScore = 0;
		for (int i = 0; i < R; i++) {
			scoreByRound = new int[3];
			for (int j = 0; j < N; j++) {
				score += rps(sanggeun[i], friends[j][i]);
				scoreByRound[0] += rps('R', friends[j][i]);
				scoreByRound[1] += rps('P', friends[j][i]);
				scoreByRound[2] += rps('S', friends[j][i]);
			}
			Arrays.sort(scoreByRound);
			maximumScore += scoreByRound[2];
		}
		System.out.print(score + "\n" + maximumScore);
	}

	public static int rps(char S, char F) {
		int score = 0;
		if (S == F) {
			score += 1;
		} else {
			if (S == 'R') {
				if (F == 'S') {
					score += 2;
				}
			}
			if (S == 'P') {
				if (F == 'R') {
					score += 2;
				}
			}
			if (S == 'S') {
				if (F == 'P') {
					score += 2;
				}
			}
		}
		return score;
	}
}
