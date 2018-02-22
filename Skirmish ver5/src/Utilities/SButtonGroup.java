package Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import MainMenu.MainPanel;
import MainMenu.ParentPanel;

public class SButtonGroup {
	ButtonGroup group;
	int c=0;
	String selected;
	public SButtonGroup(){
		group = new ButtonGroup();
	}
	
	public void addButton(JToggleButton b,String name){
		c++;
		b.setName(name);
		b.addActionListener((new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (b.isSelected()){
					selected=b.getName();
					//System.out.println(getSelected());
				}
			}
		}));
		group.add(b);
	}
	public String getSelected(){
		if(selected!=null)
			return selected;
		else
			return "None Selected";
	}

	/*public void addButton(JButton b, String name) {
		c++;
		b.setName(name);
		b.addActionListener((new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (b.isSelected()){
					selected=b.getName();
					System.out.println(getSelected());
				}
			}
		}));
		group.add(b);
	}*/

}
