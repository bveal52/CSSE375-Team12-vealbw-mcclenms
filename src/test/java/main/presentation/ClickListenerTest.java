package main.presentation;

import java.awt.event.KeyEvent;

import main.domain.components.ClickComponent;
import main.presentation.ClickListener;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;


import static org.easymock.EasyMock.*;

public class ClickListenerTest {

	private ClickListener clickListener;
	private ClickComponent mockClickComponent;



	@BeforeEach
	public void setUp() {
		// Create mock ClickComponent
		mockClickComponent = createMock(ClickComponent.class);

		// Create ClickListener instance with mock ClickComponent
		clickListener = new ClickListener(mockClickComponent);
	}

	@AfterEach
	public void tearDown() {
		reset(mockClickComponent);
	}

	@Test
	public void testKeyPressed_LeftArrow() {
		mockClickComponent.left();
		mockClickComponent.drawScreen();

		replay(mockClickComponent);

		KeyEvent keyEvent = createMock(KeyEvent.class);
		expect(keyEvent.getKeyCode()).andReturn(KeyEvent.VK_LEFT);
		replay(keyEvent);

		clickListener.keyPressed(keyEvent);

		verify(mockClickComponent);

	}

	@Test
	public void testKeyPressed_RightArrow() {
		mockClickComponent.right();
		mockClickComponent.drawScreen();

		replay(mockClickComponent);

		KeyEvent keyEvent = createMock(KeyEvent.class);
		expect(keyEvent.getKeyCode()).andReturn(KeyEvent.VK_RIGHT);
		replay(keyEvent);

		clickListener.keyPressed(keyEvent);

		verify(mockClickComponent);

	}

	@Test
	public void testKeyPressed_UpArrow() {
		mockClickComponent.up();
		mockClickComponent.drawScreen();

		replay(mockClickComponent);

		KeyEvent keyEvent = createMock(KeyEvent.class);
		expect(keyEvent.getKeyCode()).andReturn(KeyEvent.VK_UP);
		replay(keyEvent);

		clickListener.keyPressed(keyEvent);

		verify(mockClickComponent);

	}

	@Test
	public void testKeyPressed_DownArrow() {
		mockClickComponent.down();
		mockClickComponent.drawScreen();

		replay(mockClickComponent);

		KeyEvent keyEvent = createMock(KeyEvent.class);
		expect(keyEvent.getKeyCode()).andReturn(KeyEvent.VK_DOWN);
		replay(keyEvent);

		clickListener.keyPressed(keyEvent);

		verify(mockClickComponent);

	}

	@Test
	public void testKeyPressed_Space() {
		mockClickComponent.playerFire();
		mockClickComponent.drawScreen();

		replay(mockClickComponent);

		KeyEvent keyEvent = createMock(KeyEvent.class);
		expect(keyEvent.getKeyCode()).andReturn(KeyEvent.VK_SPACE);
		replay(keyEvent);

		clickListener.keyPressed(keyEvent);

		verify(mockClickComponent);

	}


}
