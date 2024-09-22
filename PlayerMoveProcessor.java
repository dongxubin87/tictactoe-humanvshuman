import java.awt.event.ActionEvent;

public class PlayerMoveProcessor {
     GameBoard gameBoard;
     GameController controller;

    public PlayerMoveProcessor(GameBoard gameBoard, GameController controller) {
        this.gameBoard = gameBoard;
        this.controller = controller;
    }

    public void handlePlayerMove(ActionEvent e, char currentMarker, boolean gameStarted) {
        if (!gameStarted) return;

        gameBoard.playerMove(e, currentMarker);

        if (gameBoard.checkWin(currentMarker)) {
            controller.displayMessage(currentMarker + " wins!");
            controller.setGameStarted(false);
        } else if (gameBoard.checkDraw()) {
            controller.displayMessage("It's a draw!");
            controller.setGameStarted(false);
        } else {
            controller.switchMarker();
        }
    }
}

