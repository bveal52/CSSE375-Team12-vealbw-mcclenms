package main.presentation;

import javax.swing.*;
import java.awt.*;

public class JFrameManager {

	public JLayeredPane createLayeredPaneForFrame(JFrame frame) {
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(frame.getSize());
		frame.add(layeredPane);
		return layeredPane;
	}

	public JButton createDifficultyButton(String text, int y) {
		JButton button = new JButton(text);
		button.setBounds(100, y, 200, 50);
		return button;
	}


	public void createTitleLabel(JLayeredPane layeredPane) {
		JLabel titleLabel = new JLabel("STAR WARS: SQUADRONS | JAVA EDITION");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(100, 550, 1000, 50);
		layeredPane.add(titleLabel, JLayeredPane.PALETTE_LAYER);
	}

	public void loadBackgroundImage(JFrame frame, JLayeredPane layeredPane) {
		ImageIcon background = scaleImageIcon(new ImageIcon("images/titleImage.jpg"), frame.getWidth(), frame.getHeight());
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
	}

	private ImageIcon scaleImageIcon(ImageIcon imageIcon, int width, int height) {
		Image image = imageIcon.getImage();
		Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(scaledImage);
	}
}
