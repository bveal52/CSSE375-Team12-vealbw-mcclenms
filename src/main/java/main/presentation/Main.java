package main.presentation;

import main.datasource.MusicPlayback;
import main.domain.components.ClickComponent;
import main.domain.components.GameAdvanceListener;

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
 * @author Matthew McClenahan and Brady Veal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static final int DELAY=1000 / 100;

	public static final int BACKGROUND_MUSIC = 1000;

	public static final int FALCON_MUSIC = 1001;

	private BufferedImage imageTitle;
	private JFrameManager frameManager = new JFrameManager();


	
	public Main() {
		JFrame frame = new JFrame("Star Wars: Squadrons | Java Edition");
		frame.setSize(1600, 900);
		frame.setMinimumSize(new Dimension(1400, 800));
    
		JLayeredPane layeredPane = frameManager.createLayeredPaneForFrame(frame);

		frameManager.loadBackgroundImage(frame, layeredPane);
		frameManager.createTitleLabel(layeredPane);

		JButton easyButton = frameManager.createDifficultyButton("Start Game: Easy", 650);

		JButton mediumButton = frameManager.createDifficultyButton("Start Game: Medium", 700);

		JButton hardButton = frameManager.createDifficultyButton("Start Game: Hard", 750);

		JButton howToPlayButton = frameManager.createDifficultyButton("How to Play", 600);


		layeredPane.add(easyButton, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(mediumButton, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(hardButton, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(howToPlayButton, JLayeredPane.PALETTE_LAYER);

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

		howToPlayButton.addActionListener((ActionEvent e) -> {
			// Open a joptionpane with instructions
			JOptionPane.showMessageDialog(frame, "Use the arrow keys to move the ship\nPress space to shoot\nAvoid asteroids and enemy ships\nCollect powerups to increase your health or speed\nRepair the mothership and then fuel it to win the game\n\nGood luck!");
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

		//add game advance listener
		GameAdvanceListener advanceListener = new GameAdvanceListener(component);


		Timer timer = new Timer(DELAY, advanceListener);
		//add key listener
		KeyListener keys = new ClickListener(component, timer);

		//add music
		//musicStuff levelOST = new musicStuff();
		MusicPlayback levelOST = new MusicPlayback();
		levelOST.play("images/level3OST.wav", true);
		levelOST.play("images/falconSFX.wav", true);

		//add components to the frame
		frame.addKeyListener(keys);
		frame.add(gameLabel, BorderLayout.NORTH);
		frame.add(component, BorderLayout.CENTER);

		frame.requestFocusInWindow();

		//start the game
		timer.start();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();
	}

}