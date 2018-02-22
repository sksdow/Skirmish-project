package GameInterface;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import MainMenu.ParentPanel;
import Utilities.PaintButton;
import Utilities.ResizableText;
import Utilities.ResizePanel;

public class Vscreen extends ResizePanel{
	ResizableText text2;
	public Vscreen(){
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill=c.BOTH;
		JPanel fill1 = new JPanel();
		fill1.setOpaque(false);
		c.gridx=0;c.gridy=0;
		c.weightx=.35;
		c.gridheight=3;
		add(fill1,c);
		
		JPanel fill2 = new JPanel();
		fill2.setOpaque(false);
		c.gridx=2;
		add(fill2,c);
		
		JPanel fill3 = new JPanel();
		fill3.setOpaque(false);
		c.weightx=.3;
		c.gridheight=1;c.weighty=.3;
		c.gridx=1;c.gridy=0;
		add(fill3,c);
		
		JPanel fill4 = new JPanel();
		fill4.setOpaque(false);
		c.weighty=.2;
		c.gridy=2;
		add(fill4,c);
		
		JPanel VS = new JPanel();
		VS.setOpaque(false);
		ResizableText text1 = new ResizableText("Victory", Color.BLUE);
		text2 = new ResizableText("Player "+Integer.toString(1)+"'s Win", Color.BLACK);
		VS.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill=c1.BOTH;c1.weightx=1;c1.weighty=.4;
		c1.gridy=0;
		VS.add(text1, c1);
		c1.gridy=1;c1.weighty=.3;
		VS.add(text2,c1);
		c1.gridy=2;
		Image i = ResizableText.createImage("New Game", Color.WHITE, Color.DARK_GRAY);
		PaintButton ng = new PaintButton(i);
		ng.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ng.isSelected()){
					GameWrapper gw = (GameWrapper)getParent();
					ParentPanel pp = (ParentPanel) gw.getParent();
					pp.resetGame();
					pp.loadPanel(1);
					gw.loadPanel(0);
					ng.setSelected(false);
					}
			}
		});
		VS.add(ng, c1);
		
		c.gridy=1;
		c.weighty=.5;
		add(VS,c);
		
	}

	public void setPlayer(int player) {
		text2.setText("Player "+Integer.toString(player+1)+"'s Win");
		
	}

}
