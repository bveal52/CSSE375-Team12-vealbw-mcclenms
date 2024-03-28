package main.domain.datastructures;

public class LevelInfo {

	private String[][] levelData;
	private int pixelModifierX;
	private int pixelModifierY;
	private int difficulty;

	public LevelInfo(String[][] levelData, int pixelModifierX, int pixelModifierY, int difficulty) {
		this.levelData = levelData;
		this.pixelModifierX = pixelModifierX;
		this.pixelModifierY = pixelModifierY;
		this.difficulty = difficulty;
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

}
