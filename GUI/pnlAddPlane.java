package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Lib.Center;

public class pnlAddPlane extends JPanel {
	private Center CNTR;
	private JLabel lblAirportCo;
    private JButton btnSave;
    private JComboBox cmbCoList;
    private JTextField txtPlane;
    private JLabel lblPlane;

 

	public pnlAddPlane(Center cNTR) {
		// TODO Auto-generated constructor stub
		this.CNTR = cNTR;
		
		ArrayList<String> coList=new ArrayList<>(); // ArrayListini txt dosyadan doldur...
        lblAirportCo = new JLabel ("Þirket Adý:");
        btnSave = new JButton ("Kaydet");
        cmbCoList=new JComboBox<>();
        txtPlane = new JTextField (5);
        lblPlane = new JLabel ("Uçak Model:");
        cmbCoList.setModel(new DefaultComboBoxModel<>(coList.toArray())); //datasource
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);
        add(lblAirportCo);
        add(btnSave);
        add(cmbCoList);
        add(txtPlane);
        add(lblPlane);
        lblAirportCo.setBounds(15, 25, 100, 25);
        btnSave.setBounds(215, 45, 100, 25);
        cmbCoList.setBounds(95, 25, 100, 25);
        txtPlane.setBounds(95, 70, 100, 25);
        lblPlane.setBounds(15, 70, 100, 25);
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//kayýt butonu..
				//txtPlane.getText();
				
			}
		});
	}


}
