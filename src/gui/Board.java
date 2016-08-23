package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class Board extends JPanel{
	
	private Field[][] fields;
	
	public Board() {
		
		setLayout(new GridBagLayout());
		setBackground(Color.LIGHT_GRAY);
		setBorder(new MatteBorder(8, 8, 8, 8, Color.DARK_GRAY));
		fields = new Field[10][10];
		Border border = new MatteBorder(1, 1, 1, 1, Color.WHITE);
		
		GridBagConstraints grid = new GridBagConstraints();
		
		for (int row = 0; row < fields.length; row++) {
			for (int col = 0; col < fields.length; col++) {
				grid.gridx = col;
				grid.gridy = row;
				fields[row][col] = new Field();
				fields[row][col].setBorder(border);
				add(fields[row][col], grid);
			}
			
		}
		
		fields[0][0].setBackground(Color.GREEN);
	}

}
