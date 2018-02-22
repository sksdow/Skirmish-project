package test;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;

import GameInterface.GamePanel;

public class TestFrame extends JFrame {
	
	public static void main(String[] args) {
		TestFrame m = new TestFrame();
	}
	
	public TestFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setTitle("Skirmish");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		GamePanel g = new GamePanel();
		getContentPane().add(g);
		addComponentListener(g);
		
		setVisible(true);
	}
	
}
