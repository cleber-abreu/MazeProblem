package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import global.MazeProblem;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private static Board board;

	public static void main(String[] args) {

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
				
				JFrame frmMain = new JFrame("Maze Problem");
				board = new Board();
				
				frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmMain.setLayout(new BorderLayout());
				frmMain.setBackground(Color.DARK_GRAY);
				frmMain.add(board, BorderLayout.CENTER);
				frmMain.pack();
				frmMain.setLocationRelativeTo(null);
				frmMain.setVisible(true);
				
				MazeProblem maze = new MazeProblem(0, 0, 10, 25);
				board.paintBoard(maze.getTable());
//				board.repaint();
				
//				if (maze.tryOut(0, 0)) {
//					System.out.println("ok");
//					
//					int[][] table = maze.getTable();
//					for (int row = 0; row < table.length; row++) {
//						for (int col = 0; col < table.length; col++) {
//							System.out.print(table[row][col] + "\t");
//						}
//						System.out.println();
//					}
//				} else {
//					System.out.println("Deu ruim");
//				}
			}
		});
	}

}
