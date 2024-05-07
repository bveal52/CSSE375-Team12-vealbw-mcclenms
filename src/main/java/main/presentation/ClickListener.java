package main.presentation;

import main.datasource.MusicPlayback;
import main.domain.components.ClickComponent;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.TreeSet;

public class ClickListener implements KeyListener {

    private final Set<Integer> pressed = new TreeSet<Integer>();
    MusicPlayback turbolaser = new MusicPlayback();
    private final ClickComponent component;
    private Timer timer;

    public ClickListener(ClickComponent component, Timer timer) {
        this.component = component;
        this.timer = timer;
    }

    protected ClickListener(ClickComponent component) {
        this.component = component;
    }


    @Override
    public void keyPressed(KeyEvent input) {
        //System.out.println("Key Pressed!");

        int c =
            input.getKeyCode(); // disclaimer -> the technique used for multiple inputs at the same time is taken from https://stackoverflow.com/questions/22580933/diagonal-movement-of-a-sprite
        pressed.add(c);

        if (pressed.size() > 1) {
            Integer[] array = pressed.toArray(new Integer[]{});

            if (array[0] == KeyEvent.VK_W || array[0] == KeyEvent.VK_A ||
                array[0] == KeyEvent.VK_S || array[0] == KeyEvent.VK_D) {
                showWASDError();
            }

            if (array[0] == KeyEvent.VK_SPACE && array[1] == KeyEvent.VK_LEFT) {
                this.component.left();
                this.component.playerFire();
                this.component.drawScreen();
            } else if (array[0] == KeyEvent.VK_SPACE && array[1] == KeyEvent.VK_RIGHT) {
                this.component.right();
                this.component.playerFire();
                this.component.drawScreen();
            } else if (array[0] == KeyEvent.VK_SPACE && array[1] == KeyEvent.VK_UP) {
                this.component.up();
                this.component.playerFire();
                this.component.drawScreen();
            } else if (array[0] == KeyEvent.VK_SPACE && array[1] == KeyEvent.VK_DOWN) {
                this.component.down();
                this.component.playerFire();
                this.component.drawScreen();
            } else if (array[0] == KeyEvent.VK_LEFT && array[1] == KeyEvent.VK_UP) {
                this.component.up();
                this.component.left();
                this.component.drawScreen();
            } else if (array[0] == KeyEvent.VK_UP && array[1] == KeyEvent.VK_RIGHT) {
                this.component.up();
                this.component.right();
                this.component.drawScreen();
            } else if (array[0] == KeyEvent.VK_RIGHT && array[1] == KeyEvent.VK_DOWN) {
                this.component.down();
                this.component.right();
                this.component.drawScreen();
            } else if (array[0] == KeyEvent.VK_LEFT && array[1] == KeyEvent.VK_DOWN) {
                this.component.down();
                this.component.left();
                this.component.drawScreen();
            }
        } else {
            if(c == KeyEvent.VK_W || c == KeyEvent.VK_A || c == KeyEvent.VK_S || c == KeyEvent.VK_D) {
                showWASDError();
            }

            if (c == KeyEvent.VK_LEFT) {
                this.component.left();
            } else if (c == KeyEvent.VK_RIGHT) {
                this.component.right();
            } else if (c == KeyEvent.VK_UP) {
                this.component.up();
            } else if (c == KeyEvent.VK_DOWN) {
                this.component.down();
            } else if (c == KeyEvent.VK_SPACE) {
                this.component.playerFire();
                turbolaser.play("images/turbolaser.wav", false);
            }
        }


        this.component.drawScreen();
    }

    private void showWASDError() {
        timer.stop();

        JOptionPane.showMessageDialog(null,
            "You cannot use the W, A, S, or D keys. Please use the arrow keys instead.");

        timer.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Key Released!");
        pressed.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed!");


    }

}
