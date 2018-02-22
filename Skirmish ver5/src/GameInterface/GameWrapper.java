package GameInterface;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Utilities.SwapPanel;

public class GameWrapper extends SwapPanel{
	
	public GameWrapper(JPanel game, JPanel victory){
		addPanel(game, 0);
		addPanel(victory, 1);
		setBackground(Color.BLACK);
		loadPanel(0);
	}
	
}
