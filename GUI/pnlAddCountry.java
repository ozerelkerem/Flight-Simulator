package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class pnlAddCountry extends JPanel{

	private JButton btnSave;
    private JLabel lblCountryName;
    private JTextField txtCountry;
    private JLabel lblPos;
    private JTextField posX;
    private JTextField posY;
    public pnlAddCountry() {
        btnSave = new JButton ("Kaydet");
        lblCountryName = new JLabel ("Þehir Adý:");
        txtCountry = new JTextField (5);
        lblPos = new JLabel ("Koordinat(Harita Üzerinden Seçim Yapýn):");
        posX = new JTextField (5);
        posY = new JTextField (5);

        btnSave.setEnabled(false);
        posX.setEditable(false);
        posY.setEditable(false);
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);
        add(btnSave);
        add(lblCountryName);
        add(txtCountry);
        add(lblPos);
        add(posX);
        add(posY);

        btnSave.setBounds (245, 100, 100, 20);
        lblCountryName.setBounds (15, 15, 60, 20);
        txtCountry.setBounds (75, 15, 100, 25);
        lblPos.setBounds (15, 50, 245, 25);
        posX.setBounds (250, 50, 45, 25);
        posY.setBounds (300, 50, 45, 25);


        
        //****************Save Butonu Click Event***********************
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				posX.getText();
			 	posY.getText();
				
			}
		});
        //**************************************************************         
       /* lblMap.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		posX.setText(String.valueOf(e.getX()));
        		posY.setText(String.valueOf(e.getY()));
        		btnSave.setEnabled(true);
        	}
		});   */
    }
}
