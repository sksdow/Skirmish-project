package GameBoard;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import GameInterface.*;
import Scrollpanel.UnitScroll;
import Units.*;
import Utilities.ResizePanel;

public class MapPanel extends ResizePanel {
	
	private GridBagConstraints c;
	private MapData m;
	private HashMap<Coordinate, MapBlockLabel> blocks;
	private Coordinate start=null;
	private Coordinate destination=null;
	private Boolean moving=false;
	private int player;
	
	private PathFinder PF;
	private DataInterface DI;
	
	public MapPanel() {
		super(1,1);
		
		c = new GridBagConstraints();
		c.fill = c.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		
		m = new MapData();
		
		setBackground(Color.BLACK);
		setLayout(new GridBagLayout());
	}
	
	public MapPanel(String mapFileName) {
		this();
		
		m.loadMap(mapFileName);
		
		fillBlockMap();
		changeAspectRatio(m.getWidth(), m.getHeight());
	}
	
	public void updateDI(DataInterface d){
		DI=d;
	}
	
	public MapData getMap(){
		return m;
	}

	
	private void fillBlockMap() {
		if (blocks != null)
			return;
		blocks = new HashMap<Coordinate, MapBlockLabel>();
		
		for (int j = 0; j < m.getHeight(); j++) {
			for (int i = 0; i < m.getWidth(); i++) {
				Coordinate coor = new Coordinate(i,j);
				MapBlockLabel mbl = new MapBlockLabel(m.getData(coor), coor,m.getUnitData(coor));
				//System.out.println(m.getUnitData(coor));
				c.gridx = i;
				c.gridy = j;
			
				add(mbl, c);
				blocks.put(coor, mbl);
			}
		}
		
		revalidate();
		repaint();
	}
	
	public void highlight(ArrayList<Coordinate> list, boolean f) {
		if (blocks == null || list == null)
			return;
		for (Coordinate coor : list) {
			MapBlockLabel mbl = blocks.get(coor);
			if (mbl != null) {
				if (f)
					mbl.setHighlight(Color.GRAY, f);
				else
					mbl.setHighlight(Color.RED, f);
			}
		}
		repaint();
	}
	
	public void clearHighlights() {
		if (blocks == null)
			return;
		for (int j = 0; j < m.getHeight(); j++) {
			for (int i = 0; i < m.getWidth(); i++) {
				MapBlockLabel mbl = blocks.get(new Coordinate(i, j));
				mbl.setHighlight(null,false);
			}
		}
		repaint();
	}
	
	public void leftClick(Coordinate coor) {
		//System.out.println("Left Clicked: " + m.getData(coor)+ " "+m.getUnitData(coor));
		//check phases
		if(DI.getPhase()==0){
			player=0;
			spawnleftclick(coor);
		}
		else if(DI.getPhase()==1){
			player=1;
			spawnleftclick(coor);}
		
		else if(DI.getPhase()==2){
			player=0;
			moveleftclick(coor);
		}
		else if(DI.getPhase()==3){
			player=1;
			moveleftclick(coor);
		}
		else if(DI.getPhase()==4){
			player=0;
			attackleftclick(coor);
		}
		else if(DI.getPhase()==5){
			player=1;
			attackleftclick(coor);
		}
	}
	
	public void rightClick(Coordinate coor) {
		//System.out.println("Right Clicked: " + coor.getX() + ", " + coor.getY() + ")");
		if(DI.getPhase()==0){
			player=0;
			spawnrightclick(coor);
		}
		else if(DI.getPhase()==1){
			player=1;
			spawnrightclick(coor);
		}
		else if(DI.getPhase()==2||DI.getPhase()==3){
			moverightclick(coor);
		}
		else if(DI.getPhase()==4||DI.getPhase()==5){
			attackrightclick(coor);
		}
	}
	
	

	public boolean setSearchCoordinate(Coordinate coor, Boolean f) {
		if (start == null || coor == null || blocks == null || DI.getPhase()==4|| DI.getPhase()==5)
			return false;
		PathFinder pf = new PathFinder(m);
		ArrayList<Coordinate> path = pf.findPath(start, coor,DI.getTempUnit().getMoveCost(),DI.getTempNrg());
		if(f){
			clearHighlights();
			
			highlight(path,false);}
		if(path!=null&&f==false){
			destination=coor;
			PF=pf;
			return true;}
		PF=null;
		return false;
	}
	
	private void spawnleftclick(Coordinate coor){
		GObject u=DI.getTempUnit();
		u.setTeam(player);
		if(u.getName().equals("Base")||u.getName().equals("Camp")){
			Coordinate coor1=coor,coor2,coor3,coor4;
			boolean block1,block2,block3,block4;
			block1=m.spawn(coor1, ((Building) u).getPiece(0), player);
			//System.out.println("Block 1: " + block1);
			coor2=new Coordinate(coor.getX()+1, coor.getY());
			block2=m.spawn(coor2, ((Building) u).getPiece(1), player);
			//System.out.println("Block 2: " + block2);
			coor3=new Coordinate(coor.getX(), coor.getY()+1);
			block3=m.spawn(coor3, ((Building) u).getPiece(2), player);
			//System.out.println("Block 3: " + block3);
			coor4=new Coordinate(coor.getX()+1, coor.getY()+1);
			block4=m.spawn(coor4, ((Building) u).getPiece(3), player);
			//System.out.println("Block 4: " + block4);
			if(block1==true&&block2==true&&block3==true&&block4==true){
				//System.out.println("yes");
				Building building = (Building) u;
				blocks.get(coor1).upDateUnit(m.getUnitData(coor1));
				blocks.get(coor2).upDateUnit(m.getUnitData(coor2));
				blocks.get(coor3).upDateUnit(m.getUnitData(coor3));
				blocks.get(coor4).upDateUnit(m.getUnitData(coor4));
				boolean temp=false;
				if(building.getName().equals("Camp")){
					if(DI.Bbutton2!=null){
						if(DI.Bbutton2.isVisible()){
							DI.Bbutton2.setVisible(false);
							temp=true;
						}
					}
					if(DI.Bbutton1!=null&&temp==false){
						if(DI.Bbutton1.isVisible())
							DI.Bbutton1.setVisible(false);
					}
				}
				else
					DI.Bbutton3.setVisible(false);
				
				/*if(u.getbuilding()==0){
					DI.Bbutton1.setVisible(false);
				}
				else if(u.getbuilding()==1){
					DI.Bbutton2.setVisible(false);
				}
				else{
					DI.Bbutton3.setVisible(false);
				}*/
				DI.setTempUnit(DI.temp);
				if(u.getName().equals("Camp")){
					if(player==0)
						DI.setPlayer1Nrg(DI.getPlayer1Nrg()+20);
					else
						DI.setPlayer2Nrg(DI.getPlayer2Nrg()+20);
				}
				}
			else {
				if(block1==true)
					m.kill(coor1);
				if(block2==true)
					m.kill(coor2);
				if(block3==true)
					m.kill(coor3);
				if(block4==true)
					m.kill(coor4);
			}
			repaint();
			revalidate();
			
			
		}
		else if(u.getPopulationCost()<=DI.getTempPop()){
			if(m.spawn(coor, u, player)){
				blocks.get(coor).upDateUnit(u);
				DI.updateUnitInfo(u);
				repaint();
				revalidate();
				DI.setTempPop(DI.getTempPop()-u.getPopulationCost());
				DI.updateSpawnPop(DI.getTempPop());
			}
		}
		
	}
	
	private void spawnrightclick(Coordinate coor){
		GObject u=m.getUnitData(coor);
		if(u != null){
		if(u.getTeam()==player){
			if(u.getName().equals("Base")||u.getName().equals("Camp")){
				
				Building building = ((BuildingPiece) u).getParent();
				BuildingPiece piece = (BuildingPiece) u;
				if (piece.getId()==1)
					coor=new Coordinate(coor.getX()-1,coor.getY());
				else if(piece.getId()==2)
					coor=new Coordinate(coor.getX(),coor.getY()-1);
				else if(piece.getId()==3)
					coor=new Coordinate(coor.getX()-1,coor.getY()-1);

				Coordinate coor1=coor,coor2,coor3,coor4;
				coor2=new Coordinate(coor1.getX()+1, coor1.getY());
				coor3=new Coordinate(coor1.getX(), coor1.getY()+1);
				coor4=new Coordinate(coor1.getX()+1, coor1.getY()+1);
				m.kill(coor1);m.kill(coor2);m.kill(coor3);m.kill(coor4);
				
				blocks.get(coor1).upDateUnit(m.getUnitData(coor1));
				blocks.get(coor2).upDateUnit(m.getUnitData(coor2));
				blocks.get(coor3).upDateUnit(m.getUnitData(coor3));
				blocks.get(coor4).upDateUnit(m.getUnitData(coor4));
				boolean temp=false;
				
				if(building.getName().equals("Camp")){
					if(DI.Bbutton2!=null){
						if(DI.Bbutton2.isVisible()==false){
							DI.Bbutton2.setVisible(true);
							temp=true;
						}
					}
					if(DI.Bbutton1!=null&&temp==false){
						if(DI.Bbutton1.isVisible()==false)
							DI.Bbutton1.setVisible(true);
					}
				}
				else{
					DI.Bbutton3.setVisible(true);
				}
				
				/*if(building.getbuilding()==0){
					DI.Bbutton1.setVisible(true);
				}
				else if(building.getbuilding()==1){
					DI.Bbutton2.setVisible(true);
				}
				else{
					DI.Bbutton3.setVisible(true);
				}*/
				if(u.getName().equals("Camp")){
					if(player==0)
						DI.setPlayer1Nrg(DI.getPlayer1Nrg()-20);
					else
						DI.setPlayer2Nrg(DI.getPlayer2Nrg()-20);
				}
				
			}
			else{
				m.kill(coor);
				blocks.get(coor).upDateUnit(null);
				DI.setTempPop(DI.getTempPop()+u.getPopulationCost());
				DI.updateSpawnPop(DI.getTempPop());
			}
			repaint();
			revalidate();
		}
		}
		
	}
	
	private void moverightclick(Coordinate coor) {
		GObject u=m.getUnitData(coor);
		if(u!=null){
			DI.updateUnitInfo(u);
		}
		
	}
	
	private void moveleftclick(Coordinate coor){
		if(moving==false){
			GObject u=m.getUnitData(coor);
			//check team,unit flag
			if(u!=null&&u.getTeam()==player){
				//System.out.println(temp2);
				start = coor;
				moving=true;
				DI.setTempUnit(u);
				DI.updateUnitInfo(u);
			}
		} else{
			if(setSearchCoordinate(coor,false)&&start!=coor){
				//System.out.println("yes");
				m.move(start, destination);
				DI.setTempNrg(DI.getTempNrg()-DI.getTempUnit().getMoveCost()*PF.getDistanceTraveled());
				DI.updatePlayerNrg(DI.getTempNrg());
				blocks.get(start).upDateUnit(m.getUnitData(start));
				blocks.get(destination).upDateUnit(m.getUnitData(destination));
			}
			moving=false;
			start=null;
			repaint();
			revalidate();
			clearHighlights();
		}
	}
	
	private void attackleftclick(Coordinate coor){
		if(moving==false){
			GObject u=m.getUnitData(coor);
			if(u!=null&&u.getTeam()==player){
				start = coor;
				moving=true;
				DI.setTempUnit(u);
				DI.updateUnitInfo(u);
			}
			if(u!=null){
				highLightRange(u,coor);
			}
		} else{
			int result=m.attack(start, coor);
			GObject att=DI.getTempUnit();
			GObject def = m.getUnitData(coor);
			if(def!=null&&def.getTeam()!=player){
				int attdmg = att.getAttack();
				int defdmg = def.getDefense();
				if(result == 2){
					att.takeDamage(defdmg);def.takeDamage(attdmg);
					int atthp = att.getRemainingHP();
					int defhp = def.getRemainingHP();
					if(atthp<=0){
						m.kill(start);
						blocks.get(start).upDateUnit(null);
						DI.updateUnitInfo(att);
					}
					if(defhp<=0){
						m.kill(coor);
						blocks.get(coor).upDateUnit(null);
					}
					if(atthp>0){
						m.unitdata.put(start, att);
						blocks.get(start).upDateUnit(att);
						DI.updateUnitInfo(att);
					}
					if(defhp>0){
						m.unitdata.put(coor, def);
						blocks.get(coor).upDateUnit(def);
					}
					DI.setTempNrg(DI.getTempNrg()-1);
					DI.updatePlayerNrg(DI.getTempNrg());
				}
				else if(result == 1){
					def.takeDamage(attdmg);
					int defhp = def.getRemainingHP();
					if(defhp<=0){
						if(def.getName().equals("Base")){
							DI.setVictory(player);
						}
						else if(def.getName().equals("Camp")){
							if(player==1)
								DI.setPlayer1Nrg(DI.getPlayer1Nrg()-20);
							else
								DI.setPlayer2Nrg(DI.getPlayer2Nrg()-20);
							Building building = ((BuildingPiece) def).getParent();
							BuildingPiece piece = (BuildingPiece) def;
							if (piece.getId()==1)
								coor=new Coordinate(coor.getX()-1,coor.getY());
							else if(piece.getId()==2)
								coor=new Coordinate(coor.getX(),coor.getY()-1);
							else if(piece.getId()==3)
								coor=new Coordinate(coor.getX()-1,coor.getY()-1);

							Coordinate coor1=coor,coor2,coor3,coor4;
							coor2=new Coordinate(coor1.getX()+1, coor1.getY());
							coor3=new Coordinate(coor1.getX(), coor1.getY()+1);
							coor4=new Coordinate(coor1.getX()+1, coor1.getY()+1);
							m.kill(coor1);m.kill(coor2);m.kill(coor3);m.kill(coor4);
							
							blocks.get(coor1).upDateUnit(m.getUnitData(coor1));
							blocks.get(coor2).upDateUnit(m.getUnitData(coor2));
							blocks.get(coor3).upDateUnit(m.getUnitData(coor3));
							blocks.get(coor4).upDateUnit(m.getUnitData(coor4));
							
						}
						m.kill(coor);
						blocks.get(coor).upDateUnit(null);
					}
					if(defhp>0){
						m.unitdata.put(coor, def);
						blocks.get(coor).upDateUnit(def);
					}
					DI.setTempNrg(DI.getTempNrg()-1);
					DI.updatePlayerNrg(DI.getTempNrg());
				}
				else 
					System.out.println("out of range");
			}
			moving=false;
			start=null;
			repaint();
			revalidate();
			clearHighlights();
		}
	}
	
	private void attackrightclick(Coordinate start){
		GObject attack=m.getUnitData(start);
		if(attack!=null){
			highLightRange(attack, start);
		}
	}
	
	public void resetMove(){
		moving=false;
		start=null;
		repaint();
		revalidate();
		clearHighlights();
	}
	
	private void highLightRange(GObject target, Coordinate location){
		DI.updateUnitInfo(target);
		clearHighlights();
		ArrayList<Coordinate> range=new ArrayList<Coordinate>();
		for (int j = 0; j < m.getHeight(); j++) {
			for (int i = 0; i < m.getWidth(); i++) {
				Coordinate HL = new Coordinate(i,j);
				int x=Math.abs(location.getX()-HL.getX());
				int y=Math.abs(location.getY()-HL.getY());
				if((int) Math.round(Math.sqrt(Math.pow(x,2)+Math.pow(y, 2)))<=target.getRange()){
					range.add(HL);
				}
			
			}
		}
		highlight(range,false);
	}
}
