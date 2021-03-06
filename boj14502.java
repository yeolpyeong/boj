
/*
 * 연구소
 * https://www.acmicpc.net/problem/14502
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14502 {
	static final int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

	static int N, M, nWall, nVirus, minNVirus = Integer.MAX_VALUE;
	static int[][] map, visited;

	public static void buildWalls(int ix, int iy, int jx, int jy, int kx, int ky) {
		map[ix][iy] = 1;
		map[jx][jy] = 1;
		map[kx][ky] = 1;
	}

	public static void spreadVirus(int x, int y) {
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 1 || ny < 1 || nx > N || ny > M) {
				continue;
			}

			if (map[nx][ny] != 1 && visited[nx][ny] == 0) {
				visited[nx][ny] = 1;
				nVirus += 1;
				spreadVirus(nx, ny);
			}
		}
	}

	public static void findVirus() {
		visited = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 2 && visited[i][j] == 0) {
					nVirus += 1;
					visited[i][j] = 1;
					spreadVirus(i, j);
				}
			}
		}

		minNVirus = nVirus < minNVirus ? nVirus : minNVirus;
		nVirus = 0;
	}

	public static void breakWalls(int ix, int iy, int jx, int jy, int kx, int ky) {
		map[ix][iy] = 0;
		map[jx][jy] = 0;
		map[kx][ky] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				nWall += map[i][j] == 1 ? 1 : 0;
			}
		}

		for (int ix = 1; ix <= N; ix++) {
			for (int iy = 1; iy <= M; iy++) {
				for (int jx = 1; jx <= N; jx++) {
					for (int jy = 1; jy <= M; jy++) {
						for (int kx = 1; kx <= N; kx++) {
							for (int ky = 1; ky <= M; ky++) {
								if (map[ix][iy] != 0 || map[jx][jy] != 0 || map[kx][ky] != 0) {
									continue;
								}

								if (10 * ix + iy >= 10 * jx + jy || 10 * ix + iy >= 10 * kx + ky
										|| 10 * jx + jy >= 10 * kx + ky) {
									continue;
								}

								buildWalls(ix, iy, jx, jy, kx, ky);
								findVirus();
								breakWalls(ix, iy, jx, jy, kx, ky);
							}
						}
					}
				}
			}
		}

		System.out.println(N * M - (nWall + 3) - minNVirus);
	}

}
