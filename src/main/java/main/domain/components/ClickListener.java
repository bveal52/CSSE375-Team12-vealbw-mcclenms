package main.domain.components;

import main.datasource.MusicPlayback;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.TreeSet;

public class ClickListener implements KeyListener {

	private ClickComponent component;
	private final Set<Integer> pressed = new TreeSet<Integer>();
	//musicStuff turbolaser = new musicStuff();

	MusicPlayback turbolaser = new MusicPlayback();

	public ClickListener(ClickComponent component) {
		this.component = component;
	}
	
	

	@Override
	public void keyPressed(KeyEvent input) {
		
		int c = input.getKeyCode(); // disclaimer -> the technique used for multiple inputs at the same time is taken from https://stackoverflow.com/questions/22580933/diagonal-movement-of-a-sprite
	    pressed.add(c);

		

	    if (pressed.size() > 1) {
	        Integer[] array = pressed.toArray(new Integer[] {});
	        if (array[0] == KeyEvent.VK_SPACE  && array[1] == KeyEvent.VK_LEFT) {
	           this.component.left();
	           this.component.playerFire();

	           
	           
	        } else if (array[0] == KeyEvent.VK_SPACE && array[1] == KeyEvent.VK_RIGHT) {
	        	this.component.right();
	        	this.component.playerFire();
	        } else if (array[0] == KeyEvent.VK_SPACE && array[1] == KeyEvent.VK_UP) {
	        	this.component.up();
	        	this.component.playerFire();
	        } else if (array[0] == KeyEvent.VK_SPACE && array[1] == KeyEvent.VK_DOWN) {
	        	this.component.down();
	        	this.component.playerFire();
	        } else if (array[0] == KeyEvent.VK_LEFT && array[1] == KeyEvent.VK_UP) {
	           this.component.up();
	           this.component.left();
	        } else if (array[0] == KeyEvent.VK_UP && array[1] == KeyEvent.VK_RIGHT) {
	        	this.component.up();
	        	this.component.right();
	        } else if (array[0] == KeyEvent.VK_RIGHT && array[1] == KeyEvent.VK_DOWN) {
	        	this.component.down();
	        	this.component.right();
	        } else if (array[0] == KeyEvent.VK_LEFT && array[1] == KeyEvent.VK_DOWN) {
	        	this.component.down();
	        	this.component.left();
	        }
	    } else {
	        if (c == KeyEvent.VK_LEFT) {
	            this.component.left();
	        } else if (c == KeyEvent.VK_RIGHT) {
	        	this.component.right();
	        } else if (c == KeyEvent.VK_UP) {
	        	this.component.up();
	        } else if (c == KeyEvent.VK_DOWN) {
	        	this.component.down();
			} else if (c == KeyEvent.VK_SPACE) {
				//System.out.println("Pressed Space, Fire!");
				this.component.playerFire();
				turbolaser.play("images/turbolaser.wav", false);
			}
	    }

		System.out.println("Key Pressed!");
	    
		
		
		
		this.component.drawScreen();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Key Released!");
		pressed.remove(Integer.valueOf(e.getKeyCode()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Key Typed!");

		
	}

}
