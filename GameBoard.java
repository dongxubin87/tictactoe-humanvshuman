import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameBoard extends JPanel {
    private JButton[][] boardButtons;

    public GameBoard(GameController controller) {
        setLayout(new GridLayout(3, 3));
        boardButtons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardButtons[i][j] = new JButton("");
                boardButtons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                boardButtons[i][j].setBackground(Color.PINK);
                boardButtons[i][j].setFocusPainted(false);
                boardButtons[i][j].setEnabled(false);
                boardButtons[i][j].addActionListener(controller);
                add(boardButtons[i][j]);
            }
        }
    }

    public void playerMove(ActionEvent e, char currentMarker) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == boardButtons[i][j] && boardButtons[i][j].getText().isEmpty()) {
                    boardButtons[i][j].setText(String.valueOf(currentMarker));
                }
            }
        }
    }

    public boolean checkWin(char marker) {

        for (int i = 0; i < 3; i++) {
            if (boardButtons[i][0].getText().equals(String.valueOf(marker)) &&
                    boardButtons[i][1].getText().equals(String.valueOf(marker)) &&
                    boardButtons[i][2].getText().equals(String.valueOf(marker))) {
                return true;
            }
            if (boardButtons[0][i].getText().equals(String.valueOf(marker)) &&
                    boardButtons[1][i].getText().equals(String.valueOf(marker)) &&
                    boardButtons[2][i].getText().equals(String.valueOf(marker))) {
                return true;
            }
        }
        if (boardButtons[0][0].getText().equals(String.valueOf(marker)) &&
                boardButtons[1][1].getText().equals(String.valueOf(marker)) &&
                boardButtons[2][2].getText().equals(String.valueOf(marker))) {
            return true;
        }
        if (boardButtons[0][2].getText().equals(String.valueOf(marker)) &&
                boardButtons[1][1].getText().equals(String.valueOf(marker)) &&
                boardButtons[2][0].getText().equals(String.valueOf(marker))) {
            return true;
        }
        return false;
    }

    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardButtons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardButtons[i][j].setText("");
            }
        }
    }

    public void enableBoard(boolean enabled) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardButtons[i][j].setEnabled(enabled);
            }
        }
    }
}

