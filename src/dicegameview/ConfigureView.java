package dicegameview;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


import diceService.DiceGame;

public class ConfigureView extends Frame {
	TextField celltf;
	TextField gocelltf;
	TextArea checkta;
	private Label celltx;
	private Label gocelltx;
	private HashMap<String,String> cells;
	DiceGame dicegame;
	String name;
	
	Panel p1;
	Panel p2;
	Panel p3;
	
	String str="변경된 Cell's Operation\n";
	
	public ConfigureView(String name) {
		super("Configure");
		this.name = name;
		
		Button operaddBut = new Button("추가");
		Button playBut = new Button("Play");
		Button exitBut = new Button("Exit");
		cells = new HashMap<String,String>();
		
		celltf = new TextField(4);
		gocelltf = new TextField(6);
		celltx = new Label("번째 칸");
		gocelltx = new Label("이동");
		
		checkta = new TextArea(10,50);
		checkta.setEditable(false);
		
		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		setLayout(new FlowLayout());
		
		p1.add(celltf);
		p1.add(celltx);
		p1.add(gocelltf);
		p1.add(gocelltx);
		p1.add(operaddBut);
		
		p2.add(checkta);
		
		p3.add(playBut);
		p3.add(exitBut);
		
		add(p1);
		add(p2);
		add(p3);
		
		setSize(450,300);
		setVisible(true);
		
		operaddBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String oper1 = celltf.getText();
				String oper2 = gocelltf.getText();
				if(oper2.equals("처음")) { 
					str= str + oper1 + " 번째 칸은 처음으로 이동\n";
					checkta.setText(str);
				}
				else {
				str= str + oper1 + " 번째 칸을 " + oper2 + " 칸 만큼 이동\n";
				checkta.setText(str);
				}
				
				cells.put(oper1,oper2);
			}
		});
		
		exitBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		playBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dicegame ==null) dicegame = new DiceGame(cells);
				new DiceView(name,dicegame);
				setVisible(false);
				dispose();
				
			}
		});
		
		
	}

}
