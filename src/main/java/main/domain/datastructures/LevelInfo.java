package main.domain.datastructures;

public class LevelInfo {

	private String[][] levelData;
	private int pixelModifierX;
	private int pixelModifierY;
	private int difficulty;

	private int currentPlayerHealth;

	private int currentPlayerPoints;

	public LevelInfo(String[][] levelData, int pixelModifierX, int pixelModifierY, int difficulty
		, int currentPlayerHealth, int currentPlayerPoints) {
		this.levelData = levelData;
		this.pixelModifierX = pixelModifierX;
		this.pixelModifierY = pixelModifierY;
		this.difficulty = difficulty;
		this.currentPlayerHealth = currentPlayerHealth;
		this.currentPlayerPoints = currentPlayerPoints;

	}

	public String[][] getLevelData() {
		return levelData;
	}

	public int getPixelModifierX() {
		return pixelModifierX;
	}

	public int getPixelModifierY() {
		return pixelModifierY;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public int getCurrentPlayerHealth() {
		return currentPlayerHealth;
	}

	public int getCurrentPlayerPoints() {
		return currentPlayerPoints;
	}

}
