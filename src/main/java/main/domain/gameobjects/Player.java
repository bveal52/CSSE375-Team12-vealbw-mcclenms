package main.domain.gameobjects;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject {


	private int difficulty;
	//private final int MAX_HEALTH = 20;

	private String imgFilename = "images/fillimium_malcon.png";
	public boolean fuelCooldown;
	
	public Player(int positionX, int positionY, int difficulty, int health) {
		super(positionX, positionY);
		this.difficulty = difficulty;
		this.type = 1;
		this.maxSpeed = 8;
		this.setObjectSize(100,100);
		this.setSlowable(true);

		if(health == 0) {
			if(this.difficulty == 1) {
				this.setHealth(60);
			} else if (this.difficulty == 2) {
				this.setHealth(40);
			} else if (this.difficulty == 3) {
				this.setHealth(20);
			} else {
				this.setHealth(40);
			}
		}
		else {
			this.setHealth(health);
		}

		try {
			this.setImage(ImageIO.read(new File(imgFilename)));
		} catch (IOException e) {
			System.out.println("playermodel not found!");
		}
		
	}

	@Override
	/**
	 *  play explosion animation and remove object from game
	 */
	public void explode() {
		// add animation and remove object from the game
		// die
	}
	@Override
	/**
	 * moves the object forwards
	 * @param distance
	 */
	public void moveForwards() {
		super.moveForwards();
		
		
		if (this.getTotalVelocity() > 6) {
			this.imgFilename = "images/fillimium_malcon.png";
		} else {
			this.imgFilename = "images/fillimium_malconLow.png";
		}
		
		try {
			this.setImage(ImageIO.read(new File(imgFilename)));
		} catch (IOException e) {
			System.out.println("playermodel not found!");
		}
	}
	
	
	@Override
	/**
	 * continuation of momentum
	 */
	public void continuePath() {
		super.continuePath();
		
		// reset image to default
		this.imgFilename = "images/fillimium_malconLow.png";
		try {
			this.setImage(ImageIO.read(new File(imgFilename)));
		} catch (IOException e) {
			System.out.println("playermodel not found!");
		}
		
	}
	
	public int getRotation() {
		return this.rotationAngle;
	}

	public void moveDown() {
		this.positionY += 1;
	}

	public void increaseMaxSpeed() {
		this.maxSpeed += 5;
	}

	public int getMaxSpeed() {
		return this.maxSpeed;
	}


}
