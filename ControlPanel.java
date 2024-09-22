import javax.swing.*;

public class ControlPanel extends JPanel {
    private JButton startButton, restartButton;

    public ControlPanel(GameController controller) {
        startButton = new JButton("Start");
        restartButton = new JButton("Restart");

        startButton.addActionListener(controller);
        restartButton.addActionListener(controller);

        add(startButton);
        add(restartButton);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }
}
