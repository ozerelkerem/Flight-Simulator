package GUI;

import javax.swing.JPanel;
import javax.xml.bind.DatatypeConverterInterface;

import com.github.lgooddatepicker.components.DateTimePicker;

import Lib.AirlinesCompany;
import Lib.Center;
import Lib.FlightException;
import Lib.Helper;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.*;

public class pnlChangeSystemDateTime extends JPanel {
	private Center CNTR;
	private JLabel lblAirportCo;
    private DateTimePicker picker;
    private JButton btnSave;


	public pnlChangeSystemDateTime(Center cNTR) {
		// TODO Auto-generated constructor stub
		this.CNTR = cNTR;
		

        lblAirportCo = new JLabel ("Yeni Saat :");
        picker = new DateTimePicker();
        btnSave = new JButton ("Kaydet");
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);
        add(lblAirportCo);
        add(picker);
        add(btnSave);
        lblAirportCo.setBounds (15, 25, 100, 25);
        picker.setBounds (110, 25, 250, 25);
        btnSave.setBounds (115, 70, 100, 25);
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					LocalDateTime dt = LocalDateTime.now();
					Instant ldt = picker.getDateTimeStrict().toInstant(dt.atZone(ZoneId.systemDefault()).getOffset());
						Date out = Date.from(ldt);
					CNTR.changeSystemDateTime(out);
				}catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Alanlarý boþ býrakmayanýz.");
				
				} catch (FlightException fe) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, fe.getMessage());
				}
				Helper.clearTextFields(getComponents());	
			}
		});
	}


}
