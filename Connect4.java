
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Connect4 extends JFrame implements ActionListener {
	
	private Color Julio = Color.RED;
	private Color Brianna = Color.CYAN;
	
	private String redPlayer = "Red";
	private String otherPlayer = "Cyan";
	
	private Color startingColor = Color.LIGHT_GRAY;
	
	private String currentPlayer = redPlayer;
	private Color currentColor = Julio;
	private JPanel panel;
	private JButton[][] buttons;
	private JButton[] insert;
	private String emptyMarker = "Empty";
	private String bottomMarker = "Bottom";
	
	public Connect4() {
		
		//JFrame frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7));
		panel.setBackground(Color.LIGHT_GRAY);
		//panel.setBackground(Color.BLUE);
		this.add(panel, BorderLayout.CENTER);
		
		
		this.insertPoint();
		this.rowsAndCols();
		
		this.setSize(1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void insertPoint() {
		insert = new JButton[7];
		for (int cols = 0; cols < insert.length; cols++) {
			insert[cols] = new JButton();
			insert[cols].setText("INSERT");
			insert[cols].addActionListener(this);
			panel.add(insert[cols]);
		}
	}
	
	public void rowsAndCols() {
		buttons = new JButton[6][7];
		
		for (int rows = 0; rows < buttons.length; rows++) {
			for (int cols = 0; cols < buttons[0].length; cols++) {
				buttons[rows][cols] = new JButton();
				if (rows == buttons.length - 1) {
					buttons[rows][cols].setText(bottomMarker);
				} else {
					buttons[rows][cols].setText(emptyMarker);
				}
			//	buttons[rows][cols].setBorder(new RoundedBorder(300));
				buttons[rows][cols].setEnabled(false);
				buttons[rows][cols].addActionListener(this);
				panel.add(buttons[rows][cols]);
			}
		}
	}
	
	public int getCol(JButton buttonClicked) {
		
		JButton[] arr = insert;
		
		int result = -1;
		
		for (int cols = 0; cols < arr.length; cols++) {
			if (arr[cols] == buttonClicked) {
				result = cols;
			}
		}
		
		return result;
	}
	
	public int getRow(JButton buttonClicked) {
		
		int result = -1;
		
		for (int rows = 0; rows < buttons.length; rows++) {
			for (int cols = 0; cols < buttons[0].length; cols++) {
				if(buttons[rows][cols] == buttonClicked) {
					result = rows;
				}
			}
		}
		return result;
	}
	
	public void turnPlay(JButton buttonClicked) {
		int columnOfButtonClicked = getCol(buttonClicked);	
		//Not setting new bottomMarker
		if (buttons[0][columnOfButtonClicked].getText().equals(bottomMarker)) {
			buttonClicked.setEnabled(false);
			for (int rows = 0; rows < buttons.length; rows++) {
				if (buttons[rows][columnOfButtonClicked].getText().equals(bottomMarker)) {
					buttons[rows][columnOfButtonClicked].setText(currentPlayer);                        
					buttonColorer(buttons[rows][columnOfButtonClicked]);
				}
			} return;
		}
		//Setting new bottomMarker
		for (int rows = 0; rows < buttons.length; rows++) {
			if (buttons[rows][columnOfButtonClicked].getText().equals(bottomMarker)) {
				buttons[rows][columnOfButtonClicked].setText(currentPlayer);
				buttonColorer(buttons[rows][columnOfButtonClicked]);
				buttons[rows - 1][columnOfButtonClicked].setText(bottomMarker);
			}
		}
	}
	
	public boolean checkRowWin() {
		for(int rows = 0; rows < buttons.length; rows++) {
			for (int cols = 0; cols < 4; cols++) {
					if (buttons[rows][cols].getText().equals(currentPlayer)) {
						if ((buttons[rows][cols + 1].getText().equals(currentPlayer)) && (buttons[rows][cols + 2].getText().equals(currentPlayer)) && (buttons[rows][cols + 3].getText().equals(currentPlayer))) {
							return true;
						}
					}
				}
			}
		return false;
	}
	
	public boolean checkColWin() {
		for(int rows = 0; rows < 3; rows++) {
			for (int cols = 0; cols < buttons[0].length; cols++) {
					if (buttons[rows][cols].getText().equals(currentPlayer)) {
						if ((buttons[rows + 1][cols].getText().equals(currentPlayer)) && (buttons[rows + 2][cols].getText().equals(currentPlayer)) && (buttons[rows + 3][cols].getText().equals(currentPlayer))) {
							return true;
						}
					}
				}
			}
		return false;
	}
	
	public boolean checkDiagonalDown() {
		for(int rows = 0; rows < 3; rows++) {
			for (int cols = 0; cols < 4; cols++) {
					if (buttons[rows][cols].getText().equals(currentPlayer)) {
						if ((buttons[rows + 1][cols + 1].getText().equals(currentPlayer)) && (buttons[rows + 2][cols + 2].getText().equals(currentPlayer)) && (buttons[rows + 3][cols + 3].getText().equals(currentPlayer))) {
							return true;
						}
					}
				}
			}
		return false;
	}
	
	public boolean checkDiagonalUp() {
		for (int rows = 3; rows < buttons.length; rows++) {
			for (int cols = 0; cols < 3; cols++) {
				if (buttons[rows][cols].getText().equals(currentPlayer)) {
					if ((buttons[rows - 1][cols + 1].getText().equals(currentPlayer)) && (buttons[rows - 2][cols + 2].getText().equals(currentPlayer)) && (buttons[rows - 3][cols + 3].getText().equals(currentPlayer))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//[ ][ ][ ][ ][ ][ ][ ]
	//[ ][ ][ ][ ][ ][ ][ ]
	//[ ][ ][ ][ ][ ][ ][ ]
	//[ ][ ][ ][ ][ ][ ][ ]
	//[ ][ ][ ][ ][ ][ ][ ]
	//[ ][ ][ ][ ][ ][ ][ ]
	
	public boolean isThereWinner(){
		
		if (checkRowWin()) return true;
		if (checkColWin()) return true;
		if (checkDiagonalDown()) return true;
		if (checkDiagonalUp()) return true;
		
		return false;
		
	}
	
	public void buttonColorer(JButton button) {
		button.setOpaque(true);
		button.setBackground(currentColor);
	}
	
	
	public void changeTurn() {
		if (currentColor == Julio) {
			currentColor = Brianna;
		} else {
			currentColor = Julio;
		}
		
		if (currentPlayer.equals(redPlayer)) {
			currentPlayer = otherPlayer;
		} else {
			currentPlayer = redPlayer;
		}
		
	}
	

	public static void main(String[] args) {
		Connect4 game = new Connect4();
	}
	
	public void updateBoard(JButton[][] newButtons) {
		this.buttons = newButtons;
	}
	
	public void clearBoard() {
		
		currentColor = Brianna;
		currentPlayer = otherPlayer;
		
		for (int cols = 0; cols < insert.length; cols++) {
			insert[cols].setEnabled(true);
			insert[cols].setText("INSERT");
		}
		
		for (int rows = 0; rows < buttons.length; rows++) {
			for (int cols = 0; cols < buttons[0].length; cols++) {
				if (rows == buttons.length - 1) {
					buttons[rows][cols].setText(bottomMarker);
				} else {
					buttons[rows][cols].setText(emptyMarker);
				}
				buttons[rows][cols].setBackground(startingColor);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			JButton buttonClicked = (JButton)e.getSource();
			turnPlay(buttonClicked);
			
			if (isThereWinner()) {
				JOptionPane.showMessageDialog(null, currentPlayer + " You Win!");
				int yesNo = JOptionPane.showConfirmDialog(null, "Play Again", " Yes or No", JOptionPane.YES_NO_OPTION);
				if (yesNo == JOptionPane.YES_NO_OPTION) {
					clearBoard();
				}
				else {
			    	System.exit(EXIT_ON_CLOSE);
			    }
			}
			changeTurn();
	}
}
