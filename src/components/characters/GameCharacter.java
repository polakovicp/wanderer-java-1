package components.characters;

import components.Dice;
import components.PositionedImage;
import components.graphics.Arena;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public abstract class GameCharacter extends PositionedImage {
    protected int currentHealth;
    protected int maxHealth;
    protected int defencePoints;
    protected int strikePoints;
    protected Dice dice;
    protected String strikeMessage;

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDefense() {
        return defencePoints;
    }

    public int getStrike() {
        return strikePoints;
    }

    public GameCharacter(int posX, int posY) {
        super(posX, posY);
    }

    public abstract boolean validateStepX(int directionX, Arena arena);

    public abstract boolean validateStepY(int directionY, Arena arena);

    public abstract boolean moveX(int directionX, Arena arena);

    public abstract boolean moveY(int directionY, Arena arena);

    public abstract GameCharacter clone(int x, int y);

    public abstract void strike(GameCharacter anotherChar);

    public abstract void getHit(int damage);

    public abstract int getCurrentHealth();

    public abstract boolean isAlive();

    public void setCharIcon(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void die() {
        this.setCharIcon("resources/img/blood.png");
    }

    public String getStrikeMessage() {
        return strikeMessage;
    }

    public void setStrikeMessage(String strikeMessage) {
        this.strikeMessage = strikeMessage;
    }

    public void copyStats(GameCharacter otherChar) {
        this.currentHealth = otherChar.currentHealth;
        this.maxHealth = otherChar.maxHealth;
        this.defencePoints = otherChar.defencePoints;
        this.strikePoints = otherChar.strikePoints;
    }
}
