package main.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import main.client.GameClient;

/**
 * Class that creates the menu window for the user. 
 * The user can choose to click on three buttons
 * Host: Creates a game main.server that multiple users can then connect to
 * Join: Connect to an existing game main.server
 * Quit: Exit application
 * @author Julian Hultgren, Lukas Persson, Erik Johansson, Simon Börjesson
 * Version 2.0
 *
 */

public class MenuFrame implements ActionListener{
	private	IconPanel iconPanel;
	private	JButton host = new JButton("Host");
	private	JButton join = new JButton("Join");
	private	JButton quit = new JButton("Quit");
	private JButton btnHowToPlay = new JButton("How to play");

	private GridBagLayout layout = new GridBagLayout();	
	private	JPanel panel = new JPanel(new GridLayout(5,1,10,10));
	JFrame frame = new JFrame("Main Menu");
	
	/**
	 * Constructor who receives an ImageIcon object.
	 * The constructor also builds the menu box
	 * @param	icon
	 */
	
	public MenuFrame(ImageIcon icon) {
		
		iconPanel = new IconPanel(icon);
		iconPanel.setLayout(layout);
		panel.setPreferredSize(new Dimension(250,150));
		panel.setOpaque(false);
		panel.add(host);
		panel.add(join);
		panel.add(quit);
		panel.add(btnHowToPlay);
	
		iconPanel.add(panel,new GridBagConstraints());
		iconPanel.setPreferredSize(new Dimension(800,600));
		
		host.addActionListener(this);
		join.addActionListener(this);
		quit.addActionListener(this);
		btnHowToPlay.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(iconPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}	
	
	/**
	 * Method is called for when a user clicks on any of the buttons. 
	 * Host: Creates a game main.server that multiple users can then join.
	 * Join: Connecting to an existing game main.server.
	 * Quit: Closes the application
	 */
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == host) {
			System.out.println("Någon har klickat på 'Host'"); //Kommentar för White box-testning - Julian Hultgren
			GameClient gc = new GameClient();
			ClientFrame gf = new ClientFrame(gc);
			ServerFrame sf = new ServerFrame();
			frame.dispose();
		}
		if(e.getSource() == join) {
			System.out.println("Någon har klickat på 'Join'"); //Kommentar för White box-testning - Julian Hultgren
			GameClient gc = new GameClient();
			ClientFrame gf = new ClientFrame(gc);
			frame.dispose();
		}
		if(e.getSource() == quit) {
			System.out.println("Någon har klickat på 'Quit'"); //Kommentar för White box-testning - Julian Hultgren
			System.exit(0);
		}
		if(e.getSource() == btnHowToPlay){
			showGameInfo();
		}

	}

	public void showGameInfo(){

		JPanel panelGameInfo = new JPanel();
		panelGameInfo.setBorder(new TitledBorder(new EtchedBorder(), "Play instructions"));

		JTextArea txtArea = new JTextArea(16, 120);
		txtArea.setEditable(false);

		JScrollPane scroll = new JScrollPane(txtArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		panelGameInfo.add(scroll);


		JFrame frame = new JFrame("Game info");
		frame.setResizable(false);
		frame.add(panelGameInfo);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		File file = new File("files/test.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String st;
			while ((st = br.readLine()) != null)
				txtArea.append(st + "\n");
		}catch(Exception e){
			System.err.println(e);

	}

}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuFrame(new ImageIcon("images/bg.jpg"));
			}
		});
	}
}
