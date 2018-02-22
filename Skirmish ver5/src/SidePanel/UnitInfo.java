package SidePanel;
import java.awt.*;
import javax.swing.*;
import MainMenu.MainPanel;
import Units.*;
import Utilities.*;

public class UnitInfo extends JPanel {
	private GridBagConstraints c1;
	ImageContainer icon;
	GObject displayed;
	//static JFrame mainframe;
	
	public UnitInfo(GObject u){
		if(u.getName().equals("Base")||u.getName().equals("Camp")){
			BuildingPiece temp = (BuildingPiece)u;
			u=temp.getParent();
		}
		setBackground(Color.black);
		setLayout(new GridBagLayout());
		c1 = new GridBagConstraints();
		displayed=u;
		
		c1.fill=c1.BOTH;
		c1.weightx=.4;c1.weighty=1;
		c1.gridx=0;c1.gridy=1;
		c1.gridheight=3;
		
		Image img=(u.getIcon().getImage());
		icon = new ImageContainer(img,u);
		c1.insets=new Insets(10,5,10,0);
		add(icon,c1);
		c1.insets=new Insets(0,0,0,0);
		
		c1.weightx=.3;
		c1.gridheight=1;
		c1.gridy=0;
		ResizableText name = new ResizableText(u.getName(),Color.WHITE);
		add(name,c1);
		
		c1.gridy=4;
		ResizableText HP = new ResizableText("HP : "+Integer.toString(u.getRemainingHP())+"/"+Integer.toString(u.getMaxHP()),Color.red);
		add(HP,c1);
		
		c1.gridx=1;c1.gridy=1;
		ResizableText ATK = new ResizableText("ATK : "+Integer.toString(u.getAttack()),Color.red);
		add(ATK,c1);

		c1.gridy=2;
		ResizableText DEF = new ResizableText("DEF : "+Integer.toString(u.getDefense()),Color.red);
		add(DEF,c1);

		c1.gridy=3;
		ResizableText M;
		if(u.getName().equals("Base")||u.getName().equals("Camp")){
			M = new ResizableText("NO MOVE",Color.red);
		}
		else{
			M = new ResizableText("MOVE : "+Integer.toString(u.getMoveCost()),Color.red);
		}
		add(M,c1);
		
		c1.gridx=2;c1.gridy=1;
		ResizableText P = new ResizableText("POP : "+Integer.toString(u.getPopulationCost()),Color.red);
		add(P,c1);
		
		c1.gridy=2;
		ResizableText R = new ResizableText("RNG : "+Integer.toString(u.getRange()),Color.red);
		add(R,c1);
		setVisible(true);
	}
	
	
	public String getUnit(){
		return displayed.getName();
	}
	
	/*public static void main(String[] args){
		mainframe = new JFrame();
		mainframe.setTitle("UnitInfo");
		mainframe.setSize(494+20,238+48);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Units u = new Apprentice();
		UnitInfo info =new UnitInfo(u);
		mainframe.add(info);
		mainframe.setVisible(true);
	}*/
}
