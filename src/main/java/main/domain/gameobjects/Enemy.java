package main.domain.gameobjects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.datasource.MusicPlayback;
import main.domain.components.ClickComponent;


public class Enemy extends GameObject {


	private int enemyClass;
	private String E1Filename = "images/enemy1.png";
	private String E2Filename = "images/enemy2.png";
	//protected double maxSpeed = 5; // Set this to whatever speed you want for the enemy

	//musicStuff tieLaser = new musicStuff();

	MusicPlayback tieLaser = new MusicPlayback();
	
	/**
	 * Constructor 
	 * @param positionX
	 * @param positionY
	 * @param enemyClass
	 */
	public Enemy(int positionX, int positionY, int enemyClass) {
		super(positionX, positionY);
	
		if (enemyClass == 0) {
			try {
				this.setImage(ImageIO.read(new File(E1Filename)));
				this.maxSpeed = 4;
				this.setHealth(20);
				this.setObjectSize(70,70);
			} catch (IOException e) {
				System.out.println("enemy1 not found!");
			}
		} else {
			try {
				this.setImage(ImageIO.read(new File(E2Filename)));
				this.maxSpeed = 6;
				this.setHealth(40);
				this.setObjectSize(90,70);
			} catch (IOException e) {
				System.out.println("enemy2 not found!");
			}
		}
		this.enemyClass = enemyClass;
		this.type = 2;
	
	}

	
	/**
	 * AI motion
	 */
	public void enemyMove(ClickComponent component) {
		this.moveForwards();
		if (this.getPositionX() > component.getFrame().getWidth() - 50 || this.getPositionX() < 50) {
			this.turn(180);
			this.velocityX = - this.velocityX;
		}
		
		if (this.enemyClass == 0) {
			// don't shoot
		} else {
			if (Math.random() < 0.05) {
				Projectile laser = this.fireLaser();
				component.currentObjects.add(laser);
				component.getCurrentProjectiles().add(laser);
				tieLaser.play("images/tieLaser.wav", false);
				
				
				
			}
			
		}
		
		
	}
	
	/**
	 * 
	 * @returns the newly created/fired laser
	 */
	public Projectile fireLaser() {
		Projectile laser = new Projectile(this.getPositionX(), this.getPositionY(), this.rotationAngle, false);
		return laser;
	}

	public int getEnemyClass() {
		return this.enemyClass;
	}
	
}
