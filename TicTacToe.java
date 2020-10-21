package TicTacToe;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class TicTacToe extends JFrame implements ActionListener {

	private String X = "X";
	private String O = "O";
	private JPanel jpBoard;
	private JButton [][] board;
	private String currentPlayer = X;
	
	public TicTacToe() {
		jpBoard = new JPanel();
		jpBoard.setLayout(new GridLayout(3, 3));

		this.add(jpBoard, BorderLayout.CENTER);

		this.displayBoard();

		this.setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void displayBoard() {
		board = new JButton[3][3];
		for(int row = 0; row<board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new JButton();
				board[row][col].addActionListener(this);
				jpBoard.add(board[row][col]);
			}
		}
	}
	
	public void takeTurn() {
		if (currentPlayer.equals(X)) {
			currentPlayer = O;
		} else {
			currentPlayer = X;
		}
	}
	
	public boolean isWinner(String str) {
		
		var boardWin = new JButton[3][3];
		for(int row = 0; row<boardWin.length; row++) {
			for(int col = 0; col < boardWin[row].length; col++) {
				boardWin[row][col] = board[row][col];
			}
		}
		
				int row = 0;
				int col = 0;
					
				if (boardWin[row][col].getText().equals(str) && boardWin[row][col + 1].getText().equals(str) && boardWin[row][col + 2].getText().equals(str)) return true;
				
				if (boardWin[row + 1][col].getText().equals(str) && boardWin[row + 1][col + 1].getText().equals(str) && boardWin[row + 1][col + 2].getText().equals(str)) return true;
				
				if (boardWin[row + 2][col].getText().equals(str) && boardWin[row + 2][col + 1].getText().equals(str) && boardWin[row + 2][col + 2].getText().equals(str)) return true;
				
				if (boardWin[row][col].getText().equals(str) && boardWin[row + 1][col].getText().equals(str) && boardWin[row + 2][col].getText().equals(str)) return true;
				
				if (boardWin[row][col + 1].getText().equals(str) && boardWin[row + 1][col + 1].getText().equals(str) && boardWin[row + 2][col + 1].getText().equals(str)) return true;
				
				if (boardWin[row][col + 2].getText().equals(str) && boardWin[row + 1][col + 2].getText().equals(str) && boardWin[row + 2][col + 2].getText().equals(str)) return true;
				
				if (boardWin[row][col].getText().equals(str) && boardWin[row + 1][col + 1].getText().equals(str) && boardWin[row + 2][col + 2].getText().equals(str)) return true;
				
				if (boardWin[row + 2][col].getText().equals(str) && boardWin[row + 1][col + 1].getText().equals(str) && boardWin[row][col + 2].getText().equals(str)) return true;
					
		return false;
	}
	
	public void clearBoard(JButton[][] b) {
		for(int row = 0; row<b.length; row++) {
			for(int col = 0; col < b[row].length; col++) {
				b[row][col].setText("");
				b[row][col].setEnabled(true);
			}
		}
	}
	
	public static void main(String[] args) {
		TicTacToe TicTacToeGame = new TicTacToe();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton)e.getSource();
		buttonClicked.setText(currentPlayer);
		buttonClicked.setEnabled(false);
		
		int counter = 0;
		var boardWin = board;
		for(int row = 0; row<boardWin.length; row++) {
			for(int col = 0; col < boardWin[row].length; col++) {
				if(boardWin[row][col].getText().equals(X) || boardWin[row][col].getText().equals(O)) {
					counter++;
				}
			}
		}/*
		if (counter == 11) {
			JOptionPane.showMessageDialog(null, "TIE!");
			int yesNo = JOptionPane.showConfirmDialog(null, "Play Again", " Yes or NO", JOptionPane.YES_NO_OPTION);
			if (yesNo == JOptionPane.YES_NO_OPTION) {
				clearBoard(board);
			}
			else {
		    	System.exit(EXIT_ON_CLOSE);
		    }
		} */
		
		if(this.isWinner(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " YOU WIN!");
			int yesNo = JOptionPane.showConfirmDialog(null, "Play Again", " Yes or NO", JOptionPane.YES_NO_OPTION);
			if (yesNo == JOptionPane.YES_NO_OPTION) {
				clearBoard(board);
			}
			else {
		    	System.exit(EXIT_ON_CLOSE);
		    }
		}
		
		takeTurn();
		System.out.println(currentPlayer);
		
	}
}
