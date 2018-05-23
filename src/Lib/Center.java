package Lib;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.Timer;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.MainWindow;
import GUI.pnlAddAirPort;
import GUI.pnlAddCountry;
import GUI.pnlAddFlight;
import GUI.pnlAddNewCo;
import GUI.pnlAddPlane;
import GUI.pnlMap;

public class Center implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Date timeNOW;
	private ArrayList<Flight> flights;
	private ArrayList<City> cities;
	private ArrayList<AirlinesCompany> comps;
	
	
	/**/
	public static TimeController timeController;
	private static javax.swing.Timer timePrinter;
	private static MainWindow mw;
	/**/
	public Center(Date d,ArrayList<Flight> flights, ArrayList<City> cities, ArrayList<AirlinesCompany> comps)
	{
		timeNOW = d;
		this.flights = flights;
		this.cities = cities;
		this.comps = comps;
	}
	public Center(Date d)
	{
		timeNOW = d;
		this.flights = new ArrayList<>();
		this.cities = new ArrayList<>();
		this.comps = new ArrayList<>();
	}

	public Date getTimeNOW() {
		return timeNOW;
	}
	public void setTimeNOW(Date timeNOW) {
		this.timeNOW = timeNOW;
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
	
	public ArrayList<AirlinesCompany> getCompanies()
	{
		return comps;
	}
	
	public void addCity(City c) throws FlightException
	{
		for(City cty : cities)
		{
			if(cty.getName().equals(c.getName()))
				throw new FlightException("Ayn� isimde �ehir eklenemez.");
		}
		cities.add(c);
	}
	
	public void deleteCity(City c) throws FlightException
	{
		for(Flight f : flights)
		{
			if(f.getArrAirport().getCity().equals(c) || f.getDepAirport().getCity().equals(c))
				throw new FlightException("Silmek istedi�iniz �ehirde u�u� bulunmaktad�r.");
		}
		cities.remove(c);
	}
	
	public void addFlight(Flight f) throws FlightException
	{
		for(Flight fl : flights)
		{
			if(fl.getID().equals(f.getID()))
				throw new FlightException("B�yle bir u�u� idsi zaten var.");
		}
		if(f.getDepDate().getTime() < new Date().getTime())
			throw new FlightException("Kalk�� tarihi ge�mi� bir tarih olamaz");
		flights.add(f);
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
	
	public void addCompany(AirlinesCompany ac) throws FlightException
	{
		for(AirlinesCompany c : comps)
		{
			if(c.getName().equals(ac.getName()))
				throw new FlightException("Ayn� isimde �irket eklenemez.");
		}
		comps.add(ac);
	}
	
	
	public static void main(String[] args) throws IOException {
		
			final Center CNTR;
			
			try {
				CNTR = getMyCenter();
				mw = new MainWindow(CNTR);
				timeController = new TimeController(CNTR);
				timePrinter = new javax.swing.Timer(1000, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						mw.setTitle(CNTR.getTimeNOW().toString());
						
					}
				});
				timePrinter.setInitialDelay(1000);
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
			C = new Center(new Date());
		}
		
		
		return C;
		
	}
	
	public static void saveMyCenter(Center c)
	{
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("deneme.dat"));
			output.writeObject(c);
			output.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
	
	public void startSimulation(Center c)
	{
		timeController.Work = true;
		timeController.start();
		timePrinter.start();
		new Thread(mw.getMjp()).start();
	}
	
	public void stopSimulation(Center c)
	{
		timeController.Work = false;
		timePrinter.stop();
	}
	
	
	
	
}
