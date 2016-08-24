package global;

import java.util.Random;

public class MazeProblem {
	
	private final static int[] H = {1, 0, -1,  0};
	private final static int[] V = {0, 1,  0, -1};
	private int[][] fields;
	private int height;
	private int width;
	
	public MazeProblem(int iniRow, int iniCol, 
			int endRow, int endCol,
			int height, int width, 
			int nBlocks) {

		fields = new int[height][width];
		this.height = height;
		this.width = width;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				fields[row][col] = 0;
			}
		}
		
		fields[iniRow][iniCol] = 2;
		fields[endRow][endCol] = 3;
		
		insertBlocks(nBlocks);
		
	}
	
	private void insertBlocks(int n) {
		Random r = new Random();
		int row, col;
		
		for (int i = 0; i < n; i++) {
			row = r.nextInt(height);
			col = r.nextInt(width);
			if (fields[row][col] == 0) {
				fields[row][col] = -1;
			} else {
				i--;
			}
		}
	}
	
	public boolean tryOut(int row, int col, int i) {
		int n = 0;
		int r, c;
		boolean done = (fields[row][col] == 3);
		
		while (!done && n < 4) {
			r = row + H[n];
			c = col + V[n];
			
			if (r >= 0 && r < height
					&& c >= 0 && c < width) {
				
					if (fields[r][c] == 0) {
						fields[r][c] = 1;
						done = tryOut(r, c, i+1);
					}				
					else if (fields[r][c] == 3){
						done = tryOut(r, c, i+1);
					}
			}
			n++;
		}
		return done;
	}

	public int[][] getFields() {
		return fields;
	}

}
