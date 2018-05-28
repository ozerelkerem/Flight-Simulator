package GUI;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

import Lib.Airport;
import Lib.Center;
import Lib.City;
import Lib.ControlTower;
import Lib.Helper;
public class pnlAddAirPort extends JPanel {
	private Center CNTR;
	private JComboBox cmbBoxCities;
    private JLabel lblSelectCountry;
    private JLabel lblAirPort;
    private JTextField txtAirPort;
    private JTextField txtTakeOffDelay;
    private JTextField txtLandingDelay;
    private JLabel lblTakeOffDelay;
    private JLabel lblLandingDelay;
    private JButton btnSave;


	public pnlAddAirPort(Center cNTR) {
		// TODO Auto-generated constructor stub
		this.CNTR = cNTR;
		cmbBoxCities = new JComboBox<>();
        lblSelectCountry = new JLabel ("Þehir Seç:");
        lblAirPort = new JLabel ("Havalimaný Adý:");
        txtAirPort = new JTextField (5);
        txtTakeOffDelay = new JTextField (5);
        txtLandingDelay = new JTextField (5);
        lblTakeOffDelay = new JLabel ("Kalkýþ Gecikmesi:");
        lblLandingDelay = new JLabel ("Ýniþ Gecikmesi:");
        btnSave = new JButton ("Kaydet");
        cmbBoxCities=new JComboBox<>();
        setPreferredSize (new Dimension (755, 540));
        setLayout (null);
        add(cmbBoxCities);
        add(lblSelectCountry);
        add(lblAirPort);
        add(txtAirPort);
        add(txtTakeOffDelay);
        add(txtLandingDelay);
        add(lblTakeOffDelay);
        add(lblLandingDelay);
        add(btnSave);
        cmbBoxCities.setBounds (145, 15, 100, 25);
        lblSelectCountry.setBounds (15, 15, 100, 25);
        lblAirPort.setBounds (15, 55, 100, 25);
        txtAirPort.setBounds (145, 50, 100, 25);
        txtTakeOffDelay.setBounds (145, 95, 100, 25);
        lblTakeOffDelay.setBounds (15, 95, 120, 25);
        btnSave.setBounds(350, 80, 100, 20);
        txtLandingDelay.setBounds (420, 20, 100, 20);
        lblLandingDelay.setBounds (305, 20, 140, 20);
        //***************save click event*************
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				City c = (City) cmbBoxCities.getSelectedItem();
				ControlTower ct = new ControlTower(Integer.parseInt(txtLandingDelay.getText()), Integer.parseInt(txtTakeOffDelay.getText()));
				c.addAirport(new Airport(txtAirPort.getText(), c, ct));
				Center.timeController.addTowerToPool(ct);
				JOptionPane.showMessageDialog(null, "Havalimaný Eklendi.");
		
				Helper.clearTextFields(getComponents());
			}
		});
	}
	public void update()
	{
        cmbBoxCities.setModel(new DefaultComboBoxModel<>(CNTR.getCities().toArray()));
	}
    
}
