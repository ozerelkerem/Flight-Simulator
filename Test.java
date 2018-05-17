import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import GUI.DiagonalLayout;
import GUI.JPanelWithBackground;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1000,1000);
		
		window.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel btnPanel = new JPanel();
		JPanelWithBackground mapPanel = new JPanelWithBackground("map.jpg");


		btnPanel.setSize(100,window.getSize().height/4);
		btnPanel.setPreferredSize(btnPanel.getSize());
		btnPanel.setLayout(new GridLayout(4, 1));
		
		JButton btnAddCity = new JButton("Þehir Ekle");
		btnAddCity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("haha");
				
			}
		});
		
		
		JButton btnAddAirport = new JButton("Hava Alaný Ekle");
		btnAddAirport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JButton btnAddAirlinesComp = new JButton("Þirket Ekle");
		btnAddAirlinesComp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JButton btnAddAircraft = new JButton("Uçak Ekle");
		btnAddAircraft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		btnPanel.add(btnAddAircraft, 0);
		btnPanel.add(btnAddAirlinesComp);
		btnPanel.add(btnAddCity);
		btnPanel.add(btnAddAirport);
		//btnPanel
		mapPanel.setSize(window.getSize().width-btnPanel.getSize().width-50,window.getSize().height);
		mapPanel.setPreferredSize(mapPanel.getSize());
	
		window.add(btnPanel);
		window.add(mapPanel);
		
		window.setVisible(true);
	}

}

