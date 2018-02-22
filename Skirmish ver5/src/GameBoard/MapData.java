package GameBoard;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Units.*;

public class MapData {
	
	public static final int OBSTACLE = 16;
	
	public HashMap<Coordinate, Integer> map = new HashMap<Coordinate, Integer>();
	public HashMap<Coordinate, GObject> unitdata = new HashMap<Coordinate, GObject>();
	private int width;
	private int height;
	public MapData() {
		
	}
	
	public void loadMap(String mapFileName) {
		try {
			
			File f = new File(mapFileName);
			Scanner s = new Scanner(f);
			
			width = s.nextInt();
			height = s.nextInt();
			Coordinate temp1;GObject temp2;int temp3;
			for (int j = 0; j < height; j++) {
				for (int i = 0; i < width; i++) {
					temp1 =new Coordinate(i, j);
					temp3 = s.nextInt();
						map.put(temp1, temp3);
						unitdata.put(temp1, null);
					
				}
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
			
	}
	
	public boolean isVacant(Coordinate c) {
		Integer d = map.get(c);
		if (d == null)
			return false;
		else if ((d & OBSTACLE) == OBSTACLE)
			return false;
		else if(unitdata.get(c)!=null)
			return false;
		return true;
	}
	
	public int getData(Coordinate c) {
		Integer i = map.get(c)&0xF;
		if (i == null) {
			return -1;
		}
		return i;
	}
	
	public int getSpawnPoint(Coordinate c){
		Integer i = (map.get(c)&0xF00)>>8;
		if(i==null){
			return -1;
		}
		return i;
	}
	
	public void move(Coordinate start, Coordinate end){
		GObject temp3=unitdata.get(start);
		GObject temp4=unitdata.get(end);
		unitdata.put(start, temp4);
		unitdata.put(end, temp3);
	}
	
	public boolean spawn(Coordinate c,GObject u, int player){
		int temp=player+1;
		if(getSpawnPoint(c)==temp&&getUnitData(c)==null){
			unitdata.put(c, u);
			return true;
		}
		return false;
	}
	
	public boolean kill(Coordinate c){
		if(getUnitData(c)!=null){
			unitdata.remove(c);
			return true;
		}
		return false;
	}
	
	public int attack(Coordinate source, Coordinate target){
		if(getUnitData(source)==null||getUnitData(target)==null){
			return 0;
		}
		GObject attack=getUnitData(source);
		GObject defend=getUnitData(target);
		
		int ar=attack.getRange(); 
		int dr=defend.getRange();
		
		int x=Math.abs(source.getX()-target.getX());
		int y=Math.abs(source.getY()-target.getY());
		
		int temp=(int) Math.round(Math.sqrt(Math.pow(x,2)+Math.pow(y, 2)));
		if(temp<=ar&&temp<=dr&&defend!=null){
			return 2;
		}
		else if(temp<=ar&&defend!=null){
			return 1;
		}
		else
			return 0;
	}
	
	public GObject getUnitData(Coordinate c){
		return unitdata.get(c);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}