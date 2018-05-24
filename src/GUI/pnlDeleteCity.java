package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Lib.Center;
import Lib.City;
import Lib.FlightException;

public class pnlDeleteCity extends JPanel {
	private JLabel lblCountry;
    private JComboBox cmbCities;
    private JButton btnDelete;
    private Center CNTR;

    public pnlDeleteCity(Center CNTR) {
        //construct preComponents
    	this.CNTR=CNTR;
        lblCountry = new JLabel ("Þehirler:");
        cmbCities = new JComboBox();
        btnDelete = new JButton ("Sil");
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);
        add (lblCountry);
        add (cmbCities);
        add (btnDelete);

        lblCountry.setBounds (20, 20, 100, 25);
        cmbCities.setBounds (100, 20, 100, 25);
        btnDelete.setBounds (220, 20, 100, 25);
        btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CNTR.deleteCity((City)cmbCities.getSelectedItem());
					JOptionPane.showMessageDialog(null, "Þehir Silindi");
					update();
				} catch (FlightException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
    }
    
    public void fillCities()
	{
		
        cmbCities.setModel(new DefaultComboBoxModel<>(CNTR.getCities().toArray()));
        
	}
    public void update() {
    	fillCities();
    }
}
