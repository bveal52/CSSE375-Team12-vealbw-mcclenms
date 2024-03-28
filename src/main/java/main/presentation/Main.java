package main.presentation;

import main.domain.components.ClickComponent;
import main.domain.components.ClickListener;
import main.domain.components.GameAdvanceListener;
import main.datasource.musicStuff;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * The main class for your arcade game.
 * 
 * You can design your game any way you like, but make the game start
 * by running main here.
 * 
 * Also don't forget to write javadocs for your classes and functions!
 * 
 * @author YOUR_NAME
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static final int DELAY=50;
	private BufferedImage imageTitle;
	private JFrameManager frameManager = new JFrameManager();


	
	public Main() {
		JFrame frame = new JFrame("Star Wars: Squadrons | Java Edition");
		frame.setSize(1600, 900);
		frame.setMinimumSize(new Dimension(1400, 800));

		// Create a layered pane
		JLayeredPane layeredPane = frameManager.createLayeredPaneForFrame(frame);

		// Load background image
		frameManager.loadBackgroundImage(frame, layeredPane);

		// Create title label
		frameManager.createTitleLabel(layeredPane);

		// Create difficulty buttons
		JButton easyButton = frameManager.createDifficultyButton("Start Game: Easy", 600);

		JButton mediumButton = frameManager.createDifficultyButton("Start Game: Medium", 650);

		JButton hardButton = frameManager.createDifficultyButton("Start Game: Hard", 700);

		layeredPane.add(easyButton, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(mediumButton, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(hardButton, JLayeredPane.PALETTE_LAYER);

		// Add action listeners to start the game
		easyButton.addActionListener((ActionEvent e) -> {
			startGame(frame, layeredPane, 1);
		});

		mediumButton.addActionListener((ActionEvent e) -> {
			startGame(frame, layeredPane, 2);
		});

		hardButton.addActionListener((ActionEvent e) -> {
			startGame(frame, layeredPane, 3);
		});

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void startGame(JFrame frame, JLayeredPane titlePanel, int difficulty) {
		// remove title panel
		frame.remove(titlePanel);
		JLabel gameLabel = new JLabel("Game Panel");

		// add game panel
		ClickComponent component = new ClickComponent(frame, gameLabel, difficulty);

		frameManager.setupFrameResizing(frame, component);

		

		//add key listener
		KeyListener keys = new ClickListener(component);

		//add game advance listener
		GameAdvanceListener advanceListener = new GameAdvanceListener(component);

		//add music
		musicStuff levelOST = new musicStuff();
		levelOST.playMusic("images/level3OST.wav");
		levelOST.playMusic("images/falconSFX.wav");

		//add components to the frame
		frame.addKeyListener(keys);
		frame.add(gameLabel, BorderLayout.NORTH);
		frame.add(component, BorderLayout.CENTER);

		frame.requestFocusInWindow();

		//start the game
		Timer timer = new Timer(DELAY, advanceListener);
		timer.start();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();
	}

}