package GUI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class pnlAddAirPort extends JPanel {
	private JComboBox cmbBoxCities;
    private JLabel lblSelectCountry;
    private JLabel lblAirPort;
    private JTextField txtAirPort;
    private JTextField txtTakeOffDelay;
    private JTextField txtLandingDelay;
    private JLabel lblTakeOffDelay;
    private JLabel lblLandingDelay;
    private JButton btnSave;

    public pnlAddAirPort()
    {
    	ArrayList<String> citiesList=new ArrayList<>(); // ArrayListini txt dosyadan doldur...
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
        cmbBoxCities.setModel(new DefaultComboBoxModel<>(citiesList.toArray()));
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
        txtLandingDelay.setBounds (145, 145, 100, 25);
        lblTakeOffDelay.setBounds (15, 95, 120, 25);
        lblLandingDelay.setBounds (15, 145, 100, 25);
        btnSave.setBounds (145, 195, 100, 25);
        
        //***************save click event*************
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// seçili olan string cmbBoxCities.getSelectedObjects());
				
			}
		});
    }
    
}
