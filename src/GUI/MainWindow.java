package GUI;

import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import Lib.*;

public class MainWindow extends JFrame implements KeyListener
{
	private pnlMap mjp;
	private JTabbedPane tb;
	private pnlAddCountry p1;
	private pnlAddAirPort p2;
	private pnlAddPlane p3;
	private pnlAddFlight p4;
	
	
	
	public pnlMap getMjp() {
		return mjp;
	}



	public MainWindow(Center CNTR) throws IOException
	{
		getContentPane().setLayout(null);
		mjp = new pnlMap("map.jpg",pnlAddCountry.posX,pnlAddCountry.posY,CNTR);
	    mjp.setLocation(0, 400);
	    mjp.setBounds(0,150, 1920, 1013);
		JTabbedPane tb=new JTabbedPane();
		tb.setBounds(0, 0, 1920, 150);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
	    p1 = new pnlAddCountry(CNTR);
		p2 = new pnlAddAirPort(CNTR);
		p3 = new pnlAddPlane(CNTR);
		p4 = new pnlAddFlight(CNTR);
		tb.addTab("�ehir Ekle", p1);
	    tb.addTab("HavaLiman� Ekle", p2);
	    tb.addTab("Havaliman� �irket Ekle", new pnlAddNewCo(CNTR));
	    tb.addTab("�irkete U�ak Ekle", p3);
	    tb.addTab("U�u� Ekle", p4);
	    tb.addTab("Raporlar",null);
	    /**/
	    JMenuBar menuBar=new JMenuBar();
        JMenuItem start=new JMenuItem("Sim�lasyon Ba�lat");
        JMenuItem stop=new JMenuItem("Sim�lasyon Durdur");
        start.setBackground(Color.GREEN);
        stop.setBackground(Color.RED);
        start.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	CNTR.startSimulation();
            	JOptionPane.showMessageDialog(null, "Sim�lasyon ba�lat�ld�.");
            
            }
            
        });
        stop.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	CNTR.stopSimulation();
            	JOptionPane.showMessageDialog(null, "Sim�lasyon durduldu.");
            }
        });
        menuBar.add(start);
        menuBar.add(stop);
        setJMenuBar(menuBar);
	    
	    /**/
	    getContentPane().add(tb);
	    getContentPane().add(mjp);
	    pack();
	    setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    setVisible (true);
	    System.out.println(getBounds() + "ehere");
	    tb.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				p2.update();
			//	p1.update();
				p3.update();
				p4.update();
				Center.saveMyCenter(CNTR);
				if(tb.getSelectedIndex()==5) {
                    pnlFlightReport p=new pnlFlightReport(CNTR);
                    tb.setSelectedIndex(0);
                
				}
			}
		});
	   
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "deneme");
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "deneme2");
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "deneme3");
	}
	
	

}
