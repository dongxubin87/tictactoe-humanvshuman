import javax.swing.*;
import java.awt.*;

public class SettingsPanel {
    JRadioButton xMarkerRadio, oMarkerRadio, player1Radio, player2Radio;
     ButtonGroup markerGroup, whoMovesFirst;
     JPanel mainPanel;

    public SettingsPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));


        JPanel markerPanel = new JPanel(new GridLayout(1, 2));
        markerPanel.setBorder(BorderFactory.createTitledBorder("Choose Marker"));
        xMarkerRadio = new JRadioButton("X", true);
        oMarkerRadio = new JRadioButton("O");
        markerGroup = new ButtonGroup();
        markerGroup.add(xMarkerRadio);
        markerGroup.add(oMarkerRadio);
        markerPanel.add(xMarkerRadio);
        markerPanel.add(oMarkerRadio);


        JPanel firstMovePanel = new JPanel(new GridLayout(1, 2));
        firstMovePanel.setBorder(BorderFactory.createTitledBorder("Who Goes First?"));
        player1Radio = new JRadioButton("Player 1", true);
        player2Radio = new JRadioButton("Player 2");
        whoMovesFirst = new ButtonGroup();
        whoMovesFirst.add(player1Radio);
        whoMovesFirst.add(player2Radio);
        firstMovePanel.add(player1Radio);
        firstMovePanel.add(player2Radio);

        mainPanel.add(markerPanel);
        mainPanel.add(firstMovePanel);
    }

    public char getSelectedMarker() {
        return xMarkerRadio.isSelected() ? 'X' : 'O';
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
