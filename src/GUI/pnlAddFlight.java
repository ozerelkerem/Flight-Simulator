package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;

import Lib.Center;

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
    private JComboBox cmbAirportList;
    private JLabel jcomp11;
    private JLabel jcomp12;
    private JComboBox cmbAirPortList2;

    private DatePicker datePicker1 = new DatePicker();


    // Create a time picker, and add it to the form.
    private TimePicker timePicker1 = new TimePicker();


	public pnlAddFlight(Center cNTR2) {
		// TODO Auto-generated constructor stub
		this.CNTR = cNTR2;
    	ArrayList<String> coList=new ArrayList<>();
    	ArrayList<String> planeList=new ArrayList<>();
    	ArrayList<String> countryList=new ArrayList<>();
    	ArrayList<String> airportList=new ArrayList<>();
        lblAirportCo = new JLabel ("Þirket Adý:");
        btnSave = new JButton ("Kaydet");
        cmbCoList=new JComboBox<>();
        cmbCoList.setModel(new DefaultComboBoxModel<>(coList.toArray()));
        lblPlane = new JLabel ("Uçak Model:");
        cmbPlaneList = new JComboBox<>();
        cmbPlaneList.setModel(new DefaultComboBoxModel<>(planeList.toArray()));
        cmbFrom = new JComboBox<>();
        cmbFrom.setModel(new DefaultComboBoxModel<>(countryList.toArray()));
        cmbTo = new JComboBox<>();
        cmbTo.setModel(new DefaultComboBoxModel<>(countryList.toArray()));
        lblFrom = new JLabel ("Nereden:");
        lblTo = new JLabel ("Nereye:");
        cmbAirportList = new JComboBox<>();
        cmbAirportList.setModel(new DefaultComboBoxModel<>(airportList.toArray()));
        jcomp11 = new JLabel ("Havalimaný:");
        jcomp12 = new JLabel ("Havalimaný:");
        cmbAirPortList2 = new JComboBox<>();
        cmbAirPortList2.setModel(new DefaultComboBoxModel<>(airportList.toArray()));
        setPreferredSize(new Dimension (944, 574));
        setLayout(null);
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
        add(datePicker1);
        add(timePicker1);
        datePicker1.setBounds(700, 10, 150, 30);
        timePicker1.setBounds(900, 20, 80, 30);
        lblAirportCo.setBounds(515, 25, 100, 25);
        btnSave.setBounds(835, 35, 100, 25);
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
        btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * Bu þekilde seçilene eriþip kayýt iþlemi gerçekleþtir.
				cmbAirportList.getSelectedItem();
				cmbAirPortList2.getSelectedItem();
				cmbCoList.getSelectedItem();
				cmbFrom.getSelectedItem();
				cmbTo.getSelectedItem();
				cmbPlaneList.getSelectedItem();
				*/
				getDestinationDate();
				
				
			}
		});
	}
	public void getDestinationDate()
	{
	System.out.println(datePicker1.getDate());
	System.out.println(timePicker1.getTime());
	}

}
