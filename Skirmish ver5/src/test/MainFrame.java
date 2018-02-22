package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {
	
	private ButtonGroup b;
	private WeirdButton w;
	private WeirdButton w2;
	
	public static void main(String[] args) {
		MainFrame m = new MainFrame();
	}
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setTitle("Skirmish");
		getContentPane().setLayout(new FlowLayout());
		
		b = new ButtonGroup();
		w = new WeirdButton(Color.BLUE);
		w2 = new WeirdButton(Color.GREEN);
		
		// Make buttons print out states again when clicked.
		w.addActionListener(this);
		w2.addActionListener(this);
		
		// Adds buttons to button group.
		b.add(w);
		b.add(w2);
		
		// Adds buttons to the content pane.
		getContentPane().add(w);
		getContentPane().add(w2);
		
		setVisible(true);
	}
	
	// Crude code to get selected status. For testing only.
	public void actionPerformed(ActionEvent e) {
		System.out.println("\nButton 1: " + b.isSelected(w.getModel()));
		System.out.println("Button 2: " + b.isSelected(w2.getModel()));
		revalidate();
	}
	
}