package GameInterface;

import java.util.ArrayList;

import javax.swing.JToggleButton;

import GameBoard.Coordinate;
import GameBoard.MapBlockLabel;
import GameBoard.MapData;
import GameBoard.MapPanel;
import SidePanel.SidePanel;
import Units.*;

public class DataInterface {
	private int phase=0;
	//default unit is archer
	private GObject unit=new Archer(0);
	public GObject temp=null;
	public Building building;
	public JToggleButton Bbutton1=null,Bbutton2=null,Bbutton3=null;
	private int player1pop=30;
	private int player2pop=30;
	private int tempPop;
	private int player1Mnrg=30;
	private int player2Mnrg=30;
	private int tempNrg;
	public SidePanel SP;
	public MapPanel MP;
	public GameWrapper GW;
	public Vscreen VS;
	
	public void setPhase(int p){
		phase=p;
	}
	public int getPhase(){
		return phase;
	}
	
	public void setVictory(int player){
		VS.setPlayer(player);
		GW.loadPanel(1);
	}
	
	
	public void updatePlayerPop(int i){
		SP.getUnitSelection().getResource().setPOP(i);
	}
	
	public void updatePlayerNrg(int i){
		SP.getUnitSelection().getResource().setNRG(i);
	}
	
	public void resetMove(){
		MP.resetMove();
	}
	
	public void spawnHighlight(){
		MapData m=MP.getMap();
		ArrayList<Coordinate> fog=new ArrayList<Coordinate>();
		int temp=phase+1;
		for (int j = 0; j < m.getHeight(); j++) {
			for (int i = 0; i < m.getWidth(); i++) {
				Coordinate coor = new Coordinate(i,j);
				if(m.getSpawnPoint(coor)!=temp)
					fog.add(coor);
			}
		}
		MP.highlight(fog,true);
	}
	
	public void clearSpawnHighLight(){
		MP.clearHighlights();
	}
	
	public void updateUnitInfo(GObject u){
		SP.getUnitSelection().upDateUnit(u);
	}
	
	public void setTempPop(int i){
		tempPop=i;
	}
	
	public int getTempPop(){
		return tempPop;
	}
	
	public void setPlayer1Pop(int i){
		player1pop=i;
	}
	
	public int getPlayer1Pop(){
		return player1pop;
	}
	
	public void setPlayer2Pop(int i){
		player2pop=i;
	}
	
	public int getPlayer2Pop(){
		return player2pop;
	}
	
	public void setTempNrg(int i){
		tempNrg=i;
	}
	
	public int getTempNrg(){
		return tempNrg;
	}
	
	public void setPlayer1Nrg(int i){
		player1Mnrg=i;
	}
	
	public int getPlayer1Nrg(){
		return player1Mnrg;
	}
	
	public void setPlayer2Nrg(int i){
		player2Mnrg=i;
	}
	
	public int getPlayer2Nrg(){
		return player2Mnrg;
	}
	
	public void updateSpawnPop(int i){
		SP.getUnitSpawning().updatePop(i);
	}
	
	
	public void setTempUnit(GObject u){
		unit=u;
	}
	
	public GObject getTempUnit(){
		return unit;
	}

}
