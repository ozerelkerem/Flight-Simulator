package GUI;

import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Lib.Center;

public class MainWindow extends JFrame
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
		pnlMap mjp = new pnlMap("map.jpg",pnlAddCountry.posX,pnlAddCountry.posY,CNTR);
	    mjp.setLocation(0, 400);
	    mjp.setBounds(0,150, 1920, 1013);
		JTabbedPane tb=new JTabbedPane();
		tb.setBounds(0, 0, 1920, 150);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
	    p1 = new pnlAddCountry(CNTR);
		p2 = new pnlAddAirPort(CNTR);
		p3 = new pnlAddPlane(CNTR);
		p4 = new pnlAddFlight(CNTR);
		tb.addTab("Þehir Ekle", p1);
	    tb.addTab("HavaLimaný Ekle", p2);
	    tb.addTab("Havalimaný Þirket Ekle", new pnlAddNewCo(CNTR));
	    tb.addTab("Þirkete Uçak Ekle", p3);
	    tb.addTab("Uçuþ Ekle", p4);
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
				Center.saveMyCenter(CNTR);
				
			}
		});;
	}
	
	

}
