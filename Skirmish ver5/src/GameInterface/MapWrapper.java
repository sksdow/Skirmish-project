package GameInterface;

import java.awt.Color;
import javax.swing.JPanel;

import GameBoard.MapPanel;

public class MapWrapper extends JPanel {
	
	private MapPanel view;
	public MapWrapper() {
		view = new MapPanel("src/GameBoard/map.txt");
		setBackground(Color.BLACK);
		
		
		setLayout(null);
		
		add(view);
		addComponentListener(view);
	}
	
	public MapPanel getMapPanel(){
		return view;
	}
	
}
