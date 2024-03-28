package main.presentation;
//
//import main.domain.components.ClickComponent;
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//import java.awt.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
public class MainTest {
//
//	@Test
//	public void testMain_testClickComponent_difficultyEasy() {
//
//		if (GraphicsEnvironment.isHeadless()) {
//			System.out.println("Running in headless mode. Skipping UI-related test.");
//			return;
//		}
//		Main main = new Main();
//		JFrame frame = new JFrame();
//		JLayeredPane layeredPane = new JLayeredPane();
//
//
//		main.startGame(frame, layeredPane, 1);
//		ClickComponent clickComponent = getClickComponent(frame);
//
//
//		assertEquals(1, clickComponent.getDifficulty());
//		assertEquals(30, clickComponent.getPlayer().getHealth());
//	}
//
//	@Test
//	public void testMain_testClickComponent_difficultyMedium() {
//
//		if (GraphicsEnvironment.isHeadless()) {
//			System.out.println("Running in headless mode. Skipping UI-related test.");
//			return;
//		}
//
//		Main main = new Main();
//		JFrame frame = new JFrame();
//		JLayeredPane layeredPane = new JLayeredPane();
//
//		// When
//		main.startGame(frame, layeredPane, 2);
//		ClickComponent clickComponent = getClickComponent(frame);
//
//		// Then
//		assertEquals(2, clickComponent.getDifficulty());
//		assertEquals(20, clickComponent.getPlayer().getHealth());
//	}
//
//	@Test
//	public void testMain_testClickComponent_difficultyHard() {
//		// Given
//		Main main = new Main();
//		JFrame frame = new JFrame();
//		JLayeredPane layeredPane = new JLayeredPane();
//
//		// When
//		main.startGame(frame, layeredPane, 3);
//		ClickComponent clickComponent = getClickComponent(frame);
//
//		// Then
//		assertEquals(3, clickComponent.getDifficulty());
//		assertEquals(10, clickComponent.getPlayer().getHealth());
//	}
//
//	// Helper method to get ClickComponent instance from the JFrame
//	private ClickComponent getClickComponent(JFrame frame) {
//		Component[] components = frame.getContentPane().getComponents();
//		for (Component component : components) {
//			if (component instanceof ClickComponent) {
//				return (ClickComponent) component;
//			}
//		}
//		return null;
//	}
}
