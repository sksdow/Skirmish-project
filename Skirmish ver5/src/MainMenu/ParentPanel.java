package MainMenu;

import java.awt.*;
import java.awt.event.ComponentListener;
import javax.swing.*;
import GameInterface.GamePanel;
import GameInterface.GameWrapper;
import GameInterface.Vscreen;
import Utilities.*;

public class ParentPanel extends SwapPanel{
	private GamePanel game;
	private Vscreen victory;
	public GameWrapper gw;
	public ParentPanel(){
		this.setBackground(Color.black);
		setLayout(null);
		MainPanel main = new MainPanel();
		addPanel(main,0);
		game = new GamePanel();
		victory = new Vscreen();
		game.DI.VS=victory;
		gw = new GameWrapper(game,victory);
		game.DI.GW=gw;
		addPanel(gw,1);
		loadPanel(0);
	}
	
	public void resetGame(){
		gw.removePanel(0);
		game = new GamePanel();
		game.DI.VS=victory;
		game.DI.GW=gw;
		gw.addPanel(game, 0);
	}
	
	public void resize(int w,int h){
		JFrame f4 = (JFrame) SwingUtilities.getRoot(this);
		f4.setSize(w,h);
	}
}
