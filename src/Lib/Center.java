package Lib;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.pnlAddAirPort;
import GUI.pnlAddCountry;
import GUI.pnlAddFlight;
import GUI.pnlAddNewCo;
import GUI.pnlAddPlane;
import GUI.pnlMap;

public class Center implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<Flight> flights;
	private ArrayList<City> cities;
	private ArrayList<AirlinesCompany> comps;
	
	public Center(ArrayList<Flight> flights, ArrayList<City> cities)
	{
		this.flights = flights;
		this.cities = cities;
	}
	public Center()
	{
		this.flights = new ArrayList<>();
		this.cities = new ArrayList<>();
	}

	public ArrayList<Flight> getFlights()
	{
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights)
	{
		this.flights = flights;
	}

	public ArrayList<City> getCities()
	{
		return cities;
	}

	public void setCities(ArrayList<City> cities)
	{
		this.cities = cities;
	}
	
	public boolean addCity(City c)
	{
		for(City cty : cities)
		{
			if(cty.getName().equals(c.getName()))
				return false;
		}
		cities.add(c);
		return true;
	}
	
	public boolean deleteCity(City c)
	{
		for(Flight f : flights)
		{
			if(f.getArrAirport().getCity().equals(c) || f.getDepAirport().getCity().equals(c))
				return false;
		}
		cities.remove(c);
		return true;
	}
	
	public boolean addFlight(Flight f) throws FlightException
	{
		flights.add(f);
		return true;
	}
	
	public boolean addDelayToFlight(Flight f, int min)
	{
		/*todo*/
		return true;
	}
	
	public boolean cancelFlight(Flight f)
	{
		/*todo*/
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		
			final Center CNTR;
			try {
				CNTR = getMyCenter();
		int x = LocalDateTime.from(new Date().toInstant().atZone(ZoneId.of("UTC"))).plusDays(21).getDayOfMonth();
				JFrame frame = new JFrame (String.valueOf(x));
				frame.getContentPane().setLayout(null);
				pnlMap mjp = new pnlMap("map.jpg",pnlAddCountry.posX,pnlAddCountry.posY,CNTR);
		        mjp.setLocation(0, 400);
		        mjp.setBounds(0,150, 1920, 1013);
				JTabbedPane tb=new JTabbedPane();
				tb.setBounds(0, 0, 1920, 150);
		        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		        pnlAddCountry p1 = new pnlAddCountry(CNTR);
		        pnlAddAirPort p2 = new pnlAddAirPort(CNTR);
				tb.addTab("Þehir Ekle", p1);
		        tb.addTab("HavaLimaný Ekle", p2);
		        tb.addTab("Havalimaný Þirket Ekle", new pnlAddNewCo(CNTR));
		        tb.addTab("Þirkete Uçak Ekle", new pnlAddPlane(CNTR));
		        tb.addTab("Uçuþ Ekle", new pnlAddFlight(CNTR));
		        frame.getContentPane().add(tb);
		        frame.getContentPane().add(mjp);
		        frame.pack();
		        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		        frame.setVisible (true);
		        tb.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						p2.update();

						try {
							ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("deneme.dat"));
							output.writeObject(CNTR);
							output.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
						
					}
				});;
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
		}
	
	public static Center getMyCenter() throws ClassNotFoundException
	{
		Center C;
		ObjectInputStream input;
		try {
			input = new ObjectInputStream(new  FileInputStream("deneme.dat"));
			C =(Center)input.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			C = new Center();
		}
		
		
		return C;
		
	}
	
	
	
	
}
