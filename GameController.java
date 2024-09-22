import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
     JFrame frame;
     GameBoard gameBoard;
     ControlPanel controlPanel;
     SettingsPanel settingsPanel;
     PlayerMoveProcessor playerMoveProcessor;

    char currentMarker;
    boolean gameStarted;

    public GameController() {

        frame = new JFrame("Tic-Tac-Toe Game");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        gameBoard = new GameBoard(this);
        controlPanel = new ControlPanel(this);
        settingsPanel = new SettingsPanel();
        playerMoveProcessor = new PlayerMoveProcessor(gameBoard, this);


        frame.add(gameBoard, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(settingsPanel.getMainPanel(), BorderLayout.NORTH);

        gameStarted = false;
        currentMarker = 'X';

        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controlPanel.getStartButton()) {
            startGame();
        } else if (e.getSource() == controlPanel.getRestartButton()) {
            restartGame();
        } else {
            playerMoveProcessor.handlePlayerMove(e, currentMarker, gameStarted);
        }
    }

    public void startGame() {
        gameBoard.enableBoard(true);
        currentMarker = settingsPanel.getSelectedMarker();
        gameStarted = true;
    }

    public void restartGame() {
        gameBoard.clearBoard();
        gameStarted = false;
    }

    public void switchMarker() {
        currentMarker = (currentMarker == 'X') ? 'O' : 'X';
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void setGameStarted(boolean started) {
        gameStarted = started;
    }
}
