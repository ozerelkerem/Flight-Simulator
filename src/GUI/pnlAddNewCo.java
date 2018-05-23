package GUI;

import javax.swing.JPanel;

import Lib.AirlinesCompany;
import Lib.Center;
import Lib.FlightException;
import Lib.Helper;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pnlAddNewCo extends JPanel {
	private Center CNTR;
	private JLabel lblAirportCo;
    private JTextField txtAirportCo;
    private JButton btnSave;


	public pnlAddNewCo(Center cNTR) {
		// TODO Auto-generated constructor stub
		this.CNTR = cNTR;
		

        lblAirportCo = new JLabel ("Þirket Adý:");
        txtAirportCo = new JTextField (5);
        btnSave = new JButton ("Kaydet");
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);
        add(lblAirportCo);
        add(txtAirportCo);
        add(btnSave);
        lblAirportCo.setBounds (15, 25, 100, 25);
        txtAirportCo.setBounds (110, 25, 100, 25);
        btnSave.setBounds (115, 70, 100, 25);
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CNTR.addCompany(new AirlinesCompany(txtAirportCo.getText()));
				} catch (FlightException fe) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, fe.getMessage());
				}
				Helper.clearTextFields(getComponents());	
			}
		});
	}


}
