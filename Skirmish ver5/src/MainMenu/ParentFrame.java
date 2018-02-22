package MainMenu;

import java.awt.*;
import javax.swing.*;
public class ParentFrame extends JFrame{
	
	static ParentFrame m;
	static ParentPanel panel;
		public ParentFrame(){
			setTitle("title");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new ParentPanel();
			setContentPane(panel);
			setVisible(true);
			//setResizable(false);
		}
		
	public static void main(String[] args){
		m = new ParentFrame();
		panel.resize(800,600);
		}
}
