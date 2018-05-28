package GUI;

import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.*;
import java.security.Key;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import Lib.*;

public class MainWindow extends JFrame
{
	private pnlMap mjp;
	private JTabbedPane tb;
	private pnlAddCountry p1;
	private pnlAddAirPort p2;
	private pnlAddPlane p3;
	private pnlAddFlight p4;
	private pnlUpdateFlight p5;
	private pnlDeleteCity p6;
	
	public pnlMap getMjp() {
		return mjp;
	}



	public MainWindow(Center CNTR) throws IOException
	{
		setTitle(CNTR.getTimeNOW().toString());
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
		p5 = new pnlUpdateFlight(CNTR);
		p4 = new pnlAddFlight(CNTR);
		p6=new pnlDeleteCity(CNTR);
		tb.addTab("Þehir Ekle", p1);
	    tb.addTab("HavaLimaný Ekle", p2);
	    tb.addTab("Havalimaný Þirket Ekle", new pnlAddNewCo(CNTR));
	    tb.addTab("Þirkete Uçak Ekle", p3);
	    tb.addTab("Uçuþ Ekle", p4);
	    tb.addTab("Raporlar",null);
	    tb.addTab("Uçuþ Düzenle", p5);
	    tb.addTab("Þehir Sil",p6);

	    tb.addTab("Sistem Saati Güncelle",new pnlChangeSystemDateTime(CNTR));

	    /**/
	    JMenuBar menuBar=new JMenuBar();
        JMenuItem start=new JMenuItem("Simülasyon Baþlat");
        JMenuItem stop=new JMenuItem("Simülasyon Durdur");
        start.setBackground(Color.GREEN);
        stop.setBackground(Color.RED);
        start.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	CNTR.startSimulation();
            	JOptionPane.showMessageDialog(null, "Simülasyon baþlatýldý.");
            
            }
            
        });
        stop.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	CNTR.stopSimulation();
            	JOptionPane.showMessageDialog(null, "Simülasyon durduldu.");
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
	    tb.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				p2.update();
			//	p1.update();
				p3.update();
				p4.update();
				p5.update();
				p6.update();
				Center.saveMyCenter(CNTR);
				if(tb.getSelectedIndex()==5) {
                    pnlFlightReport p=new pnlFlightReport(CNTR);
                    tb.setSelectedIndex(0);
                
				}
			}
		});
	   Helper.setShortcutListener(this, new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() ==KeyEvent.VK_F2)
			{
				mjp.drawCities(mjp.getGraphics());
			}
			
			else if(e.getKeyCode() ==KeyEvent.VK_F3)
			{
				Center.saveMyCenter(CNTR);
			}
			
		}
	});
	}



	
	
	

}
