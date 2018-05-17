package GUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AbstractDocument.Content;

public class Main {

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame ("Panel");
		frame.getContentPane().setLayout(null);
		JPanelWithBackground mjp = new JPanelWithBackground("map.jpg");
	

        mjp.setLocation(0, 400);
        mjp.setBounds(0,200, 1920, 800);
        
		JTabbedPane tb=new JTabbedPane();
		tb.setBounds(0, 0, 1920, 200);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        tb.addTab("Þehir Ekle", new pnlAddCountry());
        tb.addTab("HavaLimaný Ekle", new pnlAddAirPort());
        frame.getContentPane().add(tb);
        frame.getContentPane().add(mjp);
        
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible (true);
        tb.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				
			}
		});;
		
		

	}

}
