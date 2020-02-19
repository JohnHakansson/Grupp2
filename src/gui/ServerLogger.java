package gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerLogger {

    private JTextArea txtArea;
    private JPanel middlePanel;

    public ServerLogger(){

        middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder (), "Game info"));

        txtArea = new JTextArea(16, 58);
        txtArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        middlePanel.add(scroll);


        JFrame frame = new JFrame("Server logger");
        frame.setResizable(false);
        frame.add(middlePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void log(String log){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        txtArea.append(formatter.format(date) + " - " + log + "\n");
    }
}
