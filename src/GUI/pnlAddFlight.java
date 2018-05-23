package GUI;

import java.awt.Dimension;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.*;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;

import Lib.Aircraft;
import Lib.AirlinesCompany;
import Lib.Airport;
import Lib.Center;
import Lib.City;
import Lib.ControlTower;
import Lib.Flight;
import Lib.FlightException;
import Lib.FlightStatus;

public class pnlAddFlight extends JPanel{
	private Center CNTR;
	private JLabel lblAirportCo;
    private JButton btnSave;
    private JComboBox cmbCoList;
    private JLabel lblPlane;
    private JComboBox cmbPlaneList;
    private JComboBox cmbFrom;
    private JComboBox cmbTo;
    private JLabel lblFrom;
    private JLabel lblTo;
    private JLabel lblDateArr =  new JLabel("Kalkýþ Zamaný");
    private JComboBox cmbAirportList;
    private JLabel jcomp11;
    private JLabel jcomp12;
    private JComboBox cmbAirPortList2;

    private DateTimePicker DateLand = new DateTimePicker();



	public pnlAddFlight(Center cNTR2) {
		// TODO Auto-generated constructor stub
		this.CNTR = cNTR2;
        lblAirportCo = new JLabel ("Þirket Adý:");
        btnSave = new JButton ("Kaydet");
        cmbCoList=new JComboBox<>();
       
        lblPlane = new JLabel ("Uçak Model:");
        cmbPlaneList = new JComboBox<>();
        cmbFrom = new JComboBox<>();

        cmbTo = new JComboBox<>();

        lblFrom = new JLabel ("Nereden:");
        lblTo = new JLabel ("Nereye:");
        cmbAirportList = new JComboBox<>();

        jcomp11 = new JLabel ("Havalimaný:");
        jcomp12 = new JLabel ("Havalimaný:");
        cmbAirPortList2 = new JComboBox<>();

        setPreferredSize(new Dimension (944, 574));
        setLayout(null);
        add(DateLand);
        add(lblAirportCo);
        add(btnSave);
        add(cmbCoList);
        add(lblPlane);
        add(cmbPlaneList);
        add(cmbFrom);
        add(cmbTo);
        add(lblFrom);
        add(lblTo);
        add(cmbAirportList);
        add(jcomp11);
        add(jcomp12);
        add(cmbAirPortList2);
        add(lblDateArr);
        lblDateArr.setBounds(750, 25, 100, 25);
        DateLand.setBounds(750, 55, 240, 30);
        lblAirportCo.setBounds(515, 25, 100, 25);
        btnSave.setBounds(1000, 35, 100, 25);
        cmbCoList.setBounds(615, 25, 100, 25);
        lblPlane.setBounds(515, 55, 100, 25);
        cmbPlaneList.setBounds(615, 55, 100, 25);
        cmbFrom.setBounds(140, 25, 100, 25);
        cmbTo.setBounds(140, 65, 100, 25);
        lblFrom.setBounds(30, 25, 100, 25);
        lblTo.setBounds(30, 60, 100, 25);
        cmbAirportList.setBounds(355, 25, 100, 25);
        jcomp11.setBounds(265, 25, 100, 25);
        jcomp12.setBounds(265, 65, 100, 25);
        cmbAirPortList2.setBounds(355, 65, 100, 25);
        
    	fillCities();
    	
    	cmbFrom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				City c = ((City)cmbFrom.getSelectedItem());
						cmbAirportList.setModel(new DefaultComboBoxModel<>(c.getAirports().toArray()));
				
			}
		});
        
        
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Airport a1 = (Airport)cmbAirportList.getSelectedItem();
				Airport a2 =  (Airport)cmbAirPortList2.getSelectedItem();
				AirlinesCompany ac = (AirlinesCompany)cmbCoList.getSelectedItem();
			//	City c1 =(City)cmbFrom.getSelectedItem();
			//	City c2 =(City)cmbTo.getSelectedItem();
				Aircraft plane = (Aircraft)cmbPlaneList.getSelectedItem();
				
			//	Date date = DateLand.getDateTimePermissive().ofInstant(instant, zone)
				LocalDateTime dt = LocalDateTime.now();

				Instant ldt = DateLand.getDateTimeStrict().toInstant(dt.atZone(ZoneId.systemDefault()).getOffset());
				Date out = Date.from(ldt);

				Flight fli = new Flight("2",a1,a2,out,plane,FlightStatus.OnGround);
				
				try {
					CNTR.addFlight(fli);
				} catch (FlightException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			
				
				
			}
		});
	}
	public void fillCities()
	{
		
        cmbFrom.setModel(new DefaultComboBoxModel<>(CNTR.getCities().toArray()));
        cmbTo.setModel(new DefaultComboBoxModel<>(CNTR.getCities().toArray()));
	}
	
	public void update()
	{
		fillCities();
		if(cmbFrom.getItemCount() > 0 || cmbTo.getItemCount() > 0)
			fillAirpotLists((City)cmbFrom.getSelectedItem(), (City)cmbTo.getSelectedItem());
		cmbCoList.setModel(new DefaultComboBoxModel<>(CNTR.getCompanies().toArray()));
		if(cmbCoList.getItemCount() > 0)
			fillPlanes((AirlinesCompany) cmbCoList.getSelectedItem());
		
	}
	
	public void fillPlanes(AirlinesCompany ac)
	{
		 cmbPlaneList.setModel(new DefaultComboBoxModel<>(ac.getAircrafts().toArray()));
	}
	
	public void fillAirpotLists(City c1,City c2)
	{
		cmbAirportList.setModel(new DefaultComboBoxModel<>(c1.getAirports().toArray()));
		cmbAirPortList2.setModel(new DefaultComboBoxModel<>(c2.getAirports().toArray()));
	}
}
