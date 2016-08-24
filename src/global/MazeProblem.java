package global;

import java.util.Random;

public class MazeProblem {
	
	private final static int[] H = {1, 0, -1,  0};
	private final static int[] V = {0, 1,  0, -1};
	private static int[][] table;
	
	public MazeProblem(int iniRow, int iniCol, int size, int nBlocks) {

		table = new int[size][size];
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				table[row][col] = 0;
			}
		}
		
		table[iniRow][iniCol] = 1;
		table[size-1][size-1] = 2;
		
		insertBlocks(nBlocks);
		
	}
	
	private void insertBlocks(int n) {
		Random r = new Random();
		int row, col;
		
		for (int i = 0; i < n; i++) {
			row = r.nextInt(table.length);
			col = r.nextInt(table.length);
			if (table[row][col] == 0) {
				table[row][col] = -1;
			} else {
				i--;
			}
		}
	}
	
	public boolean tryOut(int row, int col) {
		boolean done = (table[row][col] == 2);
		int n = 0;
		int r, c;
		
		while (!done && n < 4) {
			r = row + H[n];
			c = col + V[n];
			
			if (r >= 0 && r < table.length
					&& c >= 0 && c < table.length
					&& table[r][c] >= 0) {
				
				table[r][c] = 1;
				done = tryOut(r, c);
				
//				if (!done) {
//					table[r][c] = 0;
//				}
			}
			n++;
		}
		return done;
	}

	public int[][] getTable() {
		return table;
	}

}
