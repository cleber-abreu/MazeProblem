package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import global.MazeProblem;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	

	public static void main(String[] args) {
		
		JFrame frmMain = new JFrame("Maze Problem");
		Board board = new Board();
		JPanel pnlOptions = new JPanel();
		JTextField txtIniX = new JTextField("0");
		JTextField txtIniY = new JTextField("0");
		JTextField txtEndX = new JTextField("9");
		JTextField txtEndY = new JTextField("9");
		JTextField txtBlocks = new JTextField("30");
		JButton btnStart = new JButton("Iniciar");
		
		txtIniX.setPreferredSize(new Dimension(32, 22));
		txtIniY.setPreferredSize(new Dimension(32, 22));
		txtEndX.setPreferredSize(new Dimension(32, 22));
		txtEndY.setPreferredSize(new Dimension(32, 22));
		txtBlocks.setPreferredSize(new Dimension(32, 22));
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MazeProblem maze = new MazeProblem(
						Integer.parseInt(txtIniY.getText()),
						Integer.parseInt(txtIniX.getText()),
						Integer.parseInt(txtEndY.getText()),
						Integer.parseInt(txtEndX.getText()),
						10, 10, 
						Integer.parseInt(txtBlocks.getText()));
				board.paintBoard(maze.getFields());
				
				if (maze.tryOut(
						Integer.parseInt(txtIniY.getText()),
						Integer.parseInt(txtIniX.getText()), 
						1)) {
					board.paintBoard(maze.getFields());
					
				} else {
					JOptionPane.showMessageDialog(frmMain, 
							"Não foi possível encontrar saída.",
							"Falha",
							JOptionPane.ERROR_MESSAGE);
				}
				super.mouseClicked(arg0);
			}
		});
		
		GridBagConstraints grid = new GridBagConstraints();
		pnlOptions.setLayout(new GridBagLayout());
		pnlOptions.setPreferredSize(new Dimension(180, 180));
		grid.insets = new Insets(8, 0, 0, 0);
		
		grid.gridwidth = 4;
		grid.gridx = 0;
		grid.gridy = 0;
		pnlOptions.add(new Label("INICIO"), grid);
		
		grid.gridwidth = 1;
		grid.gridx = 0;
		grid.gridy = 1;
		pnlOptions.add(new Label("X"), grid);
		
		grid.gridwidth = 1;
		grid.gridx = 1;
		grid.gridy = 1;
		pnlOptions.add(txtIniX, grid);
		
		grid.gridwidth = 1;
		grid.gridx = 2;
		grid.gridy = 1;
		pnlOptions.add(new Label("Y"), grid);
		
		grid.gridwidth = 1;
		grid.gridx = 3;
		grid.gridy = 1;
		pnlOptions.add(txtIniY, grid);
		
		grid.gridwidth = 4;
		grid.gridx = 0;
		grid.gridy = 3;
		pnlOptions.add(new Label("SAÍDA"), grid);
		
		grid.gridwidth = 1;
		grid.gridx = 0;
		grid.gridy = 4;
		pnlOptions.add(new Label("X"), grid);
		
		grid.gridwidth = 1;
		grid.gridx = 1;
		grid.gridy = 4;
		pnlOptions.add(txtEndX, grid);
		
		grid.gridwidth = 1;
		grid.gridx = 2;
		grid.gridy = 4;
		pnlOptions.add(new Label("Y"), grid);
		
		grid.gridwidth = 1;
		grid.gridx = 3;
		grid.gridy = 4;
		pnlOptions.add(txtEndY, grid);
		
		grid.gridwidth = 3;
		grid.gridx = 0;
		grid.gridy = 6;
		pnlOptions.add(new Label("Obstaculos"), grid);
		
		grid.gridwidth = 1;
		grid.gridx = 3;
		grid.gridy = 6;
		pnlOptions.add(txtBlocks, grid);
		
		grid.gridwidth = 4;
		grid.gridx = 0;
		grid.gridy = 8;
		pnlOptions.add(btnStart, grid);
		
		
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setLayout(new BorderLayout());
		frmMain.setBackground(Color.DARK_GRAY);
		frmMain.add(board, BorderLayout.CENTER);
		frmMain.add(pnlOptions, BorderLayout.EAST);
		frmMain.pack();
		frmMain.setLocationRelativeTo(null);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | 
                		InstantiationException | 
                		IllegalAccessException | 
                		UnsupportedLookAndFeelException e) {
                }
				
				frmMain.setVisible(true);
				
			}
		});
		
	}

}
